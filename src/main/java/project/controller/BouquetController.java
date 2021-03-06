package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.model.Bouquet;
import project.model.BouquetOrder;
import project.model.Order;
import project.model.User;
import project.service.Service;

import java.util.Iterator;

@Controller
public class BouquetController {
    private Service bouquetService;
    private static User currentUser;

    @Autowired(required = true)
    @Qualifier(value = "bouquetService")
    public void setBouquetService(Service bouquetService) {
        this.bouquetService = bouquetService;
    }


    @RequestMapping(value = "/bouquets/add", method = RequestMethod.POST)
    public String addBouquet(@ModelAttribute("bouquet") Bouquet bouquet) {
        if (bouquet.getId() == null) {
            this.bouquetService.add(bouquet);
        } else {
            this.bouquetService.update(bouquet);
        }

        return "redirect:/bouquets_admin";
    }

    @RequestMapping("editBouquet/{id}")
    public String editBouquet(@PathVariable("id") int id, Model model) {
        model.addAttribute("bouquet", this.bouquetService.getById(id));
        model.addAttribute("listBouquets", this.bouquetService.list());

        return "bouquets_admin";
    }

    @RequestMapping("/removeBouquet/{id}")
    public String removeBouquet(@PathVariable("id") int id) {
        this.bouquetService.remove(id);

        return "redirect:/bouquets_admin";
    }

    @RequestMapping(value = "bouquets_admin", method = RequestMethod.GET)
    public String listBouquets(Model model) {
        currentUser = UserController.getCurrentUser(model);
        if(currentUser!=null) {
            UserController.getCurrentUser(model);
            model.addAttribute("bouquet", new Bouquet());
            model.addAttribute("listBouquets", this.bouquetService.list());

            return "bouquets_admin";
        }
        else
            return "";
    }

    @RequestMapping(value = "bouquets_client", method = RequestMethod.GET)
    public String listBouquetsClient(Model model) {
        UserController.getCurrentUser(model);
        model.addAttribute("bouquetOrder", new BouquetOrder());
        model.addAttribute("bouquet", new Bouquet());
        model.addAttribute("listBouquets", this.bouquetService.list());

        return "bouquets_client";
    }

    @RequestMapping(value = "/order/addBouquet", method = RequestMethod.POST)
    public String addBouquet(@ModelAttribute("bouquetOrder") BouquetOrder bouquetOrder) {
        if (bouquetOrder.getQuantity() < 1) {
            return "redirect:/bouquets_client";
        }

        if (OrderController.getCurrentOrder() == null) {
            OrderController.setCurrentOrder(new Order());
        }

        Iterator<BouquetOrder> iterator = OrderController.getCurrentOrder().getBouquetOrdersById().iterator();
        while (iterator.hasNext()) {
            BouquetOrder order = iterator.next();
            if (order.getBouquetId().equals(bouquetOrder.getBouquetId())) {
                order.setQuantity(order.getQuantity() + bouquetOrder.getQuantity());

                OrderController.getCurrentOrder().setCost(OrderController.getCurrentOrder().getCost() +
                        order.getBouquetByBouquetId().getPrice() * bouquetOrder.getQuantity());

                order.getBouquetByBouquetId().setAmount(order.getBouquetByBouquetId().getAmount() - bouquetOrder.getQuantity());
                bouquetService.update(order.getBouquetByBouquetId());
                return "redirect:/bouquets_client";
            }
        }
        bouquetOrder.setBouquetByBouquetId((Bouquet) bouquetService.getById(bouquetOrder.getBouquetId()));
        bouquetOrder.getBouquetByBouquetId().setAmount(bouquetOrder.getBouquetByBouquetId().getAmount() - bouquetOrder.getQuantity());
        bouquetService.update(bouquetOrder.getBouquetByBouquetId());

        OrderController.getCurrentOrder().getBouquetOrdersById().add(bouquetOrder);

        OrderController.getCurrentOrder().setCost(OrderController.getCurrentOrder().getCost() +
                bouquetOrder.getBouquetByBouquetId().getPrice() * bouquetOrder.getQuantity());

        return "redirect:/bouquets_client";
    }
}