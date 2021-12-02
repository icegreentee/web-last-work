package com.louis.spring.oauth.server.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	/**
	 * 资源服务器提供的受保护接口
	 * @param principal
	 * @return
	 */
    @RequestMapping("/user")
    public Principal user(Principal principal) {
        System.out.println(principal);
        return principal;
    }

    @RequestMapping("/res/getMsg")
    public String getMsg(Principal principal) {//principal中封装了客户端（用户，也就是clientDetails，区别于Security的UserDetails，其实clientDetails中也封装了UserDetails），不是必须的参数，除非你想得到用户信息，才加上principal。
        return "success";
    }
}
