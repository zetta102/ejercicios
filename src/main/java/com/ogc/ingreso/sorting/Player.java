package com.ogc.ingreso.sorting;

public class Player {

    private final String name;
    private final int points;
    private final int losses;

    public Player(String name, int points) {
        this.name = name;
        this.points = points;
        this.losses = 0;
    }

    public Player(String name, int points, int losses) {
        this.name = name;
        this.points = points;
        this.losses = losses;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getLosses() {
        return losses;
    }

}
