package com.userapi.service;

import com.userapi.dto.UserDto;
import com.userapi.model.User;
import com.userapi.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        validateUser(userDto);

        User user = modelMapper.map(userDto, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public UserDto findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            return null;
        }
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    private void validateUser(UserDto userDto) {
        if (!isAdult(userDto.getBirthDate())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User must be an adult.");
        }
        if (!isFrenchResident(userDto.getCountry())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User must be a French resident.");
        }
    }

    private boolean isAdult(Date birthDate) {
        LocalDate birthLocalDate = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate today = LocalDate.now();
        LocalDate eighteenYearsAgo = today.minusYears(18);

        return !birthLocalDate.isAfter(eighteenYearsAgo);
    }

    private boolean isFrenchResident(String country) {
        return "France".equalsIgnoreCase(country);
    }
}
