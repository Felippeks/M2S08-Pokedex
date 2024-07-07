package br.com.senai.health.pokedex.dto;

public class PokemonCapturedDTO {
    private String numero;
    private String nome;
    private String descricao;
    private String imagemUrl;
    private String tipo;
    private String categoria;
    private String areaHabita;
    private Double altura;
    private Double peso;
    private Boolean capturado;

    // Constructors
    public PokemonCapturedDTO() {
    }

    public PokemonCapturedDTO(String numero, String nome, String descricao, String imagemUrl, String tipo, String categoria, String areaHabita, Double altura, Double peso, Boolean capturado) {
        this.numero = numero;
        this.nome = nome;
        this.descricao = descricao;
        this.imagemUrl = imagemUrl;
        this.tipo = tipo;
        this.categoria = categoria;
        this.areaHabita = areaHabita;
        this.altura = altura;
        this.peso = peso;
        this.capturado = capturado;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAreaHabita() {
        return areaHabita;
    }

    public void setAreaHabita(String areaHabita) {
        this.areaHabita = areaHabita;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Boolean getCapturado() {
        return capturado;
    }

    public void setCapturado(Boolean capturado) {
        this.capturado = capturado;
    }
}