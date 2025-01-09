package com.by.daniyal.dao;

import com.by.daniyal.entity.Employees;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDao {
    public final static EmployeeDao INSTANCE = new EmployeeDao();

    private static final String FROM_EMPLOYEES = "from Employees";

    public void update(Employees employees) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.update(employees);
            session.getTransaction().commit();
        }
    }

    public void save(Employees employees) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.save(employees);
            session.getTransaction().commit();
        }
    }

    public void delete(Employees employees) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.delete(employees);
            session.getTransaction().commit();
        }
    }

    public List<Employees> findAll() {
        List<Employees> allEmployees = Collections.emptyList();

        try (Session session = HibernateUtil.getSession()) {
            Query<Employees> query = session.createQuery("FROM Employees", Employees.class);
            allEmployees = query.getResultList();
        } catch (Exception e) {
            throw new HibernateException("Error fetching employees: " + e.getMessage());
        }

        return allEmployees;
    }


    public Optional<Employees> findById(int id) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            Query<Employees> query = session.createQuery("FROM Employees where id = :id", Employees.class);
            query.setParameter("id", id);
            List<Employees> allEmployees = query.getResultList();

            if (allEmployees.isEmpty()) {
                throw new HibernateException("Employee with id " + id + " not found");
            } else {
                return Optional.of(allEmployees.get(0));
            }
        }
    }
}

