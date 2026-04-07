package com.projeto.links.model.dto;

import jakarta.validation.constraints.NotNull;

public record DadosUpUser(
    @NotNull
    Long id,
    String nome,
    String email,
    String foto,
    String usercode,
    String nick,
    String senha
) {

}
