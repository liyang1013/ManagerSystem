package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginCotroller {

    @RequestMapping("/user/login")
    public String Login(String username, String password, Model model, HttpSession session){
        if(!StringUtils.isEmpty(username) && password.equals("123456")){
            session.setAttribute("username",username);
            return "redirect:/admin.html";
        }else{
            model.addAttribute("msg","密码错误");
            return "index";
        }

    }
}
