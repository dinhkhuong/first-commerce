package com.khuong.firstcommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    ///http://localhost:8080/home
    @GetMapping("/home")
    public String home(){
        return "This is Home Page";
    }

    ///http://localhost:8080/admin
    @GetMapping("/admin")
    public String admin(){
        return "This is Admin Page";
    }
}
