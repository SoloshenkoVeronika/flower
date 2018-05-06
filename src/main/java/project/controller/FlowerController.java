package project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.model.*;
import project.service.Service;

import java.util.ArrayList;
import java.util.Iterator;

@Controller
public class FlowerController {
    private Service flowerService;

    @Autowired(required = true)
    @Qualifier(value = "flowerService")
    public void setFlowerService(Service flowerService) {
        this.flowerService = flowerService;
    }


    @RequestMapping(value = "/flowers/add", method = RequestMethod.POST)
    public String addFlower(@ModelAttribute("flower") Flower flower) {
        if (flower.getId() == null) {
            this.flowerService.add(flower);
        } else {
            this.flowerService.update(flower);
        }

        return "redirect:/flowers_admin";
    }

    @RequestMapping("editFlower/{id}")
    public String editFlower(@PathVariable("id") int id, Model model) {
        model.addAttribute("flower", this.flowerService.getById(id));
        model.addAttribute("listFlowers", this.flowerService.list());

        return "flowers_admin";
    }

    @RequestMapping("/removeFlower/{id}")
    public String removeFlower(@PathVariable("id") int id) {
        this.flowerService.remove(id);

        return "redirect:/flowers_admin";
    }

    @RequestMapping(value = "flowers_admin", method = RequestMethod.GET)
    public String listFlowers(Model model) {
        UserController.getCurrentUser(model);
        model.addAttribute("flower", new Flower());
        model.addAttribute("listFlowers", this.flowerService.list());

        return "flowers_admin";
    }

    @RequestMapping(value = "flowers_client", method = RequestMethod.GET)
    public String listFlowersClient(Model model) {
        UserController.getCurrentUser(model);
        model.addAttribute("flowerOrder", new FlowerOrder());
        model.addAttribute("flower", new Flower());
        model.addAttribute("listFlowers", this.flowerService.list());

        return "flowers_client";
    }

    @RequestMapping(value = "/order/addFlower", method = RequestMethod.POST)
    public String addFlower(@ModelAttribute("flowerOrder") FlowerOrder flowerOrder) {
        if (flowerOrder.getQuantity() < 1) {
            return "redirect:/flowers_client";
        }

        if (OrderController.getCurrentOrder() == null) {
            OrderController.setCurrentOrder(new Order());
        }

        Iterator<FlowerOrder> iterator = OrderController.getCurrentOrder().getFlowerOrdersById().iterator();
        while (iterator.hasNext()) {
            FlowerOrder order = iterator.next();
            if (order.getFlowerId().equals(flowerOrder.getFlowerId())) {
                order.setQuantity(order.getQuantity() + flowerOrder.getQuantity());

                OrderController.getCurrentOrder().setCost(OrderController.getCurrentOrder().getCost() +
                        order.getFlowerByFlowerId().getPrice() * flowerOrder.getQuantity());
                return "redirect:/flowers_client";
            }
        }
        flowerOrder.setFlowerByFlowerId((Flower) flowerService.getById(flowerOrder.getFlowerId()));
        OrderController.getCurrentOrder().getFlowerOrdersById().add(flowerOrder);

        OrderController.getCurrentOrder().setCost(OrderController.getCurrentOrder().getCost() +
                flowerOrder.getFlowerByFlowerId().getPrice() * flowerOrder.getQuantity());

        return "redirect:/flowers_client";
    }

    @RequestMapping(value = "customer_bouquets_flower", method = RequestMethod.GET)
    public String listCustomerBouquetFlowers(Model model) {
        UserController.getCurrentUser(model);
        model.addAttribute("flowerCustomerBouquet", new FlowerCustomerBouquet());
        model.addAttribute("flower", new Flower());
        model.addAttribute("listFlowers", this.flowerService.list());

        return "customer_bouquets_flower";
    }

    @RequestMapping(value = "/order/addFlowerToCustomerBouquet", method = RequestMethod.POST)
    public String addFlowerToCustomerBouquet(@ModelAttribute("flowerCustomerBouquet") FlowerCustomerBouquet flowerCustomerBouquet) {
        if (flowerCustomerBouquet.getQuantity() < 1) {
            return "redirect:/customer_bouquets_flower";
        }

        if (OrderController.getCurrentOrder() == null) {
            OrderController.setCurrentOrder(new Order());
        }
        if (OrderController.getCustomerBouquet() == null) {
            //if(OrderController.getCurrentOrder().getCustomerBouquetOrdersById() == null)
            //OrderController.getCurrentOrder().setCustomerBouquetOrdersById(new ArrayList<>());
            OrderController.setCustomerBouquet(new CustomerBouquet());
            //currentOrder.getCustomerBouquetOrdersById().add()
        }
        if (OrderController.getCustomerBouquet().getFlowerCustomerBouquetsById() == null) {
            OrderController.getCustomerBouquet().setFlowerCustomerBouquetsById(new ArrayList<>());
        }

        ArrayList<CustomerBouquetOrder> customerBouquetOrders = new ArrayList<>(OrderController.getCurrentOrder().getCustomerBouquetOrdersById());
        if (!OrderController.isCustomerBouquetEmpty() &&
                //OrderController.getCurrentOrder().getCustomerBouquetOrdersById() != null &&
                customerBouquetOrders.get(customerBouquetOrders.size() - 1).
                        getCustomerBouquetByCustomerBouquetId().getFlowerCustomerBouquetsById() == null) {
            customerBouquetOrders.get(customerBouquetOrders.size() - 1).
                    getCustomerBouquetByCustomerBouquetId().setFlowerCustomerBouquetsById(new ArrayList<>());
        }


        if (OrderController.getCustomerBouquet().getFlowerCustomerBouquetsById().size() != 0) {
            Iterator<FlowerCustomerBouquet> iterator = OrderController.getCustomerBouquet().getFlowerCustomerBouquetsById().iterator();
            while (iterator.hasNext()) {
                FlowerCustomerBouquet customerBouquet = iterator.next();
                if (customerBouquet.getFlowerId().equals(flowerCustomerBouquet.getFlowerId())) {
                    customerBouquet.setQuantity(customerBouquet.getQuantity() + flowerCustomerBouquet.getQuantity());

                    OrderController.getCurrentOrder().setCost(OrderController.getCurrentOrder().getCost() +
                            customerBouquet.getFlowerByFlowerId().getPrice() * flowerCustomerBouquet.getQuantity());

                    /*ArrayList<CustomerBouquetOrder> customerBouquetOrders = new ArrayList<>(OrderController.getCurrentOrder().getCustomerBouquetOrdersById());
                    CustomerBouquetOrder order = customerBouquetOrders.get(customerBouquetOrders.size()-1);
                    Iterator<FlowerCustomerBouquet> it = order.getCustomerBouquetByCustomerBouquetId().getFlowerCustomerBouquetsById().iterator();
                    while (it.hasNext()) {
                        FlowerCustomerBouquet bouquet = it.next();
                        if (bouquet.getFlowerId().equals(flowerCustomerBouquet.getFlowerId())) {
                            bouquet.setQuantity(bouquet.getQuantity() + flowerCustomerBouquet.getQuantity());
                            return "redirect:/customer_bouquets_flower";
                        }
                    }*/
                    return "redirect:/customer_bouquets_flower";
                }
            }
        }

        Flower flower = (Flower) flowerService.getById(flowerCustomerBouquet.getFlowerId());
        flowerCustomerBouquet.setFlowerByFlowerId(flower);

        OrderController.getCurrentOrder().setCost(OrderController.getCurrentOrder().getCost() +
                flowerCustomerBouquet.getFlowerByFlowerId().getPrice() * flowerCustomerBouquet.getQuantity());

        if (OrderController.isCustomerBouquetEmpty()) {
            //if (OrderController.getCurrentOrder().getCustomerBouquetOrdersById().size() == 0){
            ArrayList<FlowerCustomerBouquet> bouquets = new ArrayList<>();
            bouquets.add(flowerCustomerBouquet);

            CustomerBouquet customerBouquet = new CustomerBouquet();
            customerBouquet.setFlowerCustomerBouquetsById(bouquets);

            CustomerBouquetOrder bouquetOrder = new CustomerBouquetOrder();
            bouquetOrder.setCustomerBouquetByCustomerBouquetId(customerBouquet);

            OrderController.getCurrentOrder().getCustomerBouquetOrdersById().add(bouquetOrder);
        } else {
            customerBouquetOrders.get(customerBouquetOrders.size() - 1).
                    getCustomerBouquetByCustomerBouquetId().getFlowerCustomerBouquetsById().add(flowerCustomerBouquet);
        }

        OrderController.getCustomerBouquet().getFlowerCustomerBouquetsById().add(flowerCustomerBouquet);

        return "redirect:/customer_bouquets_flower";
    }
}
