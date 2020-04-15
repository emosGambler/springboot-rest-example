package com.goraj.jacek.springbootsandbox.restexample;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Player extends RepresentationModel<Player> {
    protected @Getter @Setter @Id @GeneratedValue long id;
    private String ranking;

    Player() { }

    Player(long id, String ranking) {
        this.id = id;
        this.ranking = ranking;
    }
}
