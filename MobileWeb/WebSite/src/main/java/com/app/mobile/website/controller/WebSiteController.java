package com.app.mobile.website.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/website") // Set the base URL path for the controller
public class WebSiteController {
	
	
	 static final Map<String, String> packageViewMap = new HashMap<String, String>();

    static {
        // Define mappings between app packages and view names
        packageViewMap.put("com.app.mobile", "about");
        packageViewMap.put("yourapp", "about_yourapp");
        // Add more mappings as needed
    }

    @GetMapping("/{appPackage}/about")
    public String aboutPage(@PathVariable String appPackage) {
        // Use the 'appPackage' parameter in your method logic
        System.out.println("App Package: " + appPackage);
        
        // Lookup the view name based on the appPackage
        String viewName = packageViewMap.getOrDefault(appPackage, "about_generic");
        
        return viewName;
    }
	

	@GetMapping("/terms")
    public String termsPage() {
        return "terms"; // Returns the terms.html template
    }

    @GetMapping("/privacy")
    public String privacyPage() {
        return "privacy"; // Returns the privacy.html template
    }

    @GetMapping("/faq")
    public String faqPage() {
        return "faq"; // Returns the faq.html template
    }
	
	
}
