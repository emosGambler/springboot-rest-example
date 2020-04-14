package com.goraj.jacek.springbootsandbox.restexample;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Player {
    private @Id @GeneratedValue long id;
    private String ranking;

    Player() { }

    Player(long id, String ranking) {
        this.id = id;
        this.ranking = ranking;
    }
}
