package com.ogc.ingreso.sorting;



import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortingTest {
	
	@Test
	public void sort1Completo() {
		Player p1 = new Player("Matias", 100);
		Player p2 = new Player("Alejandro", 100);
		Player p3 = new Player("Enzo", 50);
		Player p4 = new Player("Junior", 75);
		Player p5 = new Player("Pablo", 150);
		List<Player> jugadores = new ArrayList<>();
		jugadores.add(p1);
		jugadores.add(p2);
		jugadores.add(p3);
		jugadores.add(p4);
		jugadores.add(p5);
		
		List<Player> jugadoresResult = Sorting.ordenarPorPuntuacionYNombre(jugadores);
		
		Player p1Sort = new Player("Pablo", 150);
		Player p2Sort = new Player("Alejandro", 100);
		Player p3Sort = new Player("Matias", 100);
		Player p4Sort = new Player("Junior", 75);
		Player p5Sort = new Player("Enzo", 50);
		List<Player> jugadoresSort = new ArrayList<>();
		jugadoresSort.add(p1Sort);
		jugadoresSort.add(p2Sort);
		jugadoresSort.add(p3Sort);
		jugadoresSort.add(p4Sort);
		jugadoresSort.add(p5Sort);


        assertEquals(jugadoresSort.size(), jugadoresResult.size());
        assertEquals(jugadoresSort.get(0).getName(), jugadoresResult.get(0).getName());
        assertEquals(jugadoresSort.get(1).getName(), jugadoresResult.get(1).getName());
        assertEquals(jugadoresSort.get(2).getName(), jugadoresResult.get(2).getName());
        assertEquals(jugadoresSort.get(3).getName(), jugadoresResult.get(3).getName());
        assertEquals(jugadoresSort.get(4).getName(), jugadoresResult.get(4).getName());
		
		jugadores = new ArrayList<>();
		jugadoresResult = Sorting.ordenarPorPuntuacionYNombre(jugadores);
		assertTrue(jugadoresResult.isEmpty());
		
		jugadores = new ArrayList<>();
		jugadores.add(p1);
		jugadoresResult = Sorting.ordenarPorPuntuacionYNombre(jugadores);
        assertEquals(1, jugadoresResult.size());
        assertEquals(p1.getName(), jugadoresResult.getFirst().getName());
	}

	@Test
	public void sort1Vacio() {
		List<Player> jugadores = new ArrayList<>();
		List<Player> jugadoresResult = Sorting.ordenarPorPuntuacionYNombre(jugadores);
		assertTrue(jugadoresResult.isEmpty());
	}

	@Test
	public void sort1Unico() {
		Player p1 = new Player("Matias", 100);
		List<Player> jugadores = new ArrayList<>();
		jugadores.add(p1);
		List<Player> jugadoresResult = Sorting.ordenarPorPuntuacionYNombre(jugadores);
        assertEquals(1, jugadoresResult.size());
        assertEquals(p1.getName(), jugadoresResult.getFirst().getName());
	}

	@Test
	public void sort2Completo() {
		
		Player p1 = new Player("Matias", 100, 3);
		Player p2 = new Player("Alejandro", 100, 4);
		Player p3 = new Player("Enzo", 75, 5);
		Player p4 = new Player("Junior", 75, 30);
		Player p5 = new Player("Pablo", 150, 0);
		List<Player> jugadores = new ArrayList<>();
		jugadores.add(p1);
		jugadores.add(p2);
		jugadores.add(p3);
		jugadores.add(p4);
		jugadores.add(p5);
		
		List<Player> jugadoresResult = Sorting.ordenarPorPuntuacionPerdidasYNombre(jugadores);
		
		Player p1Sort = new Player("Pablo", 150, 0);
		Player p2Sort = new Player("Matias", 100, 3);
		Player p3Sort = new Player("Alejandro", 100, 4);
		Player p4Sort = new Player("Enzo", 75, 5);
		Player p5Sort = new Player("Junior", 75, 30);
		
		List<Player> jugadoresSort = new ArrayList<>();
		jugadoresSort.add(p1Sort);
		jugadoresSort.add(p2Sort);
		jugadoresSort.add(p3Sort);
		jugadoresSort.add(p4Sort);
		jugadoresSort.add(p5Sort);


        assertEquals(jugadoresSort.size(), jugadoresResult.size());
        assertEquals(jugadoresSort.get(0).getName(), jugadoresResult.get(0).getName());
        assertEquals(jugadoresSort.get(1).getName(), jugadoresResult.get(1).getName());
        assertEquals(jugadoresSort.get(2).getName(), jugadoresResult.get(2).getName());
        assertEquals(jugadoresSort.get(3).getName(), jugadoresResult.get(3).getName());
        assertEquals(jugadoresSort.get(4).getName(), jugadoresResult.get(4).getName());
	}

    @Test
    public void sort2Vacio() {
        List<Player> jugadores = new ArrayList<>();
        List<Player> jugadoresResult = Sorting.ordenarPorPuntuacionPerdidasYNombre(jugadores);
        assertTrue(jugadoresResult.isEmpty());
    }

    @Test
    public void sort2Unico() {
        Player p1 = new Player("Matias", 100);
        List<Player> jugadores = new ArrayList<>();
        jugadores.add(p1);
        List<Player> jugadoresResult = Sorting.ordenarPorPuntuacionPerdidasYNombre(jugadores);
        assertEquals(1, jugadoresResult.size());
        assertEquals(p1.getName(), jugadoresResult.getFirst().getName());
    }


}
