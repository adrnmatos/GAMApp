package dev.adrnmatos.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.adrnmatos.backend.dto.ProcessDto;
import dev.adrnmatos.backend.service.ProcessService;

@RestController
@RequestMapping(path = "/api/processes", produces = "application/json")
@CrossOrigin
public class ProcessController {

    @Autowired
    private ProcessService service;

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProcessDto> processes(@RequestBody ProcessDto processDto) {
        return new ResponseEntity<>(service.createProcess(processDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProcessDto>> processes() {
        return new ResponseEntity<>(service.getProcesses(), HttpStatus.OK);
    }
    
}
