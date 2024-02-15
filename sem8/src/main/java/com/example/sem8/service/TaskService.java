package com.example.sem8.service;

import com.example.sem8.domain.Task;
import java.util.List;


public interface TaskService {
    List<Task> getAllTasks();

    Task getTaskById(Long id);

    Task updateTask(Long id, Task task);

    Task createTask(Task task);

    void deleteTask(Long id);
}
