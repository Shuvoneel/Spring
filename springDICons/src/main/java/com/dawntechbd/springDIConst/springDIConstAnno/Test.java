package com.dawntechbd.springDIConst.springDIConstAnno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Test {
    public static void main(String[] args) {

        ApplicationContext context = new
                AnnotationConfigApplicationContext(EmployeeConfig.class);
        Employee2 e = (Employee2) context.getBean(Employee2.class);
        e.show();

    }
}
