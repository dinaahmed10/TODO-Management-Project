package com.spring.TODO_management_project.service;

import com.spring.TODO_management_project.DTO.TackDTO;

public interface TaskService {
    TackDTO createTask(TackDTO tackDTO);
    TackDTO readTask(Long id);
    TackDTO updateTask(Long id,TackDTO tackDTO);
    void deleteTask(Long id);

}
