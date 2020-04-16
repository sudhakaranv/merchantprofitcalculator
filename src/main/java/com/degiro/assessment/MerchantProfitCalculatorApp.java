package com.degiro.assessment;

import com.degiro.assessment.processor.ProfitCalculator;

/**
 * @author Sudhakaran Vasudevan
 * 
 *         Main class for Merchant Profit calculator application
 *
 */
public class MerchantProfitCalculatorApp {

	public static void main(String[] args) {

		ProfitCalculator calculator = new ProfitCalculator();
		try {
			calculator.calculateProfit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
