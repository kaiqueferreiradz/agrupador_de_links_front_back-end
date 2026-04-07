package com.projeto.links.model.dto;

import com.projeto.links.model.User;

public record DadosAllUser(
    String nome,
    String email,
    String foto,
    String usercode,
    String nick,
    String senha
) {
    public DadosAllUser(User user){
        this(user.getNome(), user.getEmail(), user.getFoto(), user.getUsercode(), user.getNick(), user.getSenha());
    }

}
