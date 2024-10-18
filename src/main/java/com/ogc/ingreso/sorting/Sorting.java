package com.ogc.ingreso.sorting;

import java.util.Comparator;
import java.util.List;

public class Sorting {

    /**
     * Se debe ordenar primero por puntuación de manera descendente, luego por
     * nombre de manera ascendente.
     *
     * @param players la lista de jugadores a ordenar
     * @return la lista ordenada de jugadores
     */
    public static List<Player> ordenarPorPuntuacionYNombre(List<Player> players) {
        // Ordenación de stream basado en las condiciones proporcionadas
        return players
                .stream()
                .sorted(Comparator.comparing(Player::getPoints, Comparator.reverseOrder())
                        .thenComparing(Player::getName))
                .toList();
    }

    /**
     * Se debe ordenar primero por puntuación de manera descendente. Cuando 2
     * jugadores tienen igual cantidad de puntos, el que tiene menos perdidas se lo
     * considerara el mayor. Luego a igual puntos y perdidas se seguirá usando el
     * nombre de manera ascendente.
     *
     * @param players la lista de jugadores a ordenar
     * @return la lista ordenada de jugadores
     */
    public static List<Player> ordenarPorPuntuacionPerdidasYNombre(List<Player> players) {
        // Ordenación de stream basado en las condiciones proporcionadas
        return players
                .stream()
                .sorted(Comparator.comparing(Player::getPoints, Comparator.reverseOrder())
                        .thenComparingInt(Player::getLosses)
                        .thenComparing(Player::getName))
                .toList();
    }
}
