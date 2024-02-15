package com.example.sem8.service.implementation;

import com.example.sem8.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.sem8.repository.TaskRepository;
import com.example.sem8.domain.Task;
import com.example.sem8.aspect.*;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(null);
    }

    @TrackUserAction
    @Override
    public Task updateTask(Long id, Task task) {
        Task taskById = getTaskById(id);
        taskById.setTitle(task.getTitle());
        taskById.setContent(task.getContent());
        return taskRepository.save(taskById);
    }

    @TrackUserAction
    @Override
    public Task createTask(Task task) {
        task.setCreateDate(LocalDateTime.now());
        return taskRepository.save(task);
    }

    @TrackUserAction
    @Override
    public void deleteTask(Long id) {
        Task taskById = getTaskById(id);
        taskRepository.delete(taskById);
    }
}

