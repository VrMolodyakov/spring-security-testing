package com.example.securityWithHibernate.Controller;

import com.example.securityWithHibernate.Model.Users;
import com.example.securityWithHibernate.Repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class webController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/login")
    public String login(Model model){
        return "login";
    }

    @GetMapping(value = "/registration")
    public String registration(Model model){
        Users user = new Users();
        model.addAttribute("user",user);
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String addNewUser(@Valid @ModelAttribute("user") Users user, BindingResult bindingResult,Model model){
        Optional<Users> newUser = userService.findByUserName(user.getName());
        if(newUser.isPresent()){
            bindingResult
                    .rejectValue("name", "error.user",
                            "There is already a user registered with the user name provided");
        }
        if (bindingResult.hasErrors()) {
            return "registration";
        }else{
            userService.saveUser(user);
            model.addAttribute("successMessage","user have been registered");
            model.addAttribute("user",new Users());
            return "registration";
        }
    }

    @GetMapping(value = "/home")
    public String home(Model model){
        System.out.println("i'm here");
        model.addAttribute("title","Welcome to the home!");
        return "home";
    }

    @GetMapping(value = "/admin")
    public String usersList(Model model){
        return "index";
    }
}
