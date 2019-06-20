package com.next.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kamyam
 * @date 2019/6/20 21:53
 */
@RestController
public class LoginController {

    @GetMapping("/test/login")
    public String login(){
        return  "登录成功";
    }


}
