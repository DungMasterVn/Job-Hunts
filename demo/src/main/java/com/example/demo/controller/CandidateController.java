package com.example.demo.controller;

import com.example.demo.repository.CandidateRepo;
import com.example.demo.repository.EmployerRepo;
import com.example.demo.request.CandidateRequest;
import com.example.demo.request.EmployerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    private CandidateRepo candidateRepo;
    @GetMapping
    public String listAllCandidate(Model model){
        model.addAttribute("candidates",candidateRepo.getAll());
        return "candidates";
    }

    @GetMapping("/{id}")
    public String showEmployerByID(Model model, @PathVariable String id){
        model.addAttribute("candidate", candidateRepo.findById(id));
        return "candidateid";
    }

    @GetMapping("/add")
    public String addCandidateForm(Model model){
        model.addAttribute("candidate", new CandidateRequest("","","","","",null));
        return "candidate_add";
    }

}
