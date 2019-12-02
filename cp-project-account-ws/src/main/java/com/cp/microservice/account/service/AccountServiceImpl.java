package com.cp.microservice.account.service;

import com.cp.microservice.account.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class AccountServiceImpl implements AccountService {
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
