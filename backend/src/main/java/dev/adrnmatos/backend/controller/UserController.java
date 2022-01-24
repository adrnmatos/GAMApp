package dev.adrnmatos.backend.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.adrnmatos.backend.dto.UserDto;
import dev.adrnmatos.backend.model.User;
import dev.adrnmatos.backend.service.UserService;

@RestController
@RequestMapping(path = "/api/users", produces = "application/json")
@CrossOrigin
// @RequestMapping(path = "/api/users", produces = "application/hal+json")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> users() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> users(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserDto> users(@Valid @RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/cargos")
    public List<User.Cargo> cargos() {
        return Arrays.asList(User.Cargo.values());
    }

    @GetMapping("/funcoes")
    public List<User.Funcao> funcoes() {
        return Arrays.asList(User.Funcao.values());
    }

    @GetMapping("/formacoes")
    public List<User.Formacao> formacoes() {
        return Arrays.asList(User.Formacao.values());
    }
}
