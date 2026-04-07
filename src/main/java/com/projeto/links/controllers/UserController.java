package com.projeto.links.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.links.model.User;
import com.projeto.links.model.dto.DadosAllUser;
import com.projeto.links.model.dto.DadosTotalUser;
import com.projeto.links.model.dto.DadosUpUser;
import com.projeto.links.model.dto.DadosUser;
import com.projeto.links.repositories.UserRepository;

import jakarta.transaction.Transactional;

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


@RestController
@RequestMapping("user")
//@CrossOrigin(origins = {"http://localhost:5173", "http://192.168.1.9:5173"})
//@CrossOrigin(origins = {"http://192.168.1.9:5173"})
@CrossOrigin
public class UserController {

    @Autowired
    private UserRepository rep;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> create(@RequestBody DadosUser dados){
        rep.save(new User(dados));
        return ResponseEntity.created(null).build();

    }

    @GetMapping
    public ResponseEntity<List<DadosAllUser>> read() {
        var list = rep.findAll().stream().map(DadosAllUser::new).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<DadosTotalUser> readid(@PathVariable("id") Long id) throws Exception {
        var userx = rep.getReferenceById(id);
        return ResponseEntity.ok(new DadosTotalUser(userx));
    }

    @GetMapping("n/{nick}")
    public ResponseEntity<User> readnick(@PathVariable("nick") String nick) {
        return ResponseEntity.ok(rep.getReferenceByNick(nick));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<String> update(@RequestBody DadosUpUser dados){
        var novo = rep.getReferenceById(dados.id());
        novo.up(dados.nome(), dados.email(), dados.foto(), dados.usercode(), dados.nick(), dados.senha());

        return ResponseEntity.ok(dados.nome());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id)
    {
        rep.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    

}
