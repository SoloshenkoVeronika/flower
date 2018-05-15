package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.model.*;
import project.service.OrderServiceImpl;
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
    private Service decorationService;
    private Service packService;
    private Service customerBouquetService;

    private Service flowerCustomerBouquetService;
    private Service decorationCustomerBouquetService;

    private Service senderService;
    private Service recipientService;
    private Service addressService;
    private Service flowerOrderService;
    private Service bouquetOrderService;
    private Service compositionOrderService;
    private Service customerBouquetOrderService;

    private UserService userService;


    public static void setCurrentOrder(Order currentOrder) {
        OrderController.currentOrder = currentOrder;
    }

    public static void setCustomerBouquet(CustomerBouquet customerBouquet) {
        OrderController.customerBouquet = customerBouquet;
    }

    public static Order getCurrentOrder() {
        return currentOrder;
    }

    public static CustomerBouquet getCustomerBouquet() {
        return customerBouquet;
    }

    public static boolean isCustomerBouquetEmpty() {
        if (customerBouquet.getPackId() == null && (customerBouquet.getFlowerCustomerBouquetsById() == null || customerBouquet.getFlowerCustomerBouquetsById().size() == 0) && (customerBouquet.getDecorationCustomerBouquetsById() == null || customerBouquet.getDecorationCustomerBouquetsById().size() == 0))
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
    @Qualifier(value = "decorationService")
    public void setDecorationService(Service decorationService) {
        this.decorationService = decorationService;
    }

    @Autowired(required = true)
    @Qualifier(value = "packService")
    public void setPackService(Service packService) {
        this.packService = packService;
    }

    @Autowired(required = true)
    @Qualifier(value = "customerBouquetService")
    public void setCustomerBouquetService(Service customerBouquetService) {
        this.customerBouquetService = customerBouquetService;
    }


    @Autowired(required = true)
    @Qualifier(value = "flowerCustomerBouquetService")
    public void setFlowerCustomerBouquetService(Service flowerCustomerBouquetService) {
        this.flowerCustomerBouquetService = flowerCustomerBouquetService;
    }

    @Autowired(required = true)
    @Qualifier(value = "decorationCustomerBouquetService")
    public void setDecorationCustomerBouquetService(Service decorationCustomerBouquetService) {
        this.decorationCustomerBouquetService = decorationCustomerBouquetService;
    }


    @Autowired(required = true)
    @Qualifier(value = "senderService")
    public void setSenderService(Service senderService) {
        this.senderService = senderService;
    }

    @Autowired(required = true)
    @Qualifier(value = "recipientService")
    public void setRecipientService(Service recipientService) {
        this.recipientService = recipientService;
    }

    @Autowired(required = true)
    @Qualifier(value = "addressService")
    public void setAddressService(Service addressService) {
        this.addressService = addressService;
    }

    @Autowired(required = true)
    @Qualifier(value = "flowerOrderService")
    public void setFlowerOrderService(Service flowerOrderService) {
        this.flowerOrderService = flowerOrderService;
    }

    @Autowired(required = true)
    @Qualifier(value = "bouquetOrderService")
    public void setBouquetOrderService(Service bouquetOrderService) {
        this.bouquetOrderService = bouquetOrderService;
    }

    @Autowired(required = true)
    @Qualifier(value = "compositionOrderService")
    public void setCompositionOrderService(Service compositionOrderService) {
        this.compositionOrderService = compositionOrderService;
    }

    @Autowired(required = true)
    @Qualifier(value = "customerBouquetOrderService")
    public void setCustomerBouquetOrderService(Service customerBouquetService) {
        this.customerBouquetOrderService = customerBouquetService;
    }


    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/order/add", method = RequestMethod.POST)
    public String addOrder(@ModelAttribute("order") Order order) {
        if (order.getId() == null) {
            this.orderService.add(order);
        } else {
            this.orderService.update(order);
        }

        return "redirect:/order_client";
    }


    @RequestMapping(value = "/order/addCustomerBouquet", method = RequestMethod.POST)
    public String addCustomerBouquet(@ModelAttribute("customerBouquetOrder") CustomerBouquetOrder customerBouquetOrder) {
        if (OrderController.getCurrentOrder() == null) {
            OrderController.setCurrentOrder(new Order());
        }
        Iterator<CustomerBouquetOrder> iterator = OrderController.getCurrentOrder().getCustomerBouquetOrdersById().iterator();
        while (iterator.hasNext()) {
            CustomerBouquetOrder order = iterator.next();
            if (order.getCustomerBouquetId().equals(customerBouquetOrder.getCustomerBouquetId())) {
                order.setQuantity(order.getQuantity() + customerBouquetOrder.getQuantity());
                return "redirect:/customer_bouquets";
            }
        }
        getCurrentOrder().getCustomerBouquetOrdersById().add(customerBouquetOrder);

        return "redirect:/customer_bouquets";
    }


    @RequestMapping("editOrder/{id}")
    public String editOrder(@PathVariable("id") int id, Model model) {
        model.addAttribute("order", this.orderService.getById(id));
        model.addAttribute("listOrders", this.orderService.list());

        return "orders_client";
    }

    @RequestMapping("/removeOrder/{id}")
    public String removeOrder(@PathVariable("id") int id) {
        this.orderService.remove(id);

        return "redirect:/order_client";
    }

    @RequestMapping(value = "orders_client", method = RequestMethod.GET)
    public String listOrders(Model model) {
        UserController.getCurrentUser(model);
        model.addAttribute("order", new Order());
        model.addAttribute("listOrders", this.orderService.listWhere("user_id = '"
                + UserController.getCurrentUser().getId() + "'"));

        return "orders_client";
    }


    @RequestMapping(value = "customer_bouquets/complete", method = RequestMethod.GET)
    public String completeCustomerBouquetCreation(Model model) {
        UserController.getCurrentUser(model);
        customerBouquet = null;

        return "redirect:/client";
    }

    @RequestMapping(value = "shopping_cart", method = RequestMethod.GET)
    public String getCurrentOrder(Model model) {
        UserController.getCurrentUser(model);

        if (currentOrder != null) {
            model.addAttribute("isEmpty", false);
            model.addAttribute("order", currentOrder);
        } else {
            model.addAttribute("isEmpty", true);
        }

        if (OrderController.getCustomerBouquet() == null) model.addAttribute("isCustomerBouquetEmpty", true);
        else model.addAttribute("isCustomerBouquetEmpty", false);

        return "shopping_cart";
    }

    @RequestMapping(value = "/shopping_cart/update", method = RequestMethod.POST)
    public String updateCurrentOrder(@ModelAttribute("order") Order order) {
        currentOrder = order;

        return "redirect:/shopping_cart";
    }

    @RequestMapping(value = "baskets", method = RequestMethod.GET)
    public String listBaskets(Model model) {
        UserController.getCurrentUser(model);
        model.addAttribute("order", currentOrder);

        if (OrderController.getCustomerBouquet() == null) model.addAttribute("isCustomerBouquetEmpty", true);
        else model.addAttribute("isCustomerBouquetEmpty", false);

        return "baskets";
    }

    @RequestMapping(value = "/baskets/add", method = RequestMethod.POST)
    public String addBasket(@ModelAttribute("order") Order order) {
        if (order.getSenderBySenderId().getSecondName().equals("") && order.getSenderBySenderId().getFirstName().equals("") && order.getSenderBySenderId().getPhone().equals("") && order.getSenderBySenderId().getEmail().equals("")) {
            currentOrder.setSenderBySenderId(null);
        }
        if (order.getSenderBySenderId().getSecondName().equals("")) order.getSenderBySenderId().setSecondName(null);
        if (order.getSenderBySenderId().getFirstName().equals("")) order.getSenderBySenderId().setFirstName(null);
        if (order.getSenderBySenderId().getPhone().equals("")) order.getSenderBySenderId().setPhone(null);
        if (order.getSenderBySenderId().getEmail().equals("")) order.getSenderBySenderId().setEmail(null);

        if (order.getRecipientByRecipientId().getSecondName().equals("") && order.getRecipientByRecipientId().getFirstName().equals("") && order.getRecipientByRecipientId().getPhone().equals("")) {
            currentOrder.setRecipientByRecipientId(null);
        }
        if (order.getRecipientByRecipientId().getSecondName().equals(""))
            order.getRecipientByRecipientId().setSecondName(null);
        if (order.getRecipientByRecipientId().getFirstName().equals(""))
            order.getRecipientByRecipientId().setFirstName(null);
        if (order.getRecipientByRecipientId().getPhone().equals("")) order.getRecipientByRecipientId().setPhone(null);

        currentOrder.setUserId(order.getUserId());
        if (order.getUserId() != null) currentOrder.setUserByUserId((User) userService.getById(order.getUserId()));

        currentOrder.setDate(new Date());

        if (order.getPostcard().equals("")) order.setPostcard(null);
        currentOrder.setPostcard(order.getPostcard());

        if (order.getAdditionalInf().equals("")) order.setAdditionalInf(null);
        currentOrder.setAdditionalInf(order.getAdditionalInf());

        currentOrder.setPayment(order.getPayment());
        //cost уже посчитан

        Sender sender = new Sender();
        sender.setSecondName(order.getSenderBySenderId().getSecondName());
        sender.setFirstName(order.getSenderBySenderId().getFirstName());
        sender.setPhone(order.getSenderBySenderId().getPhone());
        sender.setEmail(order.getSenderBySenderId().getEmail());

        senderService.add(sender);
        currentOrder.setSenderId(sender.getId());
        currentOrder.setSenderBySenderId(sender);


        Recipient recipient = new Recipient();
        recipient.setSecondName(order.getRecipientByRecipientId().getSecondName());
        recipient.setFirstName(order.getRecipientByRecipientId().getFirstName());
        recipient.setPhone(order.getRecipientByRecipientId().getPhone());

        recipientService.add(recipient);
        currentOrder.setRecipientId(recipient.getId());
        currentOrder.setRecipientByRecipientId(recipient);


        Address address = new Address();
        address.setCity(order.getAddressByAddressId().getCity());
        address.setStreet(order.getAddressByAddressId().getStreet());
        address.setHouse(order.getAddressByAddressId().getHouse());
        address.setBlock(order.getAddressByAddressId().getBlock());
        address.setFlat(order.getAddressByAddressId().getFlat());

        addressService.add(address);
        currentOrder.setAddressId(address.getId());
        currentOrder.setAddressByAddressId(address);
        //нужна проверка, если ли в бд адрес с такими же полями, чтобы не создавать новый.
        //можно использовать метод getAddress из dao, но лучше вынести эти методы в интерфейс
        //и назвать getObject как-нибудь и потом проверять
        //******** Это надо и для адреса, и для отправителя, и для получателя
        //для отправителя и получателя нужно учитывать, что поля могут быть null, и тогда эти
        //отправители и получатели развые

        this.orderService.add(currentOrder);

        Iterator<FlowerOrder> iterator = currentOrder.getFlowerOrdersById().iterator();
        while (iterator.hasNext()) {
            FlowerOrder flowerOrder = iterator.next();
            flowerOrder.setOrderId(currentOrder.getId());
            flowerOrder.setOrderByOrderId(currentOrder);
            flowerOrderService.add(flowerOrder);

            Flower flower = flowerOrder.getFlowerByFlowerId();
            flower.setAmount(flower.getAmount() - flowerOrder.getQuantity());
            flowerService.update(flower);
        }


        Iterator<BouquetOrder> iterator1 = currentOrder.getBouquetOrdersById().iterator();
        while (iterator1.hasNext()) {
            BouquetOrder bouquetOrder = iterator1.next();
            bouquetOrder.setOrderId(currentOrder.getId());
            bouquetOrder.setOrderByOrderId(currentOrder);
            bouquetOrderService.add(bouquetOrder);

            Bouquet bouquet = bouquetOrder.getBouquetByBouquetId();
            bouquet.setAmount(bouquet.getAmount() - bouquetOrder.getQuantity());
            bouquetService.update(bouquet);
        }

        Iterator<CompositionOrder> iterator2 = currentOrder.getCompositionOrdersById().iterator();
        while (iterator2.hasNext()) {
            CompositionOrder compositionOrder = iterator2.next();
            compositionOrder.setOrderId(currentOrder.getId());
            compositionOrder.setOrderByOrderId(currentOrder);
            compositionOrderService.add(compositionOrder);

            Composition composition = compositionOrder.getCompositionByCompositionId();
            composition.setAmount(composition.getAmount() - compositionOrder.getQuantity());
            compositionService.update(composition);
        }

        Iterator<CustomerBouquetOrder> iterator3 = currentOrder.getCustomerBouquetOrdersById().iterator();
        while (iterator3.hasNext()) {
            CustomerBouquetOrder customerBouquetOrder = iterator3.next();
            CustomerBouquet customerBouquet = customerBouquetOrder.getCustomerBouquetByCustomerBouquetId();

            Pack pack = customerBouquet.getPackByPackId();
            pack.setAmount(pack.getAmount() - 1);
            packService.update(pack);

            customerBouquetService.add(customerBouquet);

            customerBouquetOrder.setOrderId(currentOrder.getId());
            customerBouquetOrder.setOrderByOrderId(currentOrder);
            customerBouquetOrderService.add(customerBouquetOrder);


            if (customerBouquet.getFlowerCustomerBouquetsById() != null) {
                Iterator<FlowerCustomerBouquet> flowerIterator = customerBouquet.getFlowerCustomerBouquetsById().iterator();
                while (flowerIterator.hasNext()) {
                    FlowerCustomerBouquet flowerCustomerBouquet = flowerIterator.next();
                    flowerCustomerBouquet.setCustomerBouquetId(customerBouquetOrder.getId());
                    flowerCustomerBouquet.setCustomerBouquetByCustomerBouquetId(customerBouquet);
                    flowerCustomerBouquetService.add(flowerCustomerBouquet);

                    Flower flower = flowerCustomerBouquet.getFlowerByFlowerId();
                    flower.setAmount(flower.getAmount() - flowerCustomerBouquet.getQuantity());
                    flowerService.update(flower);
                }
            }

            if (customerBouquet.getDecorationCustomerBouquetsById() != null) {
                Iterator<DecorationCustomerBouquet> decorationIterator = customerBouquet.getDecorationCustomerBouquetsById().iterator();
                while (decorationIterator.hasNext()) {
                    DecorationCustomerBouquet decorationCustomerBouquet = decorationIterator.next();
                    decorationCustomerBouquet.setCustomerBouquetId(customerBouquetOrder.getId());
                    decorationCustomerBouquet.setCustomerBouquetByCustomerBouquetId(customerBouquet);
                    decorationCustomerBouquetService.add(decorationCustomerBouquet);

                    Decoration decoration = decorationCustomerBouquet.getDecorationByDecorationId();
                    decoration.setAmount(decoration.getAmount() - decorationCustomerBouquet.getQuantity());
                    decorationService.update(decoration);
                }
            }
        }

        currentOrder = null;
        return "redirect:/baskets";
    }
}