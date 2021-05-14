package com.lipeng.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class LoginController {
    @PostMapping("/login")//相当于@RequestMapping(value="/login method="RequestMethod.Post")
    public String login(String username, String password,
                        HttpSession session, Map<String,Object> map){
                if(!StringUtils.isEmpty(username) && "123".equals(password)){
                    System.out.println("username:"+username);
                    session.setAttribute("loginUser",username);
                    return "redirect:/main.html";
                }else{
                    map.put("msg","用户名或密码错误");
                    return "login";
                }
    }
}
