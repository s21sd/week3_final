package com.springmvc.pmvc.dao;

import com.springmvc.pmvc.beans.Course;
import com.springmvc.pmvc.beans.FacultyCourse;
import com.springmvc.pmvc.beans.Facultycourse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class FacultyCoursedaoimpl implements Facultycoursedao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void assignCourseToFaculty(Facultycourse facultyCourse) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(facultyCourse);
    }

    @Override
    public List<Course> getCoursesByFacultyId(int facultyId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(
            "SELECT fc.course FROM FacultyCourse fc WHERE fc.faculty.id = :facultyId", Course.class
        ).setParameter("facultyId", facultyId).list();
    }
}
