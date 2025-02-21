package com.springmvc.pmvc.controllers;

import com.springmvc.pmvc.beans.Course;
import com.springmvc.pmvc.beans.Faculty;
import com.springmvc.pmvc.dao.Facultycoursedao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private Facultycoursedao facultyCourseDAO;

    @GetMapping("/dashboard")
    public String showDashboard(HttpSession session, Model model) {
        Faculty faculty = (Faculty) session.getAttribute("loggedInUser");
        if (faculty == null) {
            return "redirect:/login";
        }
        
        List<Course> assignedCourses = facultyCourseDAO.getCoursesByFacultyId(faculty.getId());
        model.addAttribute("courses", assignedCourses);
        return "dashboard";
    }
}
