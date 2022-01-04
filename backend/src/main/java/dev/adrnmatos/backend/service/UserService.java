package dev.adrnmatos.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.adrnmatos.backend.dto.UserDto;
import dev.adrnmatos.backend.dto.mapper.UserMapper;
import dev.adrnmatos.backend.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    public List<UserDto> getAllUsers() {

        List<UserDto> userList = new ArrayList<>();
        userRepo.findAll().forEach(user -> {
            userList.add(UserMapper.toUserDto(user));
        });
        return userList;
    }

    public UserDto createUser(UserDto userDto) {
        return UserMapper.toUserDto(userRepo.save(UserMapper.toUserModel(userDto)));
    }

}
