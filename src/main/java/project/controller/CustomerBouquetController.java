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
import project.model.Flower;
import project.service.Service;

@Controller
public class CustomerBouquetController {
    private Service flowerService;

    @Autowired(required = true)
    @Qualifier(value = "flowerService")
    public void setFlowerService(Service flowerService) {
        this.flowerService = flowerService;
    }


    @RequestMapping(value = "customer_bouquets", method = RequestMethod.GET)
    public String listCustomer_bouquet(Model model){
//        model.addAttribute("flower", new Flower());
//        model.addAttribute("listFlowers", this.flowerService.list());

        return "customer_bouquets";
    }

    @RequestMapping(value = "customer_bouquets_flower", method = RequestMethod.GET)
    public String listCustomer_bouquet_flower(Model model){
        model.addAttribute("flower", new Flower());
        model.addAttribute("listFlowers", this.flowerService.list());

        return "customer_bouquets_flower";
    }


}
