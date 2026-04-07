package com.projeto.links.model.dto;

import com.projeto.links.model.User;

public record DadosTotalUser(
    Long id,
    String nome,
    String email,
    String foto,
    String usercode,
    String nick,
    String senha
) {
    public DadosTotalUser(User user){
        this(user.getId(),user.getNome(), user.getEmail(),user.getFoto(),user.getUsercode(),user.getNick(),user.getSenha());
    }
}
