package com.goraj.jacek.springbootsandbox.restexample;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PlayerController {

    private final PlayerRepository repository;

    PlayerController(PlayerRepository repository) {
        this.repository = repository;
    }

    private final AtomicLong counter = new AtomicLong();

    @GetMapping(path = "/players")
    public List<Player> getPlayers(@RequestParam(value = "ranking", defaultValue = "1") String ranking) {
        return repository.findAll();
    }

    @GetMapping(path = "/players/{id}")
    public Player getPlayer(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new PlayerNotFoundException(id));
    }

    @PostMapping(path = "/players", consumes = "application/json", produces = "application/json")
    public Player newPlayer(@RequestBody Player player) {
        return repository.save(player);
    }
}
