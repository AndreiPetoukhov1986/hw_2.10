package com.example.hw210;

import java.util.Objects;
import static org.springframework.util.StringUtils.capitalize;

public class Employee {
    private final String fullName;
    private int department;     //отдел 1-5
    private double salary;     //зарплата


    public Employee(String fullName, int department, double salary) {
        this.fullName = capitalize(fullName.toLowerCase());
        this.department = department;
        this.salary = salary;
    }

    public String getFullName() {
        return this.fullName;
    }

    public int getDepartment() {
        return this.department;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Ф.И.О. " + fullName + " отдел - " + department + " зарплата " + salary + " рублей ";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && Double.compare(employee.salary, salary) == 0 && fullName.equals(employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, department, salary);
    }
}
