package com.springmvc.pmvc.controllers;

import com.springmvc.pmvc.beans.Faculty;
import com.springmvc.pmvc.dao.Facultydao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private Facultydao facultyDAO;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginFaculty(@RequestParam("email") String email, @RequestParam("pass") String pass, 
                               HttpSession session, Model model) {
        Faculty faculty = facultyDAO.getFacultyByEmail(email);
        if (faculty != null && faculty.getPass().equals(pass)) {
            session.setAttribute("loggedInUser", faculty);
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
