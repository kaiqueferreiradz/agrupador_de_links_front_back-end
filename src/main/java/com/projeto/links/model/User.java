package com.projeto.links.model;

import com.projeto.links.model.dto.DadosUser;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "users")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String foto;
    private String usercode;
    private String nick;
    private String senha;

    public User(DadosUser dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.foto = dados.foto();
        this.usercode = dados.usercode();
        this.nick = dados.nick();
        this.senha =dados.senha();
    }
    public User() {}

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }
    public String getUsercode() {
        return usercode;
    }
    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }
    public String getNick() {
        return nick;
    }
    public void setNick(String nick) {
        this.nick = nick;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void up(
        String nome,
        String email,
        String foto,
        String usercode,
        String nick,
        String senha
    ){
        if (nome != null)this.nome = nome;
        if (email != null)this.email = email;
        if (foto != null)this.foto = foto;
        if (usercode != null)this.usercode = usercode;
        if (nick != null)this.nick = nick;
        if (senha != null)this.senha = senha;
    }

}
