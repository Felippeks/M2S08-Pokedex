package br.com.senai.health.pokedex.dto;

import br.com.senai.health.pokedex.model.Type;

public class PokemonSeenDTO {
    private String numero;
    private String nome;
    private String imagemUrl;
    private String areaHabita;
    private Type tipo;

    // Constructors
    public PokemonSeenDTO() {
    }

    public PokemonSeenDTO(String numero, String nome, String imagemUrl, String areaHabita, Type tipo) {
        this.numero = numero;
        this.nome = nome;
        this.imagemUrl = imagemUrl;
        this.areaHabita = areaHabita;
        this.tipo = tipo;
    }

    // Getters and Setters
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public String getAreaHabita() {
        return areaHabita;
    }

    public void setAreaHabita(String areaHabita) {
        this.areaHabita = areaHabita;
    }

    public Type getTipo() {
        return tipo;
    }

    public void setTipo(Type tipo) {
        this.tipo = tipo;
    }
}