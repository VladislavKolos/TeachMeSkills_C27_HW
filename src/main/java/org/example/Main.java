package org.example;

import org.example.service.ProcessingService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * The main application class that starts the "Spring context" and calls service methods to process strings.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("org.example");

        ProcessingService bean = context.getBean(ProcessingService.class);

        System.out.println(bean.returnFirstString("Vladislav"));
        System.out.println(bean.returnSecondString("Not a name"));
    }
}
