package com.example.demo.controller;

import com.example.demo.dao.DepartmentDao;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.pojo.Department;
import com.example.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
     EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("emps")
    public String list(Model model){
        Collection<Employee> employees=employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "list";
    }

    @GetMapping("/add")
    public String Add(Model model){
       Collection<Department> departments=departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "add";
    }

    @PostMapping("/add")
    public String addEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/update")
    public String update(Integer id,Model model){
        Employee employee= employeeDao.getEmployee(id);
        model.addAttribute("employee",employee);
        Collection<Department> departments=departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "update";
    }

    @PostMapping("/update")
    public String update(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/delete")
    public String delete(Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
