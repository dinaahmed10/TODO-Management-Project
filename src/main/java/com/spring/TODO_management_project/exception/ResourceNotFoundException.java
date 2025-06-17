package com.spring.TODO_management_project.exception;

import lombok.AllArgsConstructor;


public class ResourceNotFoundException extends RuntimeException{
    private String messaage;

    public ResourceNotFoundException(String messaage){
        super(messaage);
        this.messaage=messaage;
    }
}
