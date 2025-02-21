package com.myproject.mypro.Services;

import com.myproject.mypro.Entity.Course;
import com.myproject.mypro.Repository.FacultyCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private FacultyCourseRepository facultyCourseRepository;

    public List<Course> getCoursesByFacultyName(String facultyName) {
        return facultyCourseRepository.findCoursesByFacultyName(facultyName);
    }
}
