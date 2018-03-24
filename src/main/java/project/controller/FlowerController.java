package project.controller;


import project.model.Flower;
import project.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FlowerController {
    private Service flowerService;

    @Autowired(required = true)
    @Qualifier(value = "flowerService")
    public void setFlowerService(Service flowerService) {
        this.flowerService = flowerService;
    }

    @RequestMapping(value = "flowers", method = RequestMethod.GET)
    public String listFlowers(Model model){
        model.addAttribute("flower", new Flower());
        model.addAttribute("listFlowers", this.flowerService.list());

        return "flowers";
    }


    @RequestMapping(value = "/flowers/add", method = RequestMethod.POST)
    public String addFlower(@ModelAttribute("flower") Flower flower){
        if(flower.getIdFl() == 0){
            this.flowerService.add(flower);
        }else {
            this.flowerService.update(flower);
        }

        return "redirect:/flowers";
    }

    @RequestMapping("/removefl/{idFl}")
    public String removeFlower(@PathVariable("idFl") int id){

        this.flowerService.remove(id);

        return "redirect:/flowers";
    }

    @RequestMapping("editfl/{idFl}")
    public String editFlower(@PathVariable("idFl") int id, Model model){
        model.addAttribute("flower", this.flowerService.getById(id));
        model.addAttribute("listFlowers", this.flowerService.list());

        return "flowers";

    }

}
