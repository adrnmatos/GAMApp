package dev.adrnmatos.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.adrnmatos.backend.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
