package project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.model.Address;
import project.service.Service;

@Controller
public class AddressController {

    private Service addressService;


    @Autowired(required = true)
    @Qualifier(value = "addressService")
    public void setAddressService(Service addressService) {
        this.addressService = addressService;
    }


    @RequestMapping(value = "/addresss/add", method = RequestMethod.POST)
    public String addAddress(@ModelAttribute("address") Address address) {
        if (address.getId() == null) {
            this.addressService.add(address);
        } else {
            this.addressService.update(address);
        }

        return "redirect:/baskets";
    }

    @RequestMapping("editAddress/{id}")
    public String editAddress(@PathVariable("id") int id, Model model) {
        model.addAttribute("address", this.addressService.getById(id));
        model.addAttribute("listAddresss", this.addressService.list());

        return "baskets";
    }



    @RequestMapping(value = "address", method = RequestMethod.GET)
    public String listAddresss(Model model) {
        UserController.getCurrentUser(model);
        model.addAttribute("address", new Address());

        return "address";
    }
}


