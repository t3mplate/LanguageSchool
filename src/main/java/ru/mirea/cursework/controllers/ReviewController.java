package ru.mirea.cursework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mirea.cursework.entity.Review;
import ru.mirea.cursework.entity.User;
import ru.mirea.cursework.repos.ReviewRepo;

@Controller
public class ReviewController {
    @Autowired
    ReviewRepo reviewRepo;
    @GetMapping("/reviews")
    public String revpage(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user",user);
        Iterable<Review> reviews=reviewRepo.findAll();
        model.addAttribute("reviews",reviews);
        System.out.println(reviews);
        return ("reviews");
    }
    @PostMapping("/reviews")
    public String rev(@RequestParam("text") String message, @AuthenticationPrincipal User user) {
        Review review=new Review();
        review.setText(message);
        review.setAuthor(user);
        reviewRepo.save(review);
        System.out.println(review);
        return ("redirect:/reviews");
    }
}
