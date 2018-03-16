package project.controller;

import project.model.User;
import project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    private UserService userService;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setBookService(UserService bookService) {
        this.userService = bookService;
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String listBooks(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("listBooks", this.userService.listUsers());

        return "users";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("user") User book){
        if(book.getId() == 0){
            this.userService.addUser(book);
        }else {
            this.userService.updateUser(book);
        }

        return "redirect:/users";
    }

    @RequestMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") int id){
        this.userService.removeUser(id);

        return "redirect:/users";
    }

    @RequestMapping("edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listBooks", this.userService.listUsers());

        return "books";
    }

    @RequestMapping("bookdata/{id}")
    public String bookData(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));

        return "bookdata";
    }
}
