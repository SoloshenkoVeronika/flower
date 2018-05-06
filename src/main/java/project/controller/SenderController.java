package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.model.Sender;
import project.service.Service;


@Controller
public class SenderController {
    private Service senderService;

    @Autowired(required = true)
    @Qualifier(value = "senderService")
    public void setSenderService(Service senderService) {
        this.senderService = senderService;
    }


    @RequestMapping(value = "/senders/add", method = RequestMethod.POST)
    public String addSender(@ModelAttribute("sender") Sender sender){
        if(sender.getId() == null){
            this.senderService.add(sender);
        }else {
            this.senderService.update(sender);
        }

        return "redirect:/recipients";
    }

    @RequestMapping("editSender/{id}")
    public String editSender(@PathVariable("id") int id, Model model){
        model.addAttribute("sender", this.senderService.getById(id));
        model.addAttribute("listSenders", this.senderService.list());

        return "recipients";
    }



    @RequestMapping(value = "senders", method = RequestMethod.GET)
    public String listSenders(Model model){
        UserController.getCurrentUser(model);
        model.addAttribute("sender", new Sender());
        model.addAttribute("listSenders", this.senderService.list());

        return "senders";
    }

}

