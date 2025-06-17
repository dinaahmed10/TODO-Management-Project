package com.spring.TODO_management_project.service.serviceImp;

import com.spring.TODO_management_project.DTO.TackDTO;
import com.spring.TODO_management_project.entity.Task;
import com.spring.TODO_management_project.exception.ResourceNotFoundException;
import com.spring.TODO_management_project.repository.TaskRepository;
import com.spring.TODO_management_project.service.TaskService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;
    private ModelMapper modelMapper;


    @Override
    public TackDTO createTask(TackDTO tackDTO) {
        Task task= modelMapper.map(tackDTO,Task.class);
        return modelMapper.map(taskRepository.save(task) , TackDTO.class);
    }

    @Override
    public TackDTO readTask(Long id) {
        Task task=taskRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Task with this ID Not Found"));
        return modelMapper.map(task ,TackDTO.class);
    }

    @Override
    public TackDTO updateTask(Long id, TackDTO tackDTO) {
        Task task=taskRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Task with this ID Not Found"));
        task.setId(tackDTO.getId());
        return modelMapper.map(task ,TackDTO.class);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Task with this ID Not Found"));;
    }
}
