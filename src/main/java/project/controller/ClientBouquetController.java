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
import project.service.Service;

@Controller
public class ClientBouquetController {
    private Service  bouquetService;

    @Autowired(required = true)
    @Qualifier(value = "bouquetService")
    public void setFlowerService(Service  bouquetService) {
        this.bouquetService = bouquetService;
    }


    @RequestMapping(value = "bouquets_client", method = RequestMethod.GET)
    public String listBouquets(Model model){
        model.addAttribute("bouquet", new Bouquet());
        model.addAttribute("listBouquets", this.bouquetService.list());

        return "bouquets_client";
    }
}
