package dev.adrnmatos.backend.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import dev.adrnmatos.backend.dto.ProcessDto;
import dev.adrnmatos.backend.model.Process;
import dev.adrnmatos.backend.repository.ProcessRepository;

public class ProcessMapper {
    
    @Autowired
    private static ProcessRepository repository;

    public static ProcessDto toProcessDto(Process process) {
        ProcessDto dto = new ProcessDto();

        dto.setProcessNumber(process.getProcessNumber());
        dto.setType(process.getType());
        dto.setParentNumber(process.getParent().getProcessNumber());
        dto.setJurisdicionado(process.getJurisdicionado());
        dto.setStatus(process.getStatus());

        return dto;
    }

    public static Process toProcessModel(ProcessDto processDto) {
        Process process = new Process();

        process.setProcessNumber(processDto.getProcessNumber());
        process.setType(processDto.getType());

        Process parentProcess = repository.findByProcessNumber(processDto.getParentNumber());
        process.setParent(parentProcess);
        
        process.setJurisdicionado(processDto.getJurisdicionado());
        process.setStatus(processDto.getStatus());

        return process;
    }
}
