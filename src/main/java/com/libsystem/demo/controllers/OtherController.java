package com.libsystem.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.libsystem.demo.services.ILibraryDepCRUDService;
import com.libsystem.demo.services.IOtherService;

@Controller
public class OtherController {
    @Autowired
    private IOtherService otherService;

    @Autowired
    private ILibraryDepCRUDService libDepService;
    
    @GetMapping("/")
    private String getHomepage() {
        return "home-page";
    }

}
