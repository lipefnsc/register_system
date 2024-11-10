package com.project.register_system.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRecordDto(@NotBlank String name, @NotBlank String email, @NotNull int age, @NotBlank String height) {
}
