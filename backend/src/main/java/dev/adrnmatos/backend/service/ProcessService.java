package dev.adrnmatos.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dev.adrnmatos.backend.dto.ProcessDto;
import dev.adrnmatos.backend.dto.mapper.ProcessMapper;
import dev.adrnmatos.backend.repository.ProcessRepository;

public class ProcessService {

    @Autowired ProcessRepository repository;

    public ProcessDto createProcess(ProcessDto processDto) {
        return ProcessMapper.toProcessDto(repository.save(ProcessMapper.toProcessModel(processDto)));
    }

    public List<ProcessDto> getProcesses() {
        List<ProcessDto> processList = new ArrayList<>();
        repository.findAll().forEach(process -> {
            processList.add(ProcessMapper.toProcessDto(process));
        });
        return processList;
    }    
}
