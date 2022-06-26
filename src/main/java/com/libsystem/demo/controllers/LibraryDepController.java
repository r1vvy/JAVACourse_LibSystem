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
import com.libsystem.demo.model.LibraryDep;
import com.libsystem.demo.services.ILibraryDepCRUDService;

@Controller
@RequestMapping("/libDep")
public class LibraryDepController {
    // TODO add all pages
    @Autowired
    private ILibraryDepCRUDService libDepService;
    
    @GetMapping("/addBook/{id}")
    public String getAddBookToLibDep(@PathVariable(name = "id") int id, Model model) throws Exception {
        try {
            model.addAttribute("LibDep", libDepService.readById(id));
            return "book-add-libdep-page";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }
    @PostMapping("/addBook/{id}")
    public String getAddBookToLibDep(@PathVariable(name = "id") int id, @Valid Book book, BindingResult result) throws Exception {
        if (result.hasErrors())
            return "book-add-libdep-page";
        else {
            libDepService.addBookToLibDepById(book, id);
            return "redirect:/libDep/showAllBooks/" + id;
        }
    }

    @GetMapping("/showAll")
    public String getLibDepAll(Model model) {
        model.addAttribute("package", libDepService.readAllLibraryDep());
        return "libdep-all-page";
    }
    @GetMapping("/showAll/{id}")
    public String getLibDepById(@PathVariable(name="id") int id, Model model) throws Exception {
        try {
            model.addAttribute("package", libDepService.readById(id));
            return "libdep-one-page";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page"; 
        }
    }
    @GetMapping("/remove/{id}")
    public String getLibDepRemoveById(@PathVariable(name="id") int id, Model model) throws Exception {
        try {
            libDepService.deleteById(id);
            return "redirect:/libDep/showAll";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg",e.getMessage());
            return "error-page";
        }
    }
    @GetMapping("/addNew")
    public String getLibDepAdd(LibraryDep libraryDep) {
        return "libdep-add-page";
    }
    @PostMapping("/addNew") // localhost:8080/book/addNew
    public String postLibDepAdd(@Valid LibraryDep libraryDep, BindingResult result, Model model) throws Exception{
        if(result.hasErrors())
            return"libdep-add-page";
        else {
            try {
                libDepService.createLibraryDep(libraryDep);
                return "redirect:/libDep/showAll/" + libraryDep.getIdLibDep();
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("errorMsg",e.getMessage());
                return "error-page";
            }
        }
    }
    @GetMapping("/update/{id}")
    public String getLibDepUpdateById(@PathVariable(name = "id") int id, Model model) throws Exception { 
        try {
            model.addAttribute("package", libDepService.readById(id));
            return "libdep-update-page";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg",e.getMessage());
            return "error-page";
        }
    }
    @PostMapping("/update/{id}")
    public String postLibDepUpdateById(@PathVariable(name = "id") int id, @Valid LibraryDep libraryDep, BindingResult result) throws Exception {
        if(result.hasErrors())
            return "libdep-update-page";
        else {
            libDepService.updateById(id, libraryDep);
            return "redirect:/libDep/showAll/" + id;
        }
    }
}
