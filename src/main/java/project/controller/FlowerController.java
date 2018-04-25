package project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.model.Flower;
import project.service.Service;

@Controller
public class FlowerController {
    private Service flowerService;

    @Autowired(required = true)
    @Qualifier(value = "flowerService")
    public void setFlowerService(Service flowerService) {
        this.flowerService = flowerService;
    }


    @RequestMapping(value = "/flowers/add", method = RequestMethod.POST)
    public String addFlower(@ModelAttribute("flower") Flower flower){
        if(flower.getId() == 0){
            this.flowerService.add(flower);
        }else {
            this.flowerService.update(flower);
        }

        return "redirect:/flowers_admin";
    }

    @RequestMapping("editFlower/{id}")
    public String editFlower(@PathVariable("id") int id, Model model){
        model.addAttribute("flower", this.flowerService.getById(id));
        model.addAttribute("listFlowers", this.flowerService.list());

        return "flowers_admin";
    }

    @RequestMapping("/removeFlower/{id}")
    public String removeFlower(@PathVariable("id") int id){
        this.flowerService.remove(id);

        return "redirect:/flowers_admin";
    }

    @RequestMapping(value = "flowers_admin", method = RequestMethod.GET)
    public String listFlowers(Model model){
        model.addAttribute("flower", new Flower());
        model.addAttribute("listFlowers", this.flowerService.list());

        return "flowers_admin";
    }
}
