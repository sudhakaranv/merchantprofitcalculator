package com.degiro.assessment.processor;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.degiro.assessment.model.FlutPileProfitData;

public class ProfitCalculatorTest {

	ProfitCalculator profitCalculator = new ProfitCalculator();

	@Test
	public void getNoOfFlutsToBuyForMaxProfitTest() {

		List<Integer> buyableFlutList = new ArrayList<>();

		buyableFlutList.add(7);
		buyableFlutList.add(3);
		buyableFlutList.add(15);
		buyableFlutList.add(5);
		buyableFlutList.add(10);

		int totalProfit = 10;

		List<Integer> expectedNoOfFlutsToBuy = new ArrayList<>();

		expectedNoOfFlutsToBuy.add(2);
		expectedNoOfFlutsToBuy.add(4);
		expectedNoOfFlutsToBuy.add(5);

		List<Integer> actualNoOfFlutsToBuy = profitCalculator.getNoOfFlutsToBuyForMaxProfit(totalProfit,
				buyableFlutList);

		assertNotNull(actualNoOfFlutsToBuy);
		assertFalse(actualNoOfFlutsToBuy.isEmpty());
		assertTrue(expectedNoOfFlutsToBuy.equals(actualNoOfFlutsToBuy));

	}

	@Test
	public void getProfitDataFromFlutPileTest() {
		String[] flutPile = { "5", "1", "7", "11", "8", "10", "10", "12" };
		int expectedProfit = 13;

		List<Integer> expectedNoOfFlutsToBuy = new ArrayList<>();
		expectedNoOfFlutsToBuy.add(4);
		expectedNoOfFlutsToBuy.add(5);
		expectedNoOfFlutsToBuy.add(6);

		FlutPileProfitData flutPileProfitData = profitCalculator.getProfitDataFromFlutPile(flutPile);

		assertNotNull(flutPileProfitData);
		assertEquals(expectedProfit, flutPileProfitData.getProfit());
		assertTrue(expectedNoOfFlutsToBuy.equals(flutPileProfitData.getNoOfFlutsToBuy()));

	}
}
