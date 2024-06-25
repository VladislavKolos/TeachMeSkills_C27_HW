package org.example.config;

import org.example.model.SubTask;
import org.example.model.Task;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Configuration class for creating tasks and subtasks
 * Defines and creates "beans" for tasks and subtasks.
 */
@Configuration
public class AppConfig {

    /**
     * Creates a list of tasks with subtasks.
     * @return a list of tasks, each of which can contain subtasks
     */
    @Bean
    public List<Task> tasks() {
        SubTask subTask1 = SubTask.builder()
                .name("SubTask1")
                .build();

        SubTask subTask2 = SubTask.builder()
                .name("SubTask2")
                .build();

        Task task1 = Task.builder()
                .name("Task1")
                .subTasks(List.of(subTask1, subTask2))
                .build();

        SubTask subTask3 = SubTask.builder()
                .name("SubTask3")
                .build();

        Task task2 = Task.builder()
                .name("Task2")
                .subTasks(List.of(subTask3))
                .build();

        return List.of(task1, task2);
    }

//    @Bean
//    public TaskService taskService(List<Task> tasks) {
//        return new TaskService(tasks);
//    }

}
