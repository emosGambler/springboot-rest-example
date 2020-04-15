package com.goraj.jacek.springbootsandbox.restexample;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@RestController
public class PlayerController {

    private final PlayerRepository repository;

    PlayerController(PlayerRepository repository) {
        this.repository = repository;
    }

    private final AtomicLong counter = new AtomicLong();

    @GetMapping(path = "/players")
    public CollectionModel<EntityModel<Player>> getPlayers() {
        List<EntityModel<Player>> players = repository.findAll().stream()
                .map(player -> new EntityModel<>(player,
                        linkTo(methodOn(PlayerController.class).getPlayers()).withSelfRel(),
                        linkTo(methodOn(PlayerController.class).getPlayers()).withRel("players")))
                .collect(Collectors.toList());
        return new CollectionModel(players,
                linkTo(methodOn(PlayerController.class).getPlayers()).withSelfRel());
    }

    @GetMapping(path = "/players/{id}")
    public EntityModel<Player> getPlayer(@PathVariable Long id) {
        Player player = repository.findById(id).orElseThrow(() -> new PlayerNotFoundException(id));

        return new EntityModel<>(player,
                linkTo(methodOn(PlayerController.class).getPlayer(id)).withSelfRel(),
                linkTo(methodOn((PlayerController.class)).getPlayers()).withRel("players"));
    }

    @PostMapping(path = "/players", consumes = "application/json", produces = "application/json")
    public EntityModel<Player> newPlayer(@RequestBody Player player) {
        repository.save(player);
        return new EntityModel<>(player,
                linkTo(methodOn(PlayerController.class).newPlayer(player)).withSelfRel());
    }
}
