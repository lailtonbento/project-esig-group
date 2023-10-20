package com.esiggroup.taskbackend.model.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(@NotBlank String email, @NotBlank String password){}
