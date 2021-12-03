package com.khuong.firstcommerce.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    ///http://localhost:8080/home
    @GetMapping("/home")
    public UserDetails home(Authentication authentication){
        UserDetails userPrincipal = (UserDetails)authentication.getPrincipal();

        //return "This is Home Page \n Hello " + userPrincipal.getUsername() + "";
        return userPrincipal;
    }

    ///http://localhost:8080/admin
    @GetMapping("/admin")
    public String admin(){
        return "This is Admin Page";
    }
}
