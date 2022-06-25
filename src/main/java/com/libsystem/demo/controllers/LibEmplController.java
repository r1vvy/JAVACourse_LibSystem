package com.libsystem.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.libsystem.demo.services.ILibEmployeeService;

@Controller
@RequestMapping("/employee")
public class LibEmplController {
    @Autowired 
    ILibEmployeeService libEmployeeService;
}
