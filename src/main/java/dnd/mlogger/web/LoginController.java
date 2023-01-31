package dnd.mlogger.web;

import dnd.mlogger.User;
import dnd.mlogger.repositories.UserRepository;
import dnd.mlogger.security.LoginForm;
import dnd.mlogger.security.payload.LoginRequest;
import dnd.mlogger.security.services.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {


    private Post post;



    @Autowired
    private UserRepository userRepository;

    public LoginController(){
        this.post = new Post();
    }
    @GetMapping
    public String login(){
        return "signinpage";
    }


    @ModelAttribute
    public LoginRequest loginUser(){

        System.out.println("new log in request initiated");
        return new LoginRequest();
    }

    @PostMapping
    public String processLogin(LoginRequest loginRequest){
        System.out.println("login form processed");

        // post.login(loginRequest.getUsername(), loginRequest.getPassword());
         return "redirect:/personlist";
    }
}
