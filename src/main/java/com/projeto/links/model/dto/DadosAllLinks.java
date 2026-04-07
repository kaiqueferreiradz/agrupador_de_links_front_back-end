package com.projeto.links.model.dto;

import com.projeto.links.model.Links;

public record DadosAllLinks(String usercode, String linx, String titulo) {

    public DadosAllLinks(Links links){
        this(links.getUsercode(), links.getLinx(), links.getTitulo());
    }

}
