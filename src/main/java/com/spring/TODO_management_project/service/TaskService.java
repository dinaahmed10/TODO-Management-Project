package com.spring.TODO_management_project.service;

import com.spring.TODO_management_project.DTO.TaskDTO;

import java.util.List;

public interface TaskService {
    TaskDTO createTask(TaskDTO tackDTO);
    TaskDTO readTask(Long id);
    TaskDTO updateTask(Long id, TaskDTO tackDTO);
    void deleteTask(Long id);
    List<TaskDTO> getAllTasks();

}
