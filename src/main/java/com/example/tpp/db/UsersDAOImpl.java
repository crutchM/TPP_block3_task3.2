package com.example.tpp.db;

import com.example.tpp.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;


public class UsersDAOImpl implements UsersDAO{

    public UsersDAOImpl(){}

    @Override
    public User get(long id) {
        return (User)HibernateSessionFactory.getSessionFactory().openSession().get(User.class, id);
    }

    @Override
    public List<User> getAll() {
        try
        {
            return HibernateSessionFactory.getSessionFactory().openSession().createCriteria(User.class).list();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    @Override
    public void add(User dataSet) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(dataSet);
        tx1.commit();
        session.close();

    }
}
