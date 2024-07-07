package br.com.senai.health.pokedex.controller;

import br.com.senai.health.pokedex.dto.PokemonCapturedDTO;
import br.com.senai.health.pokedex.dto.PokemonSeenDTO;
import br.com.senai.health.pokedex.model.Pokemon;
import br.com.senai.health.pokedex.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @PostMapping("/visto")
    public ResponseEntity<?> cadastrarPokemonVisto(@RequestBody PokemonSeenDTO pokemonSeenDTO) {
        pokemonService.cadastrarPokemonVisto(pokemonSeenDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/capturado")
    public ResponseEntity<?> cadastrarPokemonCapturado(@RequestBody PokemonCapturedDTO pokemonCapturedDTO) {
        pokemonService.cadastrarPokemonCapturado(pokemonCapturedDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{numero}")
    public ResponseEntity<?> atualizarPokemon(@PathVariable String numero, @RequestBody PokemonCapturedDTO pokemonDTO) {
        Optional<Pokemon> pokemonAtualizado = pokemonService.atualizarPokemon(numero, pokemonDTO);
        return pokemonAtualizado.map(pokemon -> ResponseEntity.ok().build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{numero}")
    public ResponseEntity<?> excluirPokemon(@PathVariable String numero) {
        boolean excluido = pokemonService.excluirPokemonPeloNumero(numero);
        if (excluido) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{numero}")
    public ResponseEntity<Pokemon> obterPokemonPeloNumero(@PathVariable String numero) {
        Optional<Pokemon> pokemon = pokemonService.buscarPokemonPeloNumero(numero);
        return pokemon.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}