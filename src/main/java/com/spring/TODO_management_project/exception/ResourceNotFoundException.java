package com.spring.TODO_management_project.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String messaage;

    public ResourceNotFoundException(String messaage){
        super(messaage);
        this.messaage=messaage;
    }
}
