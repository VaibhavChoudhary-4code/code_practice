package com.example.demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JavaNormalCodePractice14 {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John Doe", 30, "IT", 60000, "Active", "Male", LocalDate.of(2009, 2, 13)));
        employees.add(new Employee("Jane Smith", 25, "HR", 55000, "Active", "Female", LocalDate.of(2012, 8, 23)));
        employees.add(new Employee("Michael Johnson", 35, "Finance", 70000, "Active", "Male", LocalDate.of(2016, 2, 29)));
        employees.add(new Employee("Emily Brown", 28, "Marketing", 58000, "Active", "Female", LocalDate.of(2019, 9, 1)));
        employees.add(new Employee("William Wilson", 30, "Sales", 75000, "Active", "Male", LocalDate.of(2022, 3, 14)));
        employees.add(new Employee("Olivia Miller", 27, "IT", 62000, "Active", "Female", LocalDate.of(2016, 7, 30)));
        employees.add(new Employee("James Jones", 32, "Finance", 72000, "Active", "Male", LocalDate.of(2013, 1, 21)));
        employees.add(new Employee("Ava Davis", 29, "HR", 56000, "Active", "Female", LocalDate.of(2013, 6, 3)));
        employees.add(new Employee("Liam Martinez", 31, "Sales", 73000, "Active", "Male", LocalDate.of(2013, 6, 15)));
        employees.add(new Employee("Sophia Garcia", 26, "Marketing", 59000, "Active", "Female", LocalDate.of(2017, 9, 14)));


        // How would you find the department that has the highest average salary per employee, while excluding departments with fewer than a certain number of employees?




    }

}
