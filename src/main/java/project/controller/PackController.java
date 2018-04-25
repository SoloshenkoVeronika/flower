package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.model.Pack;
import project.service.Service;

@Controller
public class PackController {
    private Service packService;

    @Autowired(required = true)
    @Qualifier(value = "packService")
    public void setPackService(Service packService) {
        this.packService = packService;
    }


    @RequestMapping(value = "/packs/add", method = RequestMethod.POST)
    public String addPack(@ModelAttribute("pack") Pack pack){
        if(pack.getId() == 0){
            this.packService.add(pack);
        }else {
            this.packService.update(pack);
        }

        return "redirect:/packs_admin";
    }

    @RequestMapping("editPack/{id}")
    public String editPack(@PathVariable("id") int id, Model model){
        model.addAttribute("pack", this.packService.getById(id));
        model.addAttribute("listPacks", this.packService.list());

        return "packs_admin";
    }

    @RequestMapping("/removePack/{id}")
    public String removePack(@PathVariable("id") int id){
        this.packService.remove(id);

        return "redirect:/packs_admin";
    }

    @RequestMapping(value = "packs_admin", method = RequestMethod.GET)
    public String listPacks(Model model){
        model.addAttribute("pack", new Pack());
        model.addAttribute("listPacks", this.packService.list());

        return "packs_admin";
    }
}

