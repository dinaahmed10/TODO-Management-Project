package com.spring.TODO_management_project.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class TaskDTO {

    private Long id;
    @NotEmpty(message = "title can't be empty")
    @NotBlank(message = "title can't be free space ")
    private String title;
    @NotEmpty(message = "description can't be empty")
    @NotBlank(message = "description can't be free space ")
    private String description;
    private boolean completed;
}
