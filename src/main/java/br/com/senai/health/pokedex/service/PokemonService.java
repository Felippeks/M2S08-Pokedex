package br.com.senai.health.pokedex.service;

import br.com.senai.health.pokedex.dto.PokemonCapturedDTO;
import br.com.senai.health.pokedex.dto.PokemonSeenDTO;
import br.com.senai.health.pokedex.model.Pokemon;
import br.com.senai.health.pokedex.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public void cadastrarPokemonVisto(PokemonSeenDTO pokemonSeenDTO) {
        Pokemon pokemon = new Pokemon();
        pokemon.setNumero(pokemonSeenDTO.getNumero());
        pokemon.setNome(pokemonSeenDTO.getNome());
        pokemon.setImagemUrl(pokemonSeenDTO.getImagemUrl());
        pokemon.setAreaHabita(pokemonSeenDTO.getAreaHabita());
        pokemon.setCapturado(false); // Definindo como visto, não capturado
        pokemonRepository.save(pokemon);
    }

    public void cadastrarPokemonCapturado(PokemonCapturedDTO pokemonCapturedDTO) {
        Pokemon pokemon = new Pokemon();
        pokemon.setNumero(pokemonCapturedDTO.getNumero());
        pokemon.setNome(pokemonCapturedDTO.getNome());
        pokemon.setDescricao(pokemonCapturedDTO.getDescricao());
        pokemon.setImagemUrl(pokemonCapturedDTO.getImagemUrl());
        pokemon.setTipo(pokemonCapturedDTO.getTipo());
        pokemon.setCategoria(pokemonCapturedDTO.getCategoria());
        pokemon.setAreaHabita(pokemonCapturedDTO.getAreaHabita());
        pokemon.setAltura(pokemonCapturedDTO.getAltura());
        pokemon.setPeso(pokemonCapturedDTO.getPeso());
        pokemon.setCapturado(true); // Definindo como capturado
        pokemonRepository.save(pokemon);
    }

//    public Optional<Pokemon> buscarPokemonPeloNumero(String numero) {
//        return pokemonRepository.findByNumero(numero);
//    }
}