package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.model.User;
import project.service.UserService;

@Controller
public class UserController {
    private UserService userService;
    private static User currentUser;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "users/currentUser", method = RequestMethod.GET)
    public static void getCurrentUser(Model model) {
        model.addAttribute("user", currentUser);
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user) {
        if (user.getId() == null) {
            currentUser = (User) this.userService.add(user);
        } else {
            this.userService.update(user);
        }
        if(currentUser.getStatus() == 0)
            return "redirect:http://localhost:8080/client";
        else if(currentUser.getStatus() == 1)
            return "redirect:/flowers_admin";

        return "redirect:http://localhost:8080/client";
    }

    @RequestMapping("editUser/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", this.userService.getById(id));
        model.addAttribute("listUsers", this.userService.list());

        return "users";
    }

    @RequestMapping("/removeUser/{id}")
    public String removeUser(@PathVariable("id") int id) {
        this.userService.remove(id);

        return "redirect:/users";
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.list());

        return "users";
    }

    @RequestMapping(value = "/autorization/add", method = RequestMethod.POST)
    public String autorization (@ModelAttribute("use") User user) {
        currentUser = (User) userService.isAuthorized(user);
        if (currentUser.getId() != null) {
            if(currentUser.getStatus() == 0)
                return "redirect:http://localhost:8080/client";
            else if(currentUser.getStatus() == 1) {
                return "redirect:/flowers_admin";
            }
        }
        return "redirect:/users";
    }

    @RequestMapping(value = "autorization", method = RequestMethod.GET)
    public String listFlower(Model model) {
        model.addAttribute("use", new User());
        return "autorization";
    }

    @RequestMapping(value = "exit", method = RequestMethod.GET)
    public String getNam(Model model) {
        model.addAttribute("use", new User());
        currentUser = null;
        return "redirect:http://localhost:8080/";
    }




    @RequestMapping(value = "client", method = RequestMethod.GET)
    public String lish(Model model) {
        getCurrentUser(model);
        return "client";
    }
}
