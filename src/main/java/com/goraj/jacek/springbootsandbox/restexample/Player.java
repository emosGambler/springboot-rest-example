package com.goraj.jacek.springbootsandbox.restexample;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Player extends RepresentationModel<Player> {
    @Getter @Setter @Id @GeneratedValue protected long id;
    @NotNull @Getter @Setter private String points;
    @NotNull @Getter @Setter private String name;

    Player() { }

    Player(long id, String points, String name) {
        this.id = id;
        this.points = points;
        this.name = name;
    }
}
