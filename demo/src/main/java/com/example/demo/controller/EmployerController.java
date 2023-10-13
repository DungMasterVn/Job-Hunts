package com.example.demo.controller;

import com.example.demo.model.Employer;
import com.example.demo.repository.EmployerRepo;
import com.example.demo.request.EmployerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingErrorProcessor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employer")
public class EmployerController {
    //Autopoint point to EmployerRepo by "employerRepo"
    @Autowired private EmployerRepo employerRepo;
    //Model được sử dụng để đẩy thông tin từ EmployerRepo lên EmployerController
    @GetMapping
    public String listAllEmployer(Model model){
        //"employers là một key tham chiếu đến các đối tượng trong employerRepo
        //Để hiển thị được các đối tượng đã được gọi, tên file html được trả về phải trùng tên với key
        model.addAttribute("employers",employerRepo.getAll());
        return "employers";
    }

    @GetMapping("/{id}")
    public String showEmployerByID(Model model, @PathVariable String id){
        model.addAttribute("employer", employerRepo.findById(id));
        return "employerid";
    }

    @GetMapping("/add")
    public String addEmployerForm(Model model){
        model.addAttribute("employer", new EmployerRequest("","","",null));
        return "employer_add";
    }

    @PostMapping(value = "/add", consumes = "multipart/form-data")
    public String addEmployer(@ModelAttribute EmployerRequest employerRequest, BindingResult result, Model model){
        if(result.hasErrors()){
            return "employer_add";
        }
        System.out.println(employerRequest);
        return "redirect:/employer";
    }
}
