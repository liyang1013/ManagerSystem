package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {

    @RequestMapping("emps")
    public String list(Model model){
        model.addAttribute("emps","employees");
        return "list";
    }
}
