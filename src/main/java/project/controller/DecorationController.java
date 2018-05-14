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
public class DecorationController {
    private Service decorationService;
    private  static User currentUser;
    @Autowired(required = true)
    @Qualifier(value = "decorationService")
    public void setDecorationService(Service decorationService) {
        this.decorationService = decorationService;
    }


    @RequestMapping(value = "/decorations/add", method = RequestMethod.POST)
    public String addDecoration(@ModelAttribute("decoration") Decoration decoration) {
        if (decoration.getId() == null) {
            this.decorationService.add(decoration);
        } else {
            this.decorationService.update(decoration);
        }

        return "redirect:/decorations_admin";
    }

    @RequestMapping("editDecoration/{id}")
    public String editDecoration(@PathVariable("id") int id, Model model) {
        model.addAttribute("decoration", this.decorationService.getById(id));
        model.addAttribute("listDecorations", this.decorationService.list());

        return "decorations_admin";
    }

    @RequestMapping("/removeDecoration/{id}")
    public String removeDecoration(@PathVariable("id") int id) {
        this.decorationService.remove(id);

        return "redirect:/decorations_admin";
    }

    @RequestMapping(value = "decorations_admin", method = RequestMethod.GET)
    public String listDecorations(Model model) {
        currentUser = UserController.getCurrentUser(model);
        if(currentUser!=null) {
            UserController.getCurrentUser(model);
            model.addAttribute("decoration", new Decoration());
            model.addAttribute("listDecorations", this.decorationService.list());
            return "decorations_admin";
        }
        else return"";
    }


    @RequestMapping(value = "customer_bouquets_decoration", method = RequestMethod.GET)
    public String listCustomerBouquetDecorations(Model model) {
        UserController.getCurrentUser(model);
        model.addAttribute("decorationCustomerBouquet", new DecorationCustomerBouquet());
        model.addAttribute("decoration", new Decoration());
        model.addAttribute("listDecorations", this.decorationService.list());

        return "customer_bouquets_decoration";
    }

    @RequestMapping(value = "/order/addDecorationToCustomerBouquet", method = RequestMethod.POST)
    public String addFlowerToCustomerBouquet(@ModelAttribute("decorationCustomerBouquet") DecorationCustomerBouquet decorationCustomerBouquet) {
        if (decorationCustomerBouquet.getQuantity() < 1) {
            return "redirect:/customer_bouquets_decoration";
        }

        if (OrderController.getCurrentOrder() == null) {
            OrderController.setCurrentOrder(new Order());
        }
        if (OrderController.getCustomerBouquet() == null) {
            OrderController.setCustomerBouquet(new CustomerBouquet());
        }
        if (OrderController.getCustomerBouquet().getDecorationCustomerBouquetsById() == null) {
            OrderController.getCustomerBouquet().setDecorationCustomerBouquetsById(new ArrayList<>());
        }
        ArrayList<CustomerBouquetOrder> customerBouquetOrders = new ArrayList<>(OrderController.getCurrentOrder().getCustomerBouquetOrdersById());
        if (!OrderController.isCustomerBouquetEmpty() &&
                //OrderController.getCurrentOrder().getCustomerBouquetOrdersById() != null &&
                customerBouquetOrders.get(customerBouquetOrders.size() - 1).
                        getCustomerBouquetByCustomerBouquetId().getDecorationCustomerBouquetsById() == null) {
            customerBouquetOrders.get(customerBouquetOrders.size() - 1).
                    getCustomerBouquetByCustomerBouquetId().setDecorationCustomerBouquetsById(new ArrayList<>());
        }


        if (OrderController.getCustomerBouquet().getDecorationCustomerBouquetsById().size() != 0) {
            Iterator<DecorationCustomerBouquet> iterator = OrderController.getCustomerBouquet().getDecorationCustomerBouquetsById().iterator();
            while (iterator.hasNext()) {
                DecorationCustomerBouquet customerBouquet = iterator.next();
                if (customerBouquet.getDecorationId().equals(decorationCustomerBouquet.getDecorationId())) {
                    customerBouquet.setQuantity(customerBouquet.getQuantity() + decorationCustomerBouquet.getQuantity());

                    OrderController.getCurrentOrder().setCost(OrderController.getCurrentOrder().getCost() +
                            customerBouquet.getDecorationByDecorationId().getPrice() * decorationCustomerBouquet.getQuantity());

                    return "redirect:/customer_bouquets_decoration";
                }
            }
        }

        Decoration decoration = (Decoration) decorationService.getById(decorationCustomerBouquet.getDecorationId());
        decorationCustomerBouquet.setDecorationByDecorationId(decoration);

        OrderController.getCurrentOrder().setCost(OrderController.getCurrentOrder().getCost() +
                decorationCustomerBouquet.getDecorationByDecorationId().getPrice() * decorationCustomerBouquet.getQuantity());

        if (OrderController.isCustomerBouquetEmpty()) {
            ArrayList<DecorationCustomerBouquet> bouquets = new ArrayList<>();
            bouquets.add(decorationCustomerBouquet);

            CustomerBouquet customerBouquet = new CustomerBouquet();
            customerBouquet.setDecorationCustomerBouquetsById(bouquets);

            CustomerBouquetOrder bouquetOrder = new CustomerBouquetOrder();
            bouquetOrder.setCustomerBouquetByCustomerBouquetId(customerBouquet);

            OrderController.getCurrentOrder().getCustomerBouquetOrdersById().add(bouquetOrder);
        } else {
            customerBouquetOrders.get(customerBouquetOrders.size() - 1).
                    getCustomerBouquetByCustomerBouquetId().getDecorationCustomerBouquetsById().add(decorationCustomerBouquet);
        }

        OrderController.getCustomerBouquet().getDecorationCustomerBouquetsById().add(decorationCustomerBouquet);

        return "redirect:/customer_bouquets_decoration";
    }
}

