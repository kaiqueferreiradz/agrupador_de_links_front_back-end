package com.projeto.links.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.links.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByNick(String nick);

    User getReferenceByNick(String nick);

}
