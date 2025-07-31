package com.example.todo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Schema(description = "A data transfer object representing a task in a galaxy not so far away.")
public class TodoDto {

    @Schema(
            description = "The unique task ID. Assigned by the database Jedi Council.",
            example = "42"
    )
    private Long id;

    @NotNull
    @Schema(
            description = "The ID of the user who owns this task. Likely a Padawan in training.",
            example = "7"
    )
    private Long userId;

    @NotBlank
    @Schema(
            description = "The title of the task. Keep it shorter than the opening crawl.",
            example = "Defeat the Sith Lord"
    )
    private String title;

    @NotBlank
    @Schema(
            description = "A longer description of the mission. Droids not included.",
            example = "Board the Death Star and disable the tractor beam."
    )
    private String description;

    @NotNull
    @Schema(
            description = "Deadline for the mission. Complete before the Sith arrive.",
            example = "2025-12-18T13:45:00"
    )
    private LocalDate dueDate;

    @NotNull
    @Schema(
            description = "Whether the task is still active. true = Hope remains. false = It’s over, Anakin.",
            example = "true"
    )
    private boolean isActive;

    public TodoDto() {}

    public TodoDto(String title, String description, LocalDate dueDate, boolean isActive) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isActive = isActive;
    }
}
