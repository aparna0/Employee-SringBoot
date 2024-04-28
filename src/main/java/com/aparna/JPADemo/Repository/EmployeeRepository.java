package com.aparna.JPADemo.Repository;

import com.aparna.JPADemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public List<Employee> getEmployeeByName(String name);

    public List<Employee>  getEmployeeNameByDesignation(String designation);
}
