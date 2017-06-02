package com.DzGeeks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by user on 2017/6/3.
 */
@Controller
public class RegisterController {

    @GetMapping("/register")
    public  String getRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public  String registerPage() {
        return "index";
    }
}
