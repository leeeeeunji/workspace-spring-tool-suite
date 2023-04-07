package com.itwill.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/greeting")
    public String greeting(){
        return "hello";
    }

    @PostMapping("/greeting")
    public String greeting(@RequestBody String name){
        return "hello "+name;
    }
    
    @GetMapping("/auth")
    public Authentication authentication() {
    	return SecurityContextHolder.getContext().getAuthentication();
    }


}
