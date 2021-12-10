package dev.adrnmatos.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.adrnmatos.backend.model.User;
import dev.adrnmatos.backend.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    public Iterable<User> getUsers() {
        return userRepo.findAll();
    }

}
