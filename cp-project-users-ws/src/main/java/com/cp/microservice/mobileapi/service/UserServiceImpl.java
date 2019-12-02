package com.cp.microservice.mobileapi.service;

import com.cp.microservice.mobileapi.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private Map<Long, UserDto> userMap = new HashMap<>();

    @Override
    public UserDto createUser(UserDto userDto) {
        Long userId = new Random().nextLong();
        userDto.setUserId(userId);
        userMap.put(userId, userDto);
        return userDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return null;
    }

    @Override
    public List<UserDto> getUsers() {
        return null;
    }

    @Override
    public UserDto getUserById(Long userId) {
        return null;
    }

    @Override
    public boolean deleteUserById(Long userId) {
        return false;
    }
}
