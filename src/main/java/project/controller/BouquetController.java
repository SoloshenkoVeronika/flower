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
public class BouquetController {
    private Service bouquetService;

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
        model.addAttribute("bouquet", new Bouquet());
        model.addAttribute("listBouquets", this.bouquetService.list());

        return "bouquets_admin";
    }

    @RequestMapping(value = "bouquets_client", method = RequestMethod.GET)
    public String listBouquetsClient(Model model){
        model.addAttribute("bouquet", new Bouquet());
        model.addAttribute("listBouquets", this.bouquetService.list());

        return "bouquets_client";
    }
}