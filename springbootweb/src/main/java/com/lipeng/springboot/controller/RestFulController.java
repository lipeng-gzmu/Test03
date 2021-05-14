package com.lipeng.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestFulController {
    @ResponseBody
    @RequestMapping("/restFul/{id}")
    public String rest(@PathVariable(value = "id")String id){//@PathVariable作用是将value的id与路径中的{id}绑定
        System.out.println(id);
        return "rest";
    }
}
