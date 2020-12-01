package com.example.attentipteamcharmander.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoriasResult {

    //@SerializedName("categorias")
    public List<Categoria> categorias;

    public CategoriasResult(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
}

