package com.goraj.jacek.springbootsandbox.restexample;

public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException(Long id) {
        super("Couldn not find player of id " + id);
    }
}
