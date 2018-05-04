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
import project.service.Service;

@Controller
public class CompositionController {
    private Service compositionService;

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
        UserController.getCurrentUser(model);
        model.addAttribute("composition", new Composition());
        model.addAttribute("listCompositions", this.compositionService.list());

        return "compositions_admin";
    }

    @RequestMapping(value = "compositions_client", method = RequestMethod.GET)
    public String listCompositionsClient(Model model) {
        UserController.getCurrentUser(model);
        model.addAttribute("composition", new Composition());
        model.addAttribute("listCompositions", this.compositionService.list());

        return "compositions_client";
    }
}
