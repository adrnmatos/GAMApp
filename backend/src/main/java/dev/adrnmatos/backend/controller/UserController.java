package dev.adrnmatos.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.adrnmatos.backend.model.User;
import dev.adrnmatos.backend.service.UserService;

@RestController
@RequestMapping(path = "/api/user", produces = "application/json")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }

}
