package com.userapi.service;

import com.userapi.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto saveUser(UserDto userDto);
    UserDto findByUsername(String username);
    List<UserDto> findAllUsers();
}
