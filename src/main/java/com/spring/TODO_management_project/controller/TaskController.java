package com.spring.TODO_management_project.controller;

import com.spring.TODO_management_project.DTO.TackDTO;
import com.spring.TODO_management_project.service.TaskService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/tasks")

@AllArgsConstructor
public class TaskController {
    private TaskService taskService;
    @PostMapping("/create")
    public ResponseEntity<TackDTO> createTask(@Valid @RequestBody TackDTO TackDTO) {
        return new ResponseEntity<>(taskService.createTask(TackDTO), HttpStatus.CREATED);
    }
    @GetMapping("/read/{id}")
    public ResponseEntity<TackDTO> readTask(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.readTask(id));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<TackDTO> updateTask(@PathVariable Long id,@Valid @RequestBody TackDTO TackDTO) {
        return ResponseEntity.ok(taskService.updateTask(id,TackDTO));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id,@Valid @RequestBody TackDTO TackDTO) {
       taskService.deleteTask(id);
       return ResponseEntity.noContent().build();
    }

}
