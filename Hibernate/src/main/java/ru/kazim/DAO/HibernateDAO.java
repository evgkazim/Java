package ru.kazim.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.kazim.config.HibernateSessionFactoryUtil;

import java.util.List;

public class HibernateDAO<T> {
    private Class<T> genericClass;

    public HibernateDAO(Class<T> genericClass) {
        this.genericClass = genericClass;
    }

    public T findById(long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(genericClass, id);
    }

    public void save(T obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(obj);
        tx1.commit();
        session.close();
    }

    public void update(T obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(obj);
        tx1.commit();
        session.close();
    }

    public void delete(T obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(obj);
        tx1.commit();
        session.close();
    }

    public List<T> findAll() {
        List<T> users = (List<T>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From " + genericClass.getSimpleName()).list();
        return users;
    }
}
