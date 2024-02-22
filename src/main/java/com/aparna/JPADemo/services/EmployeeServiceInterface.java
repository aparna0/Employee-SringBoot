package com.aparna.JPADemo.services;

import com.aparna.JPADemo.Exceptions.DuplicateEmployeeException;
import com.aparna.JPADemo.Exceptions.EmptyTableException;
import com.aparna.JPADemo.Exceptions.NoEmplyeeFoundException;
import com.aparna.JPADemo.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeServiceInterface {
     Employee addEMployee(Employee emp) throws DuplicateEmployeeException;
     List<Employee> getAllEmployee() throws EmptyTableException;
    Employee getEmployee(int employeeId) throws NoEmplyeeFoundException;
    Employee editEmployee(Employee emp) throws NoEmplyeeFoundException;
    int deleteEmployee(Employee emp) throws NoEmplyeeFoundException;
}
