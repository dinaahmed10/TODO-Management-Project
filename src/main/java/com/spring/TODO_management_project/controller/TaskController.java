package com.spring.TODO_management_project.controller;

import com.spring.TODO_management_project.DTO.TaskDTO;
import com.spring.TODO_management_project.service.TaskService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/tasks")

@AllArgsConstructor
public class TaskController {
    private TaskService taskService;
    @PostMapping("/create")
    public ResponseEntity<TaskDTO> createTask(@Valid @RequestBody TaskDTO TackDTO) {
        System.out.println("Received isCompleted: " + TackDTO.isCompleted());
        return new ResponseEntity<>(taskService.createTask(TackDTO), HttpStatus.CREATED);
    }
    @GetMapping("/read/{id}")
    public ResponseEntity<TaskDTO> readTask(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.readTask(id));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @Valid @RequestBody TaskDTO TackDTO) {
        return ResponseEntity.ok(taskService.updateTask(id,TackDTO));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id,@Valid @RequestBody TaskDTO TackDTO) {
       taskService.deleteTask(id);
       return ResponseEntity.noContent().build();
    }
    @GetMapping("/all")
    public ResponseEntity<List<TaskDTO>> getAllTasks(){
        return ResponseEntity.ok(taskService.getAllTasks());
    }
    @GetMapping("/complete/{id}")
    public ResponseEntity<TaskDTO> completeTask(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.completeTask(id));
    }
    @GetMapping("/incomplete/{id}")
    public ResponseEntity<TaskDTO> incompleteTask(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.inCompleteTask(id));
    }

}
