package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.model.*;
import project.service.Service;
import project.service.UserService;

import java.util.Date;
import java.util.Iterator;

@Controller
public class OrderController {
    private Service orderService;
    private static Order currentOrder;
    private static CustomerBouquet customerBouquet;
    private Service flowerService;
    private Service bouquetService;
    private Service compositionService;
    private Service packService;
    private Service decorationService;
    private UserService userService;

    public static void setCurrentOrder(Order currentOrder) {
        OrderController.currentOrder = currentOrder;
    }

    public static void setCustomerBouquet(CustomerBouquet customerBouquet) {
        OrderController.customerBouquet = customerBouquet;
    }

    public static Order getCurrentOrder(){
        return currentOrder;
    }
    
    public static CustomerBouquet getCustomerBouquet(){
        return customerBouquet;
    }

    public static boolean isCustomerBouquetEmpty(){
        if (customerBouquet.getPackId() == null && (customerBouquet.getFlowerCustomerBouquetsById() == null ||
                customerBouquet.getFlowerCustomerBouquetsById().size() == 0) &&
                (customerBouquet.getDecorationCustomerBouquetsById() == null ||
                customerBouquet.getDecorationCustomerBouquetsById().size() == 0))
            return true;
        return false;
    }

    @Autowired(required = true)
    @Qualifier(value = "orderService")
    public void setOrderService(Service orderService) {
        this.orderService = orderService;
    }

    @Autowired(required = true)
    @Qualifier(value = "flowerService")
    public void setFlowerService(Service flowerService) {
        this.flowerService = flowerService;
    }

    @Autowired(required = true)
    @Qualifier(value = "bouquetService")
    public void setBouquetService(Service bouquetService) {
        this.bouquetService = bouquetService;
    }

    @Autowired(required = true)
    @Qualifier(value = "compositionService")
    public void setCompositionService(Service compositionService) {
        this.compositionService = compositionService;
    }

    @Autowired(required = true)
    @Qualifier(value = "packService")
    public void setPackService(Service packService) {
        this.packService = packService;
    }

    @Autowired(required = true)
    @Qualifier(value = "decorationService")
    public void setDecorationService(Service decorationService) {
        this.decorationService = decorationService;
    }

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    // = ОФОРМИТЬ ЗАКАЗ
    @RequestMapping(value = "/order/add", method = RequestMethod.POST)
    public String addOrder(@ModelAttribute("order") Order order){
        if(order.getId() == null){
            this.orderService.add(order);
        }else {
            this.orderService.update(order);
        }

        return "redirect:/order_client";
    }



    @RequestMapping(value = "/order/addCustomerBouquet", method = RequestMethod.POST)
    public String addCustomerBouquet(@ModelAttribute("customerBouquetOrder") CustomerBouquetOrder customerBouquetOrder){
        if (OrderController.getCurrentOrder() == null){
            OrderController.setCurrentOrder(new Order());
        }
        Iterator<CustomerBouquetOrder> iterator = OrderController.getCurrentOrder().getCustomerBouquetOrdersById().iterator();
        while (iterator.hasNext()){
            CustomerBouquetOrder order = iterator.next();
            if (order.getCustomerBouquetId().equals(customerBouquetOrder.getCustomerBouquetId())){
                order.setQuantity(order.getQuantity() + customerBouquetOrder.getQuantity());
                return "redirect:/customer_bouquets";
            }
        }
        getCurrentOrder().getCustomerBouquetOrdersById().add(customerBouquetOrder);

        return "redirect:/customer_bouquets";
    }



    @RequestMapping("editOrder/{id}")
    public String editOrder(@PathVariable("id") int id, Model model){
        model.addAttribute("order", this.orderService.getById(id));
        model.addAttribute("listOrders", this.orderService.list());

        return "orders_client";
    }

    @RequestMapping("/removeOrder/{id}")
    public String removeOrder(@PathVariable("id") int id){
        this.orderService.remove(id);

        return "redirect:/order_client";
    }

    @RequestMapping(value = "orders_client", method = RequestMethod.GET)
    public String listOrders(Model model){
        UserController.getCurrentUser(model);
        model.addAttribute("order", new Order());
        model.addAttribute("listOrders", this.orderService.list());

        return "orders_client";
    }

    @RequestMapping(value = "shopping_cart", method = RequestMethod.GET)
    public String getCurrentOrder(Model model){
        UserController.getCurrentUser(model);
        if (currentOrder != null) {
            model.addAttribute("isEmpty", false);
            model.addAttribute("order", currentOrder);
        } else {
            model.addAttribute("isEmpty", true);
        }

        return "shopping_cart";
    }

    @RequestMapping(value = "/shopping_cart/update", method = RequestMethod.POST)
    public String updateCurrentOrder(@ModelAttribute("order") Order order){
        currentOrder = order;

        return "redirect:/shopping_cart";
    }

    @RequestMapping(value = "baskets", method = RequestMethod.GET)
    public String listBaskets(Model model){
        UserController.getCurrentUser(model);
        model.addAttribute("order", currentOrder);
        //model.addAttribute("listBaskets", this.orderService.list());

        return "baskets";
    }

    @RequestMapping(value = "/baskets/add", method = RequestMethod.POST)
    public String addBasket(@ModelAttribute("order") Order order){
        currentOrder.setDate(new Date());
        currentOrder.setPostcard(order.getPostcard());
        currentOrder.setAdditionalInf(order.getAdditionalInf());
        currentOrder.setPayment(order.getPayment());
        //cost уже посчитан
        currentOrder.setUserId(order.getUserId());
        if(order.getUserId() != null)
            currentOrder.setUserByUserId((User)userService.getById(order.getUserId()));

        currentOrder.setSenderId(order.getSenderId());
        //currentOrder.setSenderBySenderId();

        currentOrder.setRecipientId(order.getRecipientId());
        //currentOrder.setRecipientByRecipientId();

        currentOrder.setAddressId(order.getAddressId());
        //currentOrder.getAddressByAddressId()
        this.orderService.add(currentOrder);

        return "redirect:/baskets";
    }
}