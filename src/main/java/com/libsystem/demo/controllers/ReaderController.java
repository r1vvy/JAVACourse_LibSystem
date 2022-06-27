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

import com.libsystem.demo.model.Reader;
import com.libsystem.demo.services.IReaderCRUDService;

@Controller
@RequestMapping("/reader")
public class ReaderController {
    // TODO create all pages
    @Autowired
    private IReaderCRUDService readerService;
    
    @GetMapping("/showAll")
    public String getReaderAll(Model model) {
        model.addAttribute("package", readerService.readAllReaders());
        return "reader-all-page";
    }
    @GetMapping("/showAll/{id}")
    public String getReaderById(@PathVariable(name="id") int id, Model model) throws Exception {
        try {
            model.addAttribute("package", readerService.selectById(id));
            model.addAttribute("takenBooks", readerService.selectById(id).getBooks());
            return "reader-one-page";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page"; 
        }
    }
    @GetMapping("/remove/{id}")
    public String getReaderRemoveById(@PathVariable(name="id") int id, Model model) throws Exception {
        try {
            readerService.deleteById(id);
            return "redirect:/reader/showAll";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg",e.getMessage());
            return "error-page";
        }
    }
    @GetMapping("/addNew")
    public String getReaderAdd(Reader reader) {
        return "reader-add-page";
    }
    @PostMapping("/addNew") // localhost:8080/book/addNew
    public String postReaderAdd(@Valid Reader reader, BindingResult result, Model model) throws Exception{
        if(result.hasErrors())
            return"reader-add-page";
        else {
            try {
                readerService.addNewReader(reader);
                return "redirect:/reader/showAll/" + reader.getIdRea();
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("errorMsg",e.getMessage());
                return "error-page";
            }
        }
    }
    @GetMapping("/update/{id}")
    public String getReaderUpdateById(@PathVariable(name = "id") int id, Model model) throws Exception { 
        try {
            model.addAttribute("reader", readerService.selectById(id));
            return "reader-update-page";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg",e.getMessage());
            return "error-page";
        }
    }
    @PostMapping("/update/{id}")
    public String postReaderUpdateById(@PathVariable(name = "id") int id, @Valid Reader reader, BindingResult result) throws Exception {
        if(result.hasErrors())
            return "reader-update-page";
        else {
            readerService.updateById(id, reader);
            return "redirect:/reader/showAll/" + id;
        }
    }
}
