package com.libsystem.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.libsystem.demo.services.IBookCRUDService;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired IBookCRUDService bookService;

    @GetMapping("/showAll")
    public String getBookAll(Model model) {
        model.addAttribute("package", bookService.selectAllBooks());
        return "book-all-page";
    }
}
