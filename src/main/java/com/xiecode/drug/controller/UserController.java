package com.xiecode.drug.controller;

import com.xiecode.drug.common.ResultMapUtil;
import com.xiecode.drug.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 用户相关的controller
 * @return:
 * @Author: Xiewc
 * @Date: 2022/2/15
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * @Description: 转向登录页面
     * @return: 页面的地址:/login
     * @Author: Xiewc
     * @Date: 2022/2/15
     */
    @RequestMapping(value = "/login")
    public String login() {
        return "/login";
    }

    /**
    * @Description: 判断用户是否成功
    * @return: java.lang.Object
    * @Author: Xiewc
    * @Date: 2022/2/15
    */
    @RequestMapping(value = "/toLogin")
    @ResponseBody
    public Object toLogin(String username, String password) {
        if (username == null || password == null) {
            return ResultMapUtil.getHashMapLogin("验证失败,用户名密码不准确", "2");
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            return ResultMapUtil.getHashMapLogin("验证失败,用户名不存在", "3");
        } catch (IncorrectCredentialsException e) {
            return ResultMapUtil.getHashMapLogin("验证失败,密码不准确", "4");
        }
        userService.updateStatus(username);
        return ResultMapUtil.getHashMapLogin("验证成功","1");
    }

    /**
     * @Description: 转向首页页面
     * @return: 页面的地址:/login
     * @Author: Xiewc
     * @Date: 2022/2/15
     */
    @RequestMapping(value = "/index")
    public String index() {
        return "/index";
    }
    
    /** 
    * @Description: 退出登录
    * @return: java.lang.String
    * @Author: Xiewc
    * @Date: 2022/2/18
    */

    @RequestMapping(value = "/logout")
    public String logout() {
        userService.clean();
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }

}
