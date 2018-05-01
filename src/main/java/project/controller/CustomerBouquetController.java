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
import project.model.Decoration;
import project.model.Flower;
import project.model.Pack;
import project.service.Service;

@Controller
public class CustomerBouquetController {
    private Service flowerService;
    private Service packService;
    private Service decorationService;

    @Autowired(required = true)
    @Qualifier(value = "flowerService")
    public void setFlowerService(Service flowerService) {
        this.flowerService = flowerService;
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

    @RequestMapping(value = "customer_bouquets_pack", method = RequestMethod.GET)
    public String listPacks(Model model){
        model.addAttribute("pack", new Pack());
        model.addAttribute("listPacks", this.packService.list());

        return "customer_bouquets_pack";
    }

    @RequestMapping(value = "customer_bouquets_decoration", method = RequestMethod.GET)
    public String listDecorations(Model model){
        model.addAttribute("decoration", new Decoration());
        model.addAttribute("listDecorations", this.decorationService.list());

        return "customer_bouquets_decoration";
    }


}
