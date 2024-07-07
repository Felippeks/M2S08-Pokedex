package br.com.senai.health.pokedex.service;

import br.com.senai.health.pokedex.dto.PokemonCapturedDTO;
import br.com.senai.health.pokedex.dto.PokemonListDTO;
import br.com.senai.health.pokedex.dto.PokemonSeenDTO;
import br.com.senai.health.pokedex.model.Pokemon;
import br.com.senai.health.pokedex.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public void cadastrarPokemonVisto(PokemonSeenDTO pokemonSeenDTO) {
        Optional<Pokemon> pokemonExistente = pokemonRepository.findByNumero(pokemonSeenDTO.getNumero());
        Pokemon pokemon = pokemonExistente.orElseGet(() -> {
            Pokemon novoPokemon = new Pokemon();
            novoPokemon.setNumero(pokemonSeenDTO.getNumero());
            return novoPokemon;
        });

        if (!pokemon.getCapturado()) {
            pokemon.setNome(pokemonSeenDTO.getNome());
            pokemon.setImagemUrl(pokemonSeenDTO.getImagemUrl());
            pokemon.setAreaHabita(pokemonSeenDTO.getAreaHabita());
            pokemon.setCapturado(false);
            pokemonRepository.save(pokemon);
        }
    }

    public void cadastrarPokemonCapturado(PokemonCapturedDTO pokemonCapturedDTO) {
        Optional<Pokemon> pokemonExistente = pokemonRepository.findByNumero(pokemonCapturedDTO.getNumero());
        Pokemon pokemon = pokemonExistente.orElseGet(() -> {
            Pokemon novoPokemon = new Pokemon();
            novoPokemon.setNumero(pokemonCapturedDTO.getNumero());
            return novoPokemon;
        });

        pokemon.setNome(pokemonCapturedDTO.getNome());
        pokemon.setDescricao(pokemonCapturedDTO.getDescricao());
        pokemon.setImagemUrl(pokemonCapturedDTO.getImagemUrl());
        pokemon.setTipo(pokemonCapturedDTO.getTipo());
        pokemon.setCategoria(pokemonCapturedDTO.getCategoria());
        pokemon.setAreaHabita(pokemonCapturedDTO.getAreaHabita());
        pokemon.setAltura(pokemonCapturedDTO.getAltura());
        pokemon.setPeso(pokemonCapturedDTO.getPeso());
        pokemon.setCapturado(true);
        pokemonRepository.save(pokemon);
    }

    public Optional<Pokemon> atualizarPokemon(String numero, PokemonCapturedDTO pokemonDTO) {
        Optional<Pokemon> pokemonExistente = pokemonRepository.findByNumero(numero);
        pokemonExistente.ifPresent(pokemon -> {
            pokemon.setNome(pokemonDTO.getNome());
            pokemon.setDescricao(pokemonDTO.getDescricao());
            pokemon.setImagemUrl(pokemonDTO.getImagemUrl());
            pokemon.setTipo(pokemonDTO.getTipo());
            pokemon.setCategoria(pokemonDTO.getCategoria());
            pokemon.setAreaHabita(pokemonDTO.getAreaHabita());
            pokemon.setAltura(pokemonDTO.getAltura());
            pokemon.setPeso(pokemonDTO.getPeso());
            pokemon.setCapturado(pokemonDTO.getCapturado());
            pokemonRepository.save(pokemon);
        });
        return pokemonExistente;
    }
    public boolean excluirPokemonPeloNumero(String numero) {
        Optional<Pokemon> pokemon = pokemonRepository.findByNumero(numero);
        if (pokemon.isPresent()) {
            pokemonRepository.delete(pokemon.get());
            return true;
        } else {
            return false;
        }
    }

    public Optional<Pokemon> buscarPokemonPeloNumero(String numero) {
        return pokemonRepository.findByNumero(numero);
    }

    public List<PokemonListDTO> buscarTodosPokemons() {
        return pokemonRepository.findAll().stream()
                .map(pokemon -> new PokemonListDTO(pokemon.getNumero(), pokemon.getNome(), pokemon.getCapturado()))
                .collect(Collectors.toList());
    }
}