package com.aparna.JPADemo;

import com.aparna.JPADemo.model.Employee;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JpaDemoApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(JpaDemoApplication.class, args);
		Employee emp = (Employee) context.getBean("employee");
		emp.setName("aparna");
		emp.setSalary(100000.0);
		emp.setDesignation("Full-Stack-Developer");
		System.out.println(emp);
	}

}
