package com.app.mobile.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logout() {
        // Perform any additional logout actions here
        return "redirect:/login?logout"; // Redirect to login page after logout
    }
    
    
    
    
    
    
    
    
}
