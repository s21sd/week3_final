package com.springmvc.pmvc.dao;

import com.springmvc.pmvc.beans.Course;
import java.util.List;

public interface Coursedao {
    List<Course> getAllCourses();
    Course getCourseById(int id);
}
