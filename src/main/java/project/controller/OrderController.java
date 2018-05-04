package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.model.Order;
import project.service.Service;

@Controller
public class OrderController {
    private Service orderService;
    private Order currentOrder;

    @Autowired(required = true)
    @Qualifier(value = "orderService")
    public void setOrderService(Service orderService) {
        this.orderService = orderService;
    }


    @RequestMapping(value = "/order/add", method = RequestMethod.POST)
    public String addOrder(@ModelAttribute("order") Order order){
        if(order.getId() == null){
            this.orderService.add(order);
        }else {
            this.orderService.update(order);
        }

        return "redirect:/order_client";
    }

    @RequestMapping("editOrder/{id}")
    public String editOrder(@PathVariable("id") int id, Model model){
        model.addAttribute("order", this.orderService.getById(id));
        model.addAttribute("listOrders", this.orderService.list());

        return "order_client";
    }

    @RequestMapping("/removeOrder/{id}")
    public String removeOrder(@PathVariable("id") int id){
        this.orderService.remove(id);

        return "redirect:/order_client";
    }

    @RequestMapping(value = "order_client", method = RequestMethod.GET)
    public String listOrders(Model model){
        UserController.getCurrentUser(model);
        model.addAttribute("order", new Order());
        model.addAttribute("listOrders", this.orderService.list());

        return "order_client";
    }

    @RequestMapping(value = "shopping_cart", method = RequestMethod.GET)
    public String getCurrentOrder(Model model){
        if (currentOrder == null) {
            model.addAttribute("isEmpty", true);
            //model.addAttribute("order", new Order());
            model.addAttribute("order", orderService.getById(1));//*************************  GET BY ID
        } else {
            model.addAttribute("order", false);
        }

        return "shopping_cart";
    }

    @RequestMapping(value = "/shopping_cart/update", method = RequestMethod.POST)
    public String updateCurrentOrder(@ModelAttribute("order") Order order){
        currentOrder = order;

        return "redirect:/shopping_cart";
    }
}

