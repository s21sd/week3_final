package com.springmvc.pmvc.controllers;

import com.springmvc.pmvc.beans.Faculty;
import com.springmvc.pmvc.dao.Facultydao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private Facultydao facultyDAO;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("faculty", new Faculty());
        return "register";
    }

    @PostMapping("/register")
    public String registerFaculty(@ModelAttribute("faculty") Faculty faculty) {
        facultyDAO.saveFaculty(faculty);
        return "redirect:/login";
    }
}
