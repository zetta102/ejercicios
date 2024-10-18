package com.ogc.ingreso.strings;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepeatedCharactersTest {
	
	private final RepeatedCharacters repeatedCharacters = new RepeatedCharacters();

	@Test
	public void isValidSimple() {
		String input = "a3o1oa3";
		assertTrue(this.repeatedCharacters.isValid(input));
		assertTrue(this.repeatedCharacters.isValid("aa3311oo"));
	}

	@Test
	public void isValidWithSpaces() {
		String input = " ellemmeennttaall  mmaattssssnn";
		assertTrue(this.repeatedCharacters.isValid(input));
		assertFalse(this.repeatedCharacters.isValid(" eelleemmeennttaall  mmii  qquueerriiddoo  wwaattssoonn"));
	}
	
	@Test
	public void isValidWithExtraChar() {
		String input = "aabbccc";
		assertTrue(this.repeatedCharacters.isValid(input));
		assertFalse(this.repeatedCharacters.isValid("aaabbc"));
	}

	
	@Test
	public void isValidCustom() {
		String input = "222111333555   5";
		assertTrue(this.repeatedCharacters.isValid(input));
	}

}
