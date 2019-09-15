package com.hello16.DarkTemplate;

import com.hello16.DarkTemplate.entity.User;
import com.hello16.DarkTemplate.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;


@ControllerAdvice
public class CurrentUserAdvice {

    @Autowired
    private UserRepo userRepo;

    @ModelAttribute("global")
    public User currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = this.userRepo.findByUsername(authentication.getName());
        return currentUser;
    }
}
