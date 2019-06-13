package com.dawntechbd.springDIAnno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {

    @Bean
    public Employee2 obj(){
        Employee2 emp = new Employee2();
        emp.setId(29);
        emp.setName("Neelima");
        emp.setCity("Rangpur");
        return emp;
    }
}
