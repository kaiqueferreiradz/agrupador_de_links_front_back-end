package com.projeto.links.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.links.model.Links;

public interface LinksRepository extends JpaRepository<Links, Long> {

    List<Links> findAllByUsercode(String string);

}
