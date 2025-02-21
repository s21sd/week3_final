package com.springmvc.pmvc.dao;

import com.springmvc.pmvc.beans.Faculty;
import java.util.List;

public interface Facultydao {
    void saveFaculty(Faculty faculty);
    Faculty getFacultyByEmail(String email);
    Faculty getFacultyById(int id);
    List<Faculty> getAllFaculties();
}
