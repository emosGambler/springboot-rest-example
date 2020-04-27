package com.goraj.jacek.springbootsandbox.restexample;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.google.common.collect.Sets;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@RestController
public class PlayerController {

    private final PlayerRepository repository;
    private final PlayerModelAsembler assembler;

    PlayerController(PlayerRepository repository, PlayerModelAsembler assembler) {
        this.assembler = assembler;
        this.repository = repository;
    }

    private final AtomicLong counter = new AtomicLong();

    @GetMapping(path = "/players")
    public CollectionModel<EntityModel<Player>> getPlayers() {
        List<EntityModel<Player>> players = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return new CollectionModel(players,
                linkTo(methodOn(PlayerController.class).getPlayers()).withSelfRel());
    }

    @GetMapping(path = "/players/{id}")
    public EntityModel<Player> getPlayer(@PathVariable Long id) {
        Player player = repository.findById(id).orElseThrow(() -> new PlayerNotFoundException(id));

        return assembler.toModel(player);
    }

    @PostMapping(path = "/players", consumes = "application/json", produces = "application/json")
    public EntityModel<Player> newPlayer(@RequestBody Player player) {
        repository.save(player);
        return new EntityModel<>(player,
                linkTo(methodOn(PlayerController.class).newPlayer(player)).withSelfRel());
    }
}
