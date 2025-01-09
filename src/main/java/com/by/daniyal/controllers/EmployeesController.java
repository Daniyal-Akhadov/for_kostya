package com.by.daniyal.controllers;

import com.by.daniyal.entity.Employees;
import com.by.daniyal.services.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller()
public class EmployeesController {
    private final EmployeesService employeesService;

    @Autowired
    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @GetMapping("/")
    public String findAll(Model model) {
        model.addAttribute("employees", employeesService.findAll());
        System.out.println(employeesService.findAll());
        return "all_functions";
    }

    public String update(Model model, @RequestParam int id) {
        Employees foundEmployees = employeesService.findById(id);
        model.addAttribute("employees", foundEmployees);
        return "update";
    }

    public String delete(Model model, @RequestParam Employees employees) {
        employeesService.delete(employees);
        return "redirect:/employees";
    }

    public String add(Model model, @RequestParam Employees employees) {
        model.addAttribute("employees", employees);
        return "add";
    }
}