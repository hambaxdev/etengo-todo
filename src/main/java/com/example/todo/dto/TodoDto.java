package com.example.todo.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;



@Getter
@Setter
public class TodoDto {
    private Long id;
    @NotNull
    private Long userId;
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotNull
    private LocalDateTime dueDate;
    @NotNull
    private boolean isActive;

    public TodoDto(String title, String description, LocalDateTime dueDate, boolean isActive) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isActive = isActive;
    }
}
