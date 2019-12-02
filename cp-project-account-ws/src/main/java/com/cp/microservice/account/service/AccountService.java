package com.cp.microservice.account.service;

import com.cp.microservice.account.dto.UserDto;

import java.util.List;

public interface AccountService {

    public UserDto createUser(UserDto userDto);

    public UserDto updateUser(UserDto userDto);

    public List<UserDto> getUsers();

    public UserDto getUserById(Long userId);

    public boolean deleteUserById(Long userId);
}
