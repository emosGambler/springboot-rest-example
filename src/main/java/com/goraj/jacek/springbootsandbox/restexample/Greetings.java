package com.goraj.jacek.springbootsandbox.restexample;

public class Greetings {
    private final String message;
    private final long id;

    public Greetings(long id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public long getId() {
        return id;
    }
}
