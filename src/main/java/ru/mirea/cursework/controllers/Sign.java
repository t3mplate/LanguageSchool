package ru.mirea.cursework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mirea.cursework.entity.User;
import ru.mirea.cursework.repos.UserRepos;

@Controller
public class Sign {
    @Autowired
    UserRepos Repos;
    @GetMapping("/reg")
    public String signpage(){
        return ("reg");
    }
    @PostMapping("/reg")
    public String reg(@RequestParam("usernamesignup") String Name,
                      @RequestParam("emailsignup") String Mail,
                      @RequestParam("passwordsignup") String Password,
                      @RequestParam("passwordsignup_confirm") String Confirm){
        User user = new User();
        user.setUsername(Name);
        user.setMail(Mail);
        user.setPassword(Password);
        user.setConfirm(Confirm);
        Repos.save(user);
        return ("reg");
    }
}
