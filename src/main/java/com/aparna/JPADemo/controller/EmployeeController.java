package com.aparna.JPADemo.controller;

import com.aparna.JPADemo.Exceptions.DuplicateEmployeeException;
import com.aparna.JPADemo.Exceptions.EmptyTableException;
import com.aparna.JPADemo.ExceptionHandler.ErrorResponse;
import com.aparna.JPADemo.Exceptions.NoEmplyeeFoundException;
import com.aparna.JPADemo.model.Employee;
import com.aparna.JPADemo.services.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


    //========================================= Exception Handler ==========================================
    @ExceptionHandler(value = EmptyTableException.class)
    public ErrorResponse handleEmptyTableException(EmptyTableException ex){
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ExceptionHandler( value = NoEmplyeeFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNoEmployeeException(NoEmplyeeFoundException ex){
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ExceptionHandler( value = DuplicateEmployeeException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleDuplicateEmployeeException(DuplicateEmployeeException ex){
        return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
    }
}
