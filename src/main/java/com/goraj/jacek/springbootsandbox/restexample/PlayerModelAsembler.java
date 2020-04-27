package com.goraj.jacek.springbootsandbox.restexample;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PlayerModelAsembler implements RepresentationModelAssembler<Player, EntityModel<Player>> {

    @Override
    public EntityModel<Player> toModel(Player player) {
        return new EntityModel<>(player,
                linkTo(methodOn(PlayerController.class).getPlayer(player.id)).withSelfRel(),
                linkTo(methodOn((PlayerController.class)).getPlayers()).withRel("players"));
    }
}
