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

import com.libsystem.demo.model.LibEmployee;
import com.libsystem.demo.services.ILibEmployeeService;
import com.libsystem.demo.services.ILibraryDepCRUDService;

@Controller
@RequestMapping("/employee")
public class LibEmplController {
    // TODO create all pages 
    @Autowired 
    ILibEmployeeService libEmployeeService;
    @Autowired
    ILibraryDepCRUDService depService;


    @GetMapping("/showAll")
    public String getEmployeeAll(Model model) {
        model.addAttribute("package", libEmployeeService.selectAllEmployees());
        return "employee-all-page";
    }
    @GetMapping("/showAll/{id}")
    public String getEmployeeById(@PathVariable(name="id") int id, Model model) throws Exception {
        try {
            model.addAttribute("package", libEmployeeService.selectById(id));
            return "employee-one-page";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }
    @GetMapping("/remove/{id}")
    public String getEmployeeRemoveById(@PathVariable(name="id") int id, Model model) throws Exception {
        try {
            libEmployeeService.deleteById(id);
            return "redirect:/employee/showAll";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg",e.getMessage());
            return "error-page";
        }
    }
    @GetMapping("/addNew")
    public String getEmployeeAdd(LibEmployee employee, Model model) {
        model.addAttribute("departments", depService.readAllLibraryDep());
        return "employee-add-page";
    }
    @PostMapping("/addNew")
    public String postTeacherAdd(@Valid LibEmployee employee, BindingResult result, Model model) throws Exception{
        if(result.hasErrors())
            return"employee-add-page";
        else {
            try {
                libEmployeeService.addNewEmployee(employee);
                return "redirect:/employee/showAll/" + employee.getIdEmpl();
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("errorMsg",e.getMessage());
                return "error-page";
            }
        }
    }
    @GetMapping("/update/{id}")
    public String getEmployeeUpdateById(@PathVariable(name = "id") int id, Model model) throws Exception { 
        try {
            model.addAttribute("employee", libEmployeeService.selectById(id));
            model.addAttribute("departments", depService.readAllLibraryDep());
            return "employee-update-page";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg",e.getMessage());
            return "error-page";
        }
    }
    @PostMapping("/update/{id}")
    public String postBookUpdateById(@PathVariable(name = "id") int id, @Valid LibEmployee employee, BindingResult result, Model model) throws Exception {
        if(result.hasErrors())
            return "employee-update-page";
        else {
            try {
                libEmployeeService.updateById(id, employee);
                return "redirect:/employee/showAll/" + id;
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("errorMsg",e.getMessage());
               return "error-page";
            }

        }
    }
}
