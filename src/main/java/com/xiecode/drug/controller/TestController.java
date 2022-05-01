package com.xiecode.drug.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welcome")
public class TestController {

    @RequestMapping
    public String test() {
        return "/welcome";
    }

}
