package com.next.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kamyam
 * @date 2019/6/20 21:48
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String users() {
        return "users";
    }

    @GetMapping("{id}")
    public String user(@PathVariable String id) {
        return id;
    }
}
