package com.libsystem.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.libsystem.demo.model.Book;
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

    @GetMapping("/showAll/{id}")
    public String getBookById(@PathVariable(name="id") int id, Model model) throws Exception {
        try {
            model.addAttribute("package", bookService.selectById(id));
            return "book-one-page";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }
    @GetMapping("/remove/{id}")
    public String getBookRemoveById(@PathVariable(name="id") int id, Model model) throws Exception {
        try {
            bookService.deleteById(id);
            return "redirect:/showAll";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg",e.getMessage());
            return "error-page";
        }
    }
    @GetMapping("/addNew")
    public String getBookAdd(Book book) {
        return "book-add-page";
    }
    @PostMapping("/addNew") // localhost:8080/book/addNew
    public String postTeacherAdd(@Valid Book book, BindingResult result, Model model) throws Exception{
        if(result.hasErrors())
            return"book-add-page";
        else {
            try {
                bookService.addNewBook(book);
                return "redirect:/showAll";
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("errorMsg",e.getMessage());
                return "error-page";
            }
        }
    }
    @GetMapping("/update/{id}")
    public String getBookUpdateById(@PathVariable(name = "id") int id, Model model) throws Exception { 
        try {
            model.addAttribute("package", bookService.selectById(id));
            return "book-update-page";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg",e.getMessage());
            return "error-page";
        }
    }
    @PostMapping("/update/{id}")
    public String postBookUpdateById(@PathVariable(name = "id") int id, @Valid Book book, BindingResult result) throws Exception {
        if(result.hasErrors())
            return "book-update-page";
        else {
            bookService.updateById(id, book);
            return "redirect:/showAll";
        }
    }
    

}
