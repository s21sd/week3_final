package com.springmvc.pmvc.dao;

import com.springmvc.pmvc.beans.Course;
import com.springmvc.pmvc.beans.FacultyCourse;
import java.util.List;

public interface Facultycoursedao {
    void assignCourseToFaculty(FacultyCourse facultyCourse);
    List<Course> getCoursesByFacultyId(int facultyId);
}
