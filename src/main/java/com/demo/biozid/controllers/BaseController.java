package com.demo.biozid.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseController {
    @ModelAttribute("anonymousUser")
    public Boolean anonymousUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName().equals("anonymousUser");
    }

    @ModelAttribute("user")
    public Boolean authenticatedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return !auth.getName().equals("anonymousUser");
    }
}
