package com.degiro.assessment.model;

import java.util.List;

/**
 * @author Sudhakaran
 * 
 * Model object to store profitdata from flutPile
 *
 */
public class FlutPileProfitData {
	
	private int profit;
	private List<Integer> noOfFlutsToBuy;
	
	public FlutPileProfitData(int profit, List<Integer> noOfFlutsToBuy) {
		super();
		this.profit = profit;
		this.noOfFlutsToBuy = noOfFlutsToBuy;
	}
	
	public int getProfit() {
		return profit;
	}
	
	public List<Integer> getNoOfFlutsToBuy() {
		return noOfFlutsToBuy;
	}
	
}
