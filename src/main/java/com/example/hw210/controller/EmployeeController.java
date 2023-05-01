package com.example.hw210.controller;

import com.example.hw210.Employee;
import com.example.hw210.service.EmployeeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/add")
    public Employee add(@RequestParam("fullName") String fullName, @RequestParam("department") int department, @RequestParam("salary") double salary) {
        return employeeService.add(fullName, department, salary);
    }

    @RequestMapping("/find")
    public Employee find(@RequestParam String fullName, @RequestParam int department, @RequestParam double salary) {
        return employeeService.find(fullName, department, salary);
    }

    @RequestMapping("/remove")
    public Employee remove(@RequestParam String fullName, @RequestParam int department, @RequestParam double salary) {
        return employeeService.remove(fullName, department, salary);
    }

    @RequestMapping("/")
    public List<Employee> List() {
        return employeeService.List();
    }

    @RequestMapping("/departments/max-salary")
    public Employee findEmployeeWithMaxSalaryFromDepartment(@RequestParam("departmentId") int department) {
        return employeeService.findEmployeeWithMaxSalaryFromDepartment(department);
    }

    @RequestMapping("/departments/min-salary")
    public Employee findEmployeeWithMinSalaryFromDepartment(@RequestParam("departmentId") int department) {
        return employeeService.findEmployeeWithMinSalaryFromDepartment(department);
    }

    @RequestMapping(value = "/departments/all", params = "departmentId")
    public List<Employee> printAllEmployeesForDep(@RequestParam("departmentId") int dep) {
        return employeeService.printAllEmployeesForDep(dep);
    }

    @RequestMapping("/departments/all")
    public Map<Integer, List<Employee>> printAllEmployees() {
        return employeeService.printAllEmployees();

    }
}