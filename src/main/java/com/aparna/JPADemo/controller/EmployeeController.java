package com.aparna.JPADemo.controller;

import com.aparna.JPADemo.Exceptions.DuplicateEmployeeException;
import com.aparna.JPADemo.Exceptions.EmptyTableException;
import com.aparna.JPADemo.Exceptions.NoEmplyeeFoundException;
import com.aparna.JPADemo.Repository.EmployeeRepository;
import com.aparna.JPADemo.model.Employee;
import com.aparna.JPADemo.services.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeServiceInterface empServices;
    @Autowired
    Employee emp;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> getAllEmployees() {
        return empServices.getAllEmployee();
    }

    @GetMapping("/employees/{empId}")
    public Employee getEmployeeById(@PathVariable int empId) throws NoEmplyeeFoundException {
        return empServices.getEmployee(empId);
    }

    @PutMapping("employees/edit/{empId}")
    public Employee editEmployeeById(@PathVariable int empId, @RequestBody Employee emp) throws NoEmplyeeFoundException {
        emp.setEmpId(empId);
        return empServices.editEmployee(emp);
    }

    @PostMapping("employees/save")
    public Employee addEmployee(@RequestBody Employee emp) throws DuplicateEmployeeException {
        emp.setEmpId(emp.getEmpId());
        System.out.println(emp);
        return empServices.addEMployee(emp);
    }

    @DeleteMapping("employees/delete/{empId}")
    public String deleteEmployee(@PathVariable int empId) {
        return String.valueOf(empServices.deleteEmployee(empServices.getEmployee(empId)));
    }

    @DeleteMapping("employees/delete")
    public String deleteAllEmployeeData(){
        return String.valueOf(empServices.deleteAllEMployee());
    }
}
