package com.hello16.SchoolTemplate.config;


import com.hello16.SchoolTemplate.entity.User;
import com.hello16.SchoolTemplate.repo.UserRepo;
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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = this.userRepo.findByUsername(auth.getName());
        return currentUser;
    }

}
