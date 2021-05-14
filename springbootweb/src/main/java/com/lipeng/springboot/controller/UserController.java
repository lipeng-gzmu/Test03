package com.lipeng.springboot.controller;

import com.lipeng.springboot.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {//list集合实例
    @RequestMapping("/list")
    public String userController(Model model){
        List<User> users = new ArrayList<User>();//创建user集合
        User user = new User(1001, "张三", "123456");
        User user01 = new User(1002, "李四", "789101");
        User user02 = new User(1003, "王二", "654321");
        users.add(user);
        users.add(user01);
        users.add(user02);//将user分别加入list中
        model.addAttribute("users",users);
        return "/list";
    }
    @RequestMapping("/map")
    public String userMap(Model model){//map集合实例
        Map<String,User> map = new HashMap<>();
        User user = new User(1001, "张三", "123456");
        User user01 = new User(1002, "李四", "789101");
        User user02 = new User(1003, "王二", "654321");
        map.put("1",user);
        map.put("2",user01);
        map.put("3",user02);
        model.addAttribute("map",map);
        return "/list";
    }
    @RequestMapping("/str")
    public String userStr(Model model){//String类型实例
        String[] strings = {"zhangsan","lisi","wanger"};
        model.addAttribute("strings",strings);
        return "/list";
    }
    @RequestMapping("/date")
    public String userDate(Model model){//日期格式在html中控制
       model.addAttribute("date", new Date());
       return "/list";
    }
    @RequestMapping("/subString")
    public String subString(Model model){
        model.addAttribute("class1","aaa");
        model.addAttribute("class2","bbb");
        return "/list";
    }

}
