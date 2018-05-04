package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.model.Decoration;
import project.service.Service;

@Controller
public class DecorationController {
    private Service decorationService;

    @Autowired(required = true)
    @Qualifier(value = "decorationService")
    public void setDecorationService(Service decorationService) {
        this.decorationService = decorationService;
    }


    @RequestMapping(value = "/decorations/add", method = RequestMethod.POST)
    public String addDecoration(@ModelAttribute("decoration") Decoration decoration){
        if(decoration.getId() == null){
            this.decorationService.add(decoration);
        }else {
            this.decorationService.update(decoration);
        }

        return "redirect:/decorations_admin";
    }

    @RequestMapping("editDecoration/{id}")
    public String editDecoration(@PathVariable("id") int id, Model model){
        model.addAttribute("decoration", this.decorationService.getById(id));
        model.addAttribute("listDecorations", this.decorationService.list());

        return "decorations_admin";
    }

    @RequestMapping("/removeDecoration/{id}")
    public String removeDecoration(@PathVariable("id") int id){
        this.decorationService.remove(id);

        return "redirect:/decorations_admin";
    }

    @RequestMapping(value = "decorations_admin", method = RequestMethod.GET)
    public String listDecorations(Model model){
        UserController.getCurrentUser(model);
        model.addAttribute("decoration", new Decoration());
        model.addAttribute("listDecorations", this.decorationService.list());

        return "decorations_admin";
    }
}

