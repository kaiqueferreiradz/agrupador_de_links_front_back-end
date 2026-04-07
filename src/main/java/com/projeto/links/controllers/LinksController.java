package com.projeto.links.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.links.model.Links;
import com.projeto.links.model.dto.DadosAllLinks;
import com.projeto.links.model.dto.DadosCode;
import com.projeto.links.model.dto.DadosLinks;
import com.projeto.links.model.dto.DadosUpLinks;
import com.projeto.links.repositories.LinksRepository;

import jakarta.transaction.Transactional;
//@CrossOrigin(origins = {"http://localhost:5173", "http://192.168.1.9:5173"})
//@CrossOrigin(origins = {"http://192.168.1.9:5173"})
@CrossOrigin
@RestController
@RequestMapping("link")
public class LinksController {

    @Autowired
    private LinksRepository rep;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody DadosLinks dados){
        var linkx = new Links(dados);
        rep.save(linkx);

        return ResponseEntity.created(null).build();

    }

    @GetMapping
    public ResponseEntity<List<DadosAllLinks>> read(){
        var list = rep.findAll().stream().map(DadosAllLinks::new).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("{code}")
    public ResponseEntity<List<DadosCode>> readCode(@PathVariable("code") String code) {
        var links = rep.findAllByUsercode(code).stream().map(DadosCode::new).toList();
        return ResponseEntity.ok(links);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosCode> update(@RequestBody DadosUpLinks dados){ 
        var novo = rep.getReferenceById(dados.id());
        novo.up(dados.usercode(), dados.linx(), dados.titulo());

        return ResponseEntity.ok(new DadosCode(novo));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        rep.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
