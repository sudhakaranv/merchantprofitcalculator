package com.degiro.assessment.validation;

import static org.junit.Assert.*;

import org.junit.Test;

public class InputDataValidationTest {

	InputDataValidation inputDataValidation = new InputDataValidation();

	@Test
	public void isFlutPileSizeValidTest() {
		// invalid case
		String[] flutPile1 = { "1" };

		assertFalse(inputDataValidation.isFlutPileSizeValid(flutPile1));

		// valid case
		String[] flutPile2 = { "1", "1" };

		assertTrue(inputDataValidation.isFlutPileSizeValid(flutPile2));
	}

	@Test
	public void isNumberOfFlutsInPileCorrectTest() {
		// invalid case
		String[] flutPile1 = { "3", "2", "21", "6", "10" };

		assertFalse(inputDataValidation.isNumberOfFlutsInPileCorrect(flutPile1));

		// valid case
		String[] flutPile2 = { "2", "11", "5" };

		assertTrue(inputDataValidation.isNumberOfFlutsInPileCorrect(flutPile2));
	}

	@Test
	public void isDataNotEmptyTest() {

		// invalid case
		String[] flutPile1 = { "4", "2", "", "6", "10" };

		assertFalse(inputDataValidation.isDataNotEmpty(flutPile1));

		// valid case
		String[] flutPile2 = { "2", "6", "7" };

		assertTrue(inputDataValidation.isDataNotEmpty(flutPile2));

	}

	@Test
	public void isValidPileInputTest() {

		// valid test
		String[] flutPile1 = { "3", "4", "5", "11" };

		assertTrue(inputDataValidation.isValidPileInput(flutPile1));

		// invalid case 1
		String[] flutPile2 = { "1" };

		assertFalse(inputDataValidation.isValidPileInput(flutPile2));

		// invalid case 2
		String[] flutPile3 = { "3", "2", "21", "6", "10" };

		assertFalse(inputDataValidation.isValidPileInput(flutPile3));

		// invalid case 3
		String[] flutPile4 = { "4", "2", "", "6", "10" };

		assertFalse(inputDataValidation.isValidPileInput(flutPile4));

	}

}
