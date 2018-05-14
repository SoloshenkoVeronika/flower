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
public class PackController {
    private Service packService;
    private static User currentUser;

    @Autowired(required = true)
    @Qualifier(value = "packService")
    public void setPackService(Service packService) {
        this.packService = packService;
    }


    @RequestMapping(value = "/packs/add", method = RequestMethod.POST)
    public String addPack(@ModelAttribute("pack") Pack pack){
        if(pack.getId() == null){
            this.packService.add(pack);
        }else {
            this.packService.update(pack);
        }

        return "redirect:/packs_admin";
    }

    @RequestMapping("editPack/{id}")
    public String editPack(@PathVariable("id") int id, Model model){
        model.addAttribute("pack", this.packService.getById(id));
        model.addAttribute("listPacks", this.packService.list());

        return "packs_admin";
    }

    @RequestMapping("/removePack/{id}")
    public String removePack(@PathVariable("id") int id){
        this.packService.remove(id);

        return "redirect:/packs_admin";
    }

    @RequestMapping(value = "packs_admin", method = RequestMethod.GET)
    public String listPacks(Model model){
        currentUser = UserController.getCurrentUser(model);
        if(currentUser!=null) {
            UserController.getCurrentUser(model);
            model.addAttribute("pack", new Pack());
            model.addAttribute("listPacks", this.packService.list());

            return "packs_admin";
        }
        else
            return "";
    }


    @RequestMapping(value = "customer_bouquets_pack", method = RequestMethod.GET)
    public String listCustomerBouquetPacks(Model model){
        UserController.getCurrentUser(model);
        model.addAttribute("pack", new Pack());
        model.addAttribute("listPacks", this.packService.list());

        return "customer_bouquets_pack";
    }

    @RequestMapping(value = "/order/addPackToCustomerBouquet", method = RequestMethod.POST)
    public String addPackToCustomerBouquet(@ModelAttribute("packCustomerBouquet") Pack pack){
        if (OrderController.getCurrentOrder() == null){
            OrderController.setCurrentOrder(new Order());
        }
        if (OrderController.getCustomerBouquet() == null){
            OrderController.setCustomerBouquet(new CustomerBouquet());
        }

        pack = (Pack) packService.getById(pack.getId());

        OrderController.getCustomerBouquet().setPackId(pack.getId());
        OrderController.getCustomerBouquet().setPackByPackId(pack);
        double t = pack.getPrice();

        ArrayList<CustomerBouquetOrder> customerBouquetOrders = new ArrayList<>(OrderController.getCurrentOrder().getCustomerBouquetOrdersById());
        if (OrderController.getCurrentOrder().getCustomerBouquetOrdersById() != null &&
                OrderController.getCurrentOrder().getCustomerBouquetOrdersById().size() != 0){

            if (customerBouquetOrders.get(customerBouquetOrders.size() - 1).
                    getCustomerBouquetByCustomerBouquetId().getPackByPackId() != null) {
                OrderController.getCurrentOrder().setCost(OrderController.getCurrentOrder().getCost() -
                        customerBouquetOrders.get(customerBouquetOrders.size() - 1).
                        getCustomerBouquetByCustomerBouquetId().getPackByPackId().getPrice());
            }

            customerBouquetOrders.get(customerBouquetOrders.size() - 1).
                    getCustomerBouquetByCustomerBouquetId().setPackByPackId(pack);

            OrderController.getCurrentOrder().setCost(OrderController.getCurrentOrder().getCost() +
                    pack.getPrice());

            return "redirect:/customer_bouquets_pack";
        }
        CustomerBouquet bouquet = new CustomerBouquet();
        bouquet.setPackId(pack.getId());
        bouquet.setPackByPackId(pack);

        CustomerBouquetOrder order = new CustomerBouquetOrder();
        order.setCustomerBouquetByCustomerBouquetId(bouquet);
        OrderController.getCurrentOrder().getCustomerBouquetOrdersById().add(order);

        OrderController.getCurrentOrder().setCost(OrderController.getCurrentOrder().getCost() +
                (double)pack.getPrice());

        return "redirect:/customer_bouquets_pack";
    }
}

