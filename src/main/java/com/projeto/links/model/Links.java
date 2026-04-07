package com.projeto.links.model;

import com.projeto.links.model.dto.DadosLinks;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "links")
@Table(name = "links")
public class Links {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String usercode;
    private String linx;
    private String titulo;

    public Links(DadosLinks dados) {
        this.usercode = dados.usercode();
        this.linx = dados.linx();
        this.titulo = dados.titulo();
    }

    public Links() {
      
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsercode() {
        return usercode;
    }
    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }
    public String getLinx() {
        return linx;
    }
    public void setLinx(String linx) {
        this.linx = linx;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void up(String usercode2, String linx2, String titulo2) {

        if (usercode2 != null)this.usercode = usercode2;
        if (linx2 != null)this.linx = linx2;
        if (titulo2 != null)this.titulo = titulo2;
    }

}
