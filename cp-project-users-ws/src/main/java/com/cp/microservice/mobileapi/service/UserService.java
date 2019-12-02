package com.cp.microservice.mobileapi.service;

import com.cp.microservice.mobileapi.dto.UserDto;

import java.util.List;

public interface UserService {

    public UserDto createUser(UserDto userDto);

    public UserDto updateUser(UserDto userDto);

    public List<UserDto> getUsers();

    public UserDto getUserById(Long userId);

    public boolean deleteUserById(Long userId);
}
