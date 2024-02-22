package com.aparna.JPADemo.services;

import com.aparna.JPADemo.Exceptions.DuplicateEmployeeException;
import com.aparna.JPADemo.Exceptions.EmptyTableException;
import com.aparna.JPADemo.Exceptions.NoEmplyeeFoundException;
import com.aparna.JPADemo.Repository.EmployeeRepository;
import com.aparna.JPADemo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeServiceImplementation implements EmployeeServiceInterface{

    @Autowired
    EmployeeRepository empRepo;

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> empList =null;
        empList = empRepo.findAll();
        if(empList.size()<=0)  {
            throw new EmptyTableException("No Employee records found in the database");
        }
        return empList;
    }

    @Override
    public Employee getEmployee(int employeeId) {
        Employee emp = null;
        Optional<Employee> empList = empRepo.findById(employeeId);
        if(empList.isEmpty()){
            throw new NoEmplyeeFoundException("NO employee found with given id");
        }
        else{
            emp = empList.get();
        }
        return emp;
    }
    @Override
    public Employee addEMployee(Employee emp){
        Employee retEmp=null;
        Optional<Employee> empList = empRepo.findById(emp.getEmpId());
        if(empList.isEmpty()){
            retEmp = empRepo.save(emp);
        }
        else{
            throw new DuplicateEmployeeException("Employee is already present");
        }
        return retEmp;
    }

    @Override
    public Employee editEmployee(Employee emp) {
        Employee retEmp=null;
        Optional<Employee> empList = empRepo.findById(emp.getEmpId());
        if(empList.isEmpty()){
            throw new NoEmplyeeFoundException("NO employee found with given id to edit");
        }
        else{
            retEmp = empRepo.save(emp);
        }
        return retEmp;
    }

    @Override
    public int deleteEmployee(Employee emp) {
        int updated=0;
        Optional<Employee> empList = empRepo.findById(emp.getEmpId());
        if(empList.isEmpty()){
            throw new NoEmplyeeFoundException("NO employee found with given id to delete");
        }
        else{
            empRepo.delete(emp);
            updated = 1;
        }
        return updated;
    }
}
