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
import com.libsystem.demo.services.ILibraryDepCRUDService;

@Controller
@RequestMapping("/libDep")
public class LibraryDepController {
    // todo error page add attribute exception
    @Autowired
    private ILibraryDepCRUDService libDepService;
    
    @GetMapping("/addBook/{id}")
    public String getAddBookToLibDep(@PathVariable(name = "id") int id, Model model) throws Exception {
        try {
            model.addAttribute("LibDep", libDepService.readById(id));
            return "book-add-libdep-page";
        } catch (Exception e) {
            return "error-page";
        }
    }
    @PostMapping("/addBook/{id}")
    public String getAddBookToLibDep(@PathVariable(name = "id") int id, @Valid Book book, BindingResult result) throws Exception {
        if (result.hasErrors())
            return "book-add-libdep-page";
        else {
            try {
                libDepService.addBookToLibDepById(book, id);
                return "redirect:/showAllBooks/" + id;
            } catch (Exception e) {
                return "error-page";
            }
        }
    }

    @GetMapping("/showAll")
    public String getLibDepAll(Model model) {
        model.addAttribute("package", libDepService.readAllLibraryDep());
        return "libdep-all-page";
    }
}
