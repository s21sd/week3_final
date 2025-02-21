package com.springmvc.pmvc.dao;

import com.springmvc.pmvc.beans.Faculty;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class Facultydaoimpl implements Facultydao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveFaculty(Faculty faculty) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(faculty);
    }

    @Override
    public Faculty getFacultyByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query<Faculty> query = session.createQuery("FROM Faculty WHERE email = :email", Faculty.class);
        query.setParameter("email", email);
        return query.uniqueResult();
    }

    @Override
    public Faculty getFacultyById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Faculty.class, id);
    }

    @Override
    public List<Faculty> getAllFaculties() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Faculty", Faculty.class).list();
    }
}
