package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/home")
    //@ResponseBody //возвращает данные не готовой страницы
    public String getHomeString(){
        return "Home Page";
    }
}
