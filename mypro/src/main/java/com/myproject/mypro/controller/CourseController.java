package com.myproject.mypro.controller;

import com.myproject.mypro.Entity.Course;
import com.myproject.mypro.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/faculty/{name}")
    public ResponseEntity<List<Course>> getCoursesByFaculty(@PathVariable String name) {
        List<Course> courses = courseService.getCoursesByFacultyName(name);
        return ResponseEntity.ok(courses);
    }
}
