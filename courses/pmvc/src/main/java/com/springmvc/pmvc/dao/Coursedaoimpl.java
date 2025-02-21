package com.springmvc.pmvc.dao;

import com.springmvc.pmvc.beans.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class Coursedaoimpl implements Coursedao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Course> getAllCourses() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Course", Course.class).list();
    }

    @Override
    public Course getCourseById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Course.class, id);
    }
}
