package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.model.Composition;
import project.model.CompositionOrder;
import project.model.Order;
import project.model.User;
import project.service.Service;

import java.util.Iterator;

@Controller
public class CompositionController {
    private Service compositionService;
    private static User currentUser;

    @Autowired(required = true)
    @Qualifier(value = "compositionService")
    public void setCompositionService(Service compositionService) {
        this.compositionService = compositionService;
    }


    @RequestMapping(value = "/compositions/add", method = RequestMethod.POST)
    public String addComposition(@ModelAttribute("composition") Composition composition) {
        if (composition.getId() == null) {
            this.compositionService.add(composition);
        } else {
            this.compositionService.update(composition);
        }

        return "redirect:/compositions_admin";
    }

    @RequestMapping("editComposition/{id}")
    public String editComposition(@PathVariable("id") int id, Model model) {
        model.addAttribute("composition", this.compositionService.getById(id));
        model.addAttribute("listCompositions", this.compositionService.list());

        return "compositions_admin";
    }

    @RequestMapping("/removeComposition/{id}")
    public String removeComposition(@PathVariable("id") int id) {
        this.compositionService.remove(id);

        return "redirect:/compositions_admin";
    }

    @RequestMapping(value = "compositions_admin", method = RequestMethod.GET)
    public String listCompositions(Model model) {
        currentUser = UserController.getCurrentUser(model);
        if(currentUser!=null) {
            UserController.getCurrentUser(model);
            model.addAttribute("composition", new Composition());
            model.addAttribute("listCompositions", this.compositionService.list());

            return "compositions_admin";
        }
        else
            return "";
    }

    @RequestMapping(value = "compositions_client", method = RequestMethod.GET)
    public String listCompositionsClient(Model model) {
        UserController.getCurrentUser(model);
        model.addAttribute("compositionOrder", new CompositionOrder());
        model.addAttribute("composition", new Composition());
        model.addAttribute("listCompositions", this.compositionService.list());

        return "compositions_client";
    }

    @RequestMapping(value = "/order/addComposition", method = RequestMethod.POST)
    public String addComposition(@ModelAttribute("compositionOrder") CompositionOrder compositionOrder) {
        if (compositionOrder.getQuantity() < 1) {
            return "redirect:/compositions_client";
        }

        if (OrderController.getCurrentOrder() == null) {
            OrderController.setCurrentOrder(new Order());
        }
        Iterator<CompositionOrder> iterator = OrderController.getCurrentOrder().getCompositionOrdersById().iterator();
        while (iterator.hasNext()) {
            CompositionOrder order = iterator.next();
            if (order.getCompositionId().equals(compositionOrder.getCompositionId())) {
                order.setQuantity(order.getQuantity() + compositionOrder.getQuantity());

                OrderController.getCurrentOrder().setCost(OrderController.getCurrentOrder().getCost() +
                        order.getCompositionByCompositionId().getPrice() * compositionOrder.getQuantity());

                order.getCompositionByCompositionId().setAmount(order.getCompositionByCompositionId().getAmount()
                        - compositionOrder.getQuantity());
                compositionService.update(order.getCompositionByCompositionId());
                return "redirect:/compositions_client";
            }
        }
        compositionOrder.setCompositionByCompositionId((Composition) compositionService.getById(compositionOrder.getCompositionId()));
        compositionOrder.getCompositionByCompositionId().setAmount(compositionOrder.getCompositionByCompositionId().getAmount()
                - compositionOrder.getQuantity());
        compositionService.update(compositionOrder.getCompositionByCompositionId());

        OrderController.getCurrentOrder().getCompositionOrdersById().add(compositionOrder);

        OrderController.getCurrentOrder().setCost(OrderController.getCurrentOrder().getCost() +
                compositionOrder.getCompositionByCompositionId().getPrice() * compositionOrder.getQuantity());

        return "redirect:/compositions_client";
    }
}
