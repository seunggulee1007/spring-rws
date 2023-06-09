package com.inno.rws.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController implements ErrorController {

    @GetMapping("/")
    public String index() {
        return "/index.html";
    }

    @GetMapping("/error")
    public String redirect() {
        return "index.html";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
