package dev.adrnmatos.backend.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.adrnmatos.backend.dto.ProcessDto;
import dev.adrnmatos.backend.model.Process;
import dev.adrnmatos.backend.repository.ProcessRepository;

@Component
public class ProcessMapper {
    
    private static ProcessRepository repository;

    @Autowired
    public ProcessMapper(ProcessRepository repository) {
        ProcessMapper.repository = repository;
    }

    public static ProcessDto toProcessDto(Process process) {
        ProcessDto dto = new ProcessDto();

        dto.setProcessNumber(process.getProcessNumber());
        dto.setType(process.getType());
        if(process.getParent()!= null)
            dto.setParentNumber(process.getParent().getProcessNumber());
        dto.setJurisdicionado(process.getJurisdicionado());
        dto.setStatus(process.getStatus());

        return dto;
    }

    public static Process toProcessModel(ProcessDto processDto) {
        Process process = new Process();

        process.setProcessNumber(processDto.getProcessNumber());
        process.setType(processDto.getType());

        if(processDto.getParentNumber() != null) {
            Process parentProcess = repository.findByProcessNumber(processDto.getParentNumber());
            System.out.printf("parentProcess: %s", parentProcess);
            process.setParent(parentProcess);
        }
        
        process.setJurisdicionado(processDto.getJurisdicionado());
        process.setStatus(processDto.getStatus());

        return process;
    }
}
