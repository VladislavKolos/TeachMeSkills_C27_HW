package org.example;

import org.example.service.TaskService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * The main class for launching an application that performs tasks.
 */
public class TaskMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("org.example");

        TaskService bean = context.getBean(TaskService.class);
        bean.executeTasks();
    }
}
