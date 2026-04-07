package com.projeto.links.model.dto;

import com.projeto.links.model.Links;

public record DadosCode(Long id, String usercode, String linx, String titulo) {

    public DadosCode(Links links){
        this(links.getId(), links.getUsercode(), links.getLinx(), links.getTitulo());
    }

}
