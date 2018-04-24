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

    @RequestMapping(value = "decorations", method = RequestMethod.GET)
    public String listDecorations(Model model){
        model.addAttribute("decoration", new Decoration());
        model.addAttribute("listDecorations", this.decorationService.list());

        return "decorations";

    }

    @RequestMapping(value = "decorations", method = RequestMethod.GET)
    public String listDecorations(Model model){
        model.addAttribute("decoration", new Decoration());
        model.addAttribute("listDecorations", this.decorationService.list());

        return "decorations";
    }


    @RequestMapping(value = "/decorations/add", method = RequestMethod.POST)
    public String addFlower(@ModelAttribute("decoration") Decoration decoration){
        if(decoration.getId() == 0){
            this.decorationService.add(decoration);
        }else {
            this.decorationService.update(decoration);
        }

        return "redirect:/decorations";
    }


    @RequestMapping("/removedec/{id}")
    public String removeDecoration(@PathVariable("id") int id){

        this.decorationService.remove(id);

        return "redirect:/decorations";
    }

    @RequestMapping("editdec/{id}")
    public String editDecoration(@PathVariable("id") int id, Model model){
        model.addAttribute("decoration", this.decorationService.getById(id));
        model.addAttribute("listDecorations", this.decorationService.list());

        return "decorations";

    }

}

