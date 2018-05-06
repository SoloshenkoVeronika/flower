package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.model.Recipient;
import project.model.Sender;
import project.service.Service;

@Controller
public class RecipientController {
    private Service recipientService;

    @Autowired(required = true)
    @Qualifier(value = "recipientService")
    public void setRecipientService(Service recipientService) {
        this.recipientService = recipientService;
    }


    @RequestMapping(value = "/recipients/add", method = RequestMethod.POST)
    public String addRecipient(@ModelAttribute("recipient") Recipient recipient) {
        if (recipient.getId() == null) {
            this.recipientService.add(recipient);
        } else {
            this.recipientService.update(recipient);
        }

        return "redirect:address";
    }

    @RequestMapping("editRecipient/{id}")
    public String editRecipient(@PathVariable("id") int id, Model model) {
        model.addAttribute("recipient", this.recipientService.getById(id));
        model.addAttribute("listRecipients", this.recipientService.list());

        return "address";
    }

    @RequestMapping(value = "recipients", method = RequestMethod.GET)
    public String listAddresss(Model model) {
        model.addAttribute("recipient", new Sender());

        return "recipients";
    }
}