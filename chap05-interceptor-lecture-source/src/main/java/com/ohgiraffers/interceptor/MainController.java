package com.ohgiraffers.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MainController {

    @RequestMapping(value ={"/","main"})
    public String defaultLocation(){
        return "main";
    }
}
