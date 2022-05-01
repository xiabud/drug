package com.xiecode.drug.controller;

import com.xiecode.drug.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/welcome")
public class TestController {


    @Autowired
    private UserService userService;

    @RequestMapping
    public String test() {
        return "/welcome";
    }


    @RequestMapping("/userName")
    @ResponseBody
    public String selectUserName() {
        return userService.selectUser();

    }

    @RequestMapping("/inSellDrug")
    @ResponseBody
    public String inSellDrug() {
        return userService.inSellDrug();

    }

    @RequestMapping("/stockNum")
    @ResponseBody
    public String stockNum() {
        return userService.stockNum();

    }

    @RequestMapping("/inSellDrugType")
    @ResponseBody
    public String inSellDrugType() {
        return userService.inSellDrugType();

    }

    @RequestMapping("/allProblemDrugNum")
    @ResponseBody
    public String allProblemDrugNum() {
        return userService.allProblemDrugNum();

    }

    @RequestMapping("/allReturnDrugNum")
    @ResponseBody
    public String allReturnDrugNum() {
        return userService.allReturnDrugNum();

    }

    @RequestMapping("/drugAllNum")
    @ResponseBody
    public String drugAllNum() {
        return userService.drugAllNum();

    }

}
