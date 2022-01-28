package dev.adrnmatos.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.adrnmatos.backend.dto.UserDto;
import dev.adrnmatos.backend.dto.mapper.UserMapper;
import dev.adrnmatos.backend.model.User;
import dev.adrnmatos.backend.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    public List<UserDto> getUsers() {

        List<UserDto> userList = new ArrayList<>();
        userRepo.findAll().forEach(user -> {
            userList.add(UserMapper.toUserDto(user));
        });
        return userList;
    }

    public UserDto getUser(Long id) {
        Optional<User> optUser = userRepo.findById(id);
        if(optUser.isPresent())
            return UserMapper.toUserDto((User) optUser.get());
        return null;
    }

    public UserDto createUser(UserDto userDto) {
        return UserMapper.toUserDto(userRepo.save(UserMapper.toUserModel(userDto)));
    }

    public List<UserDto> findUsersByFormacao(User.Formacao formacao) {

        List<UserDto> userList = new ArrayList<>();
        userRepo.findByFormacao(formacao).forEach(user -> {
            userList.add(UserMapper.toUserDto(user));
        });
        return userList;
    }

}
