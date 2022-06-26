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
import com.libsystem.demo.services.ILibraryDepCRUDService;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired 
    IBookCRUDService bookService;

    @Autowired
    ILibraryDepCRUDService depService;

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
            return "redirect:/book/showAll";
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
    public String postBookAdd(@Valid Book book, BindingResult result, Model model) throws Exception{
        if(result.hasErrors())
            return"book-add-page";
        else {
            try {
                bookService.addNewBook(book);
                return "redirect:/book/showAll/" + book.getIdBook();
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("errorMsg",e.getMessage());
                return "error-page";
            }
        }
    }
    @GetMapping("/update/{id}")
    public String getBookUpdate(@PathVariable(name = "id") int id, Model model) throws Exception { 
        try {
            Book book = bookService.selectById(id);
            model.addAttribute("book", book);
            model.addAttribute("departments", depService.readAllLibraryDep());
            return "book-update-page";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg",e.getMessage());
            return "error-page";
        }
    }
    @PostMapping("/update/{id}")
    public String postBookUpdate(@PathVariable(name = "id") int id, @Valid Book book, BindingResult result) throws Exception {
        if(result.hasErrors())
            return "book-update-page";
        else {
            try {
                bookService.updateById(id, book);
                return "redirect:/book/showAll/" + id;
            } catch (Exception e) {
               return "error-page";
            }

        }
    }
    

}
