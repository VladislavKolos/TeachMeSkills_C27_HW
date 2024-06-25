package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.Task;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * A service class for performing tasks and subtasks.
 */
@Component
@RequiredArgsConstructor
public class TaskService {
    private final List<Task> tasks;

    /**
     * Performs all tasks and their subtasks
     * For each task and subtask, displays a completion message.
     */
    public void executeTasks() {
        tasks.forEach(task -> {
            System.out.println(task.getName() + " completed:");
            task.getSubTasks().forEach(subTask -> System.out.println(subTask.getName() + " completed"));
            System.out.println();
        });
    }
}
