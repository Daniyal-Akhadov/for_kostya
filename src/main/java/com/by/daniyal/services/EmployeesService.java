package com.by.daniyal.services;

import com.by.daniyal.dao.EmployeeDao;
import com.by.daniyal.entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeesService {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeesService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }


    public void update(Employees employees) {
        employeeDao.update(employees);
    }

    public Employees findById(int id) {
        Optional<Employees> foundEmployees = employeeDao.findById(id);

        return foundEmployees.orElseThrow(() ->
                new RuntimeException("Not found employees by id=%d".formatted(id)));
    }

    public List<Employees> findAll() {
        return employeeDao.findAll();
    }

    public void delete(Employees employees) {
        employeeDao.delete(employees);
    }
}
