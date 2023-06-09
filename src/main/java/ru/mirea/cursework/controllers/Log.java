package ru.mirea.cursework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mirea.cursework.entity.User;
import ru.mirea.cursework.repos.UserRepos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class Log {
    @Autowired
    UserRepos Repos;

    @GetMapping("/login")
    public String logpage(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("User", user);//объект юзер на основе аворизованного пользователя
        return ("login");
    }
    @PostMapping("/contacts")
    public String log(@RequestParam("usernamesignup") String Name,
                      @RequestParam("emailsignup") String Mail,
                      @RequestParam("passwordsignup") String Password,
                      @RequestParam("passwordsignup_confirm") String Confirm){
        User user = new User();
        user.setUsername(Name);
        user.setMail(Mail);
        user.setPassword(Password);
        user.setConfirm(Confirm);
        Repos.findByUsername(Name);
        return ("login");
    }
    @RequestMapping(value="/logout", method= RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }
}