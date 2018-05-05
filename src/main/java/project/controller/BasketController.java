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
import project.model.Order;
import project.model.Pack;
import project.service.Service;

@Controller
public class BasketController {
    private Service orderService;

    @Autowired(required = true)
    @Qualifier(value = "orderService")
    public void setOrderService(Service orderService) {
        this.orderService = orderService;
    }


    @RequestMapping(value = "/baskets/add", method = RequestMethod.POST)
    public String addBasket(@ModelAttribute("basket") Order order){

            this.orderService.add(order);


        return "redirect:/baskets";
    }

    @RequestMapping("editBasket/{id}")
    public String editBasket(@PathVariable("id") int id, Model model){
        model.addAttribute("basket", this.orderService.getById(id));
        model.addAttribute("listBaskets", this.orderService.list());

        return "baskets";
    }

    @RequestMapping(value = "baskets", method = RequestMethod.GET)
    public String listBaskets(Model model){
        UserController.getCurrentUser(model);
        model.addAttribute("basket", new Order());
        model.addAttribute("listBaskets", this.orderService.list());

        return "baskets";
    }
}
