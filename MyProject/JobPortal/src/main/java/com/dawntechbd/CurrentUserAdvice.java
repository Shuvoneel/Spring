package com.dawntechbd;

import com.dawntechbd.entity.User;
import com.dawntechbd.entity.applicantDetails.Applicant;
import com.dawntechbd.repo.ApplicantRepo;
import com.dawntechbd.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;


@ControllerAdvice
public class CurrentUserAdvice {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ApplicantRepo applicantRepo;

    @ModelAttribute("global")
    public User currentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = this.userRepo.findByUsername(auth.getName());
        return currentUser;
    }

}
