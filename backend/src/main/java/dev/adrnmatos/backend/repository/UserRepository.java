package dev.adrnmatos.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.adrnmatos.backend.model.User;
import dev.adrnmatos.backend.model.User.Formacao;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Iterable<User> findByFormacao(Formacao formacao);

}
