package com.esiggroup.taskbackend.model.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterDTO (@NotBlank String username, @NotBlank @Email String email, @NotBlank String password){
}
