package com.cp.microservice.mobileapi.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDto {
    @NotNull(message = "first name can not be empty")
    @Size(min = 2, max = 200)
    private String firstName;
    @NotNull(message = "last name can not be empty")
    private String lastName;
    @NotNull(message = "email can not be empty")
    @Email(message = "email format is not a valid")
    private String email;
    @NotNull(message = "password can not be empty")
    @Size(min = 8, max = 12, message = "Password length is between 8 to 12 characters")
    private String password;
    private Long userId;
}
