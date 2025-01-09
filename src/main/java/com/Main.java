package com;

import com.by.daniyal.dao.EmployeeDao;
import com.by.daniyal.entity.Employees;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeDao employeeDao = EmployeeDao.INSTANCE;
//        List<Employees> all = employeeDao.findAll();
//        for (Employees employees : all) {
//            System.out.println(employees);
//        }

//        Optional<Employees> byId = employeeDao.findById(1);
//        byId.ifPresent(System.out::println);
        Employees savedEmployees = Employees.builder().id(1).name("James").salary(2000).build();
        employeeDao.delete(savedEmployees);

        List<Employees> all = employeeDao.findAll();
        for (Employees employees : all) {
            System.out.println(employees);
        }


    }
}
