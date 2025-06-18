package com.spring.TODO_management_project.service.serviceImp;

import com.spring.TODO_management_project.DTO.TaskDTO;
import com.spring.TODO_management_project.entity.Task;
import com.spring.TODO_management_project.exception.ResourceNotFoundException;
import com.spring.TODO_management_project.repository.TaskRepository;
import com.spring.TODO_management_project.service.TaskService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor

public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;
    private ModelMapper modelMapper;


    @Override
    public TaskDTO createTask(TaskDTO tackDTO) {
        Task task= modelMapper.map(tackDTO,Task.class);
        return modelMapper.map(taskRepository.save(task) , TaskDTO.class);
    }

    @Override
    public TaskDTO readTask(Long id) {
        Task task=taskRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Task with this ID Not Found"));
        return modelMapper.map(task , TaskDTO.class);
    }

    @Override
    public TaskDTO updateTask(Long id, TaskDTO tackDTO) {
        Task task=taskRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Task with this ID Not Found"));
        task.setId(tackDTO.getId());
        return modelMapper.map(task , TaskDTO.class);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Task with this ID Not Found"));;
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        List<Task> tasks =taskRepository.findAll();
        List<TaskDTO> taskDTOs=new ArrayList<>();
        for(int i=0 ;i<tasks.size() ;i++){
            taskDTOs.add(modelMapper.map( tasks.get(i),TaskDTO.class));
        }

        return taskDTOs;
    }
}
