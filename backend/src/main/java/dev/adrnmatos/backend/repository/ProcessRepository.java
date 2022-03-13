package dev.adrnmatos.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.adrnmatos.backend.model.Process;

@Repository
public interface ProcessRepository extends CrudRepository<Process, Long> {
    Process findByProcessNumber(String processNumber);
}
