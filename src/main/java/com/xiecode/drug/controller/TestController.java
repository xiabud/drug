package com.xiecode.drug.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping("/testString")
    @ResponseBody
    public String test() {
        return "大家好！！！";
    }

}
