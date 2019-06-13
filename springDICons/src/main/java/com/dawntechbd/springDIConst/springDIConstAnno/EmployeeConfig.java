package com.dawntechbd.springDIConst.springDIConstAnno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {

    @Bean
    public Employee2 emplyeeBeen() {
        Employee2 employee = new Employee2(29, "Neelima",
                new Address2("Alamnagar", "Rangpur", "Bangladesh"));
        return employee;
    }

    @Bean
    public Address2 addressBeen() {
        Address2 address = new Address2("Alamnagar", "Rangpur", "Bangladesh");
        return address;
    }
}

