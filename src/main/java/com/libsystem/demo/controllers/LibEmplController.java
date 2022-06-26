package com.libsystem.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.libsystem.demo.services.ILibEmployeeService;

@Controller
@RequestMapping("/employee")
public class LibEmplController {
    @Autowired 
    ILibEmployeeService libEmployeeService;


    @GetMapping("/showAll")
    public String getLibDepAll(Model model) {
        model.addAttribute("package", libEmployeeService.selectAllEmployees());
        return "employee-all-page";
    }
}
