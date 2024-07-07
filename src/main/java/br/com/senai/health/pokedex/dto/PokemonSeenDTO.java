package br.com.senai.health.pokedex.dto;

public class PokemonSeenDTO {
    private String numero;
    private String nome;
    private String imagemUrl;
    private String areaHabita;

    // Constructors
    public PokemonSeenDTO() {
    }

    public PokemonSeenDTO(String numero, String nome, String imagemUrl, String areaHabita) {
        this.numero = numero;
        this.nome = nome;
        this.imagemUrl = imagemUrl;
        this.areaHabita = areaHabita;
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
}