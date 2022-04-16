package com.xiecode.drug.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/warranty")
public class WarrantyController {

    @RequestMapping
    public Object warranty() {
        return "/warranty";
    }
}
