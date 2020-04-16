package com.degiro.assessment.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ProfitCalculatorUtlisTest {

	@Test
	public void addListElementsTest() {
		List<Integer> firstList = new ArrayList<>();
		firstList.add(1);
		firstList.add(2);

		List<Integer> secondList = new ArrayList<>();
		secondList.add(10);
		secondList.add(20);

		List<Integer> expectedList = new ArrayList<>();
		expectedList.add(11);
		expectedList.add(21);
		expectedList.add(12);
		expectedList.add(22);

		List<Integer> actualList = ProfitCalculatorUtils.addListElements(firstList, secondList);

		assertNotNull(actualList);
		assertFalse(actualList.isEmpty());
		assertEquals(actualList.size(),((firstList.size()*secondList.size())));
		assertTrue(expectedList.equals(actualList));
	}

	@Test
	public void isBuyableFlutTest() {

		// valid case1
		String[] flutPile1 = { "4", "2", "6", "10", "15" };
		assertTrue(ProfitCalculatorUtils.isBuyableFlut(1, 10, flutPile1));

		// valid case2

		String[] flutPile2 = { "3", "12", "6", "10" };
		assertTrue(ProfitCalculatorUtils.isBuyableFlut(1, 10, flutPile2));

		// invalid case
		String[] flutPile3 = { "4", "12", "9", "10", "15" };
		assertFalse(ProfitCalculatorUtils.isBuyableFlut(1, 10, flutPile3));

	}
}
