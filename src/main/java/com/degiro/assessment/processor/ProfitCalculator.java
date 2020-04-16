package com.degiro.assessment.processor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.degiro.assessment.exception.InvalidInputException;
import com.degiro.assessment.model.FlutPileProfitData;
import com.degiro.assessment.util.ProfitCalculatorUtils;
import com.degiro.assessment.validation.InputDataValidation;

/**
 * @author Sudhakaran Vasudevan
 * 
 *         This class perform operations to generate output data from given
 *         input
 *
 */
public class ProfitCalculator {

	private static final String INPUT_FILE = "input.txt";
	private static final String INPUT_FILE_EMPTY = "Input file is empty";
	private static final String INVALID_INPUT_DATA = "Input data is not in expected format";
	private static final int FLUT_PRICE_IN_HOLLAND = 10;
	private static final int OUTPUT_LIMIT = 10;

	/**
	 * @throws InvalidInputException
	 * @throws FileNotFoundException
	 * @throws IOException
	 * 
	 *  This method is to process Input and produce
	 *  corresponding profit data
	 */
	public void calculateProfit() throws InvalidInputException, FileNotFoundException, IOException {

		// Get input file as resource from classpath
		ClassLoader classLoader = getClass().getClassLoader();
		URL resource = classLoader.getResource(INPUT_FILE);

		// read the input line by line and process the data
		try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {

			String firstLine = br.readLine();

			if (firstLine != null) {

				int noOfFlutPilesInSchuurs = Integer.parseInt(firstLine.trim());

				calculateProfitForAllSchuurs(noOfFlutPilesInSchuurs, br);

			} else {
				throw new InvalidInputException(INPUT_FILE_EMPTY);
			}
		}

	}

	/**
	 * @param noOfFlutPilesInSchuur
	 * @param br
	 * @throws IOException
	 * @throws InvalidInputException
	 * 
	 *  This method called recursively to calculate
	 *  merchant profit data from input and print
	 */
	public void calculateProfitForAllSchuurs(int noOfFlutPilesInSchuurs, BufferedReader br)
			throws IOException, InvalidInputException {

		InputDataValidation validation = new InputDataValidation();

		// all possible number of fluts to buy from a schuurs for achieving max profit
		List<Integer> noOfFlutsToBuyFrmSchuurs = null;

		int totalProfitFromSchurrs = 0;

		for (int i = 0; i < noOfFlutPilesInSchuurs; i++) {
			String line = br.readLine();
			if (line != null) {
				String[] flutPile = line.split(" ");

				if (!validation.isValidPileInput(flutPile))
					throw new InvalidInputException(INVALID_INPUT_DATA);

				FlutPileProfitData profitDataFrmFlutPile = getProfitDataFromFlutPile(flutPile);
				totalProfitFromSchurrs += profitDataFrmFlutPile.getProfit();

				if (noOfFlutsToBuyFrmSchuurs != null) {
					noOfFlutsToBuyFrmSchuurs = ProfitCalculatorUtils.addListElements(noOfFlutsToBuyFrmSchuurs,
							profitDataFrmFlutPile.getNoOfFlutsToBuy());
				} else {
					noOfFlutsToBuyFrmSchuurs = profitDataFrmFlutPile.getNoOfFlutsToBuy();
				}

			} else {
				throw new InvalidInputException(INVALID_INPUT_DATA);
			}

		}

		printProfitDataForSchuurs(noOfFlutPilesInSchuurs, totalProfitFromSchurrs, noOfFlutsToBuyFrmSchuurs);

		String nextLine = br.readLine();

		if (nextLine != null) {
			int nextTestCase = Integer.parseInt(nextLine.trim());
			if (nextTestCase != 0)
				calculateProfitForAllSchuurs(nextTestCase, br);
		}
	}

	/**
	 * @param flutPile
	 * @return FlutPileProfitData
	 * 
	 *         This gets profitdata from a given flut pile
	 */
	public FlutPileProfitData getProfitDataFromFlutPile(String[] flutPile) {

		List<Integer> buyableFluts = new ArrayList<>();

		int profit = 0;

		for (int i = 1; i < flutPile.length; i++) {
			int flutPrice = Integer.parseInt(flutPile[i]);

			if ((flutPrice <= FLUT_PRICE_IN_HOLLAND)
					|| ProfitCalculatorUtils.isBuyableFlut(i, FLUT_PRICE_IN_HOLLAND, flutPile)) {
				buyableFluts.add(flutPrice);
				profit += (FLUT_PRICE_IN_HOLLAND - flutPrice);
			} else {
				break;

			}

		}

		return new FlutPileProfitData(profit, getNoOfFlutsToBuyForMaxProfit(profit, buyableFluts));
	}

	/**
	 * @param totalProfit
	 * @param buyableFluts
	 * @return noOfFlutsToBuyForMaxProfit
	 * 
	 *         This method is to return combination of different number of purchases
	 *         to get maximum profit
	 */
	public List<Integer> getNoOfFlutsToBuyForMaxProfit(int totalProfit, List<Integer> buyableFluts) {
		List<Integer> noOfFlutsToBuyForMaxProfit = new ArrayList<>();

		int profit = 0;

		for (int i = 0; i < buyableFluts.size(); i++) {
			profit += (FLUT_PRICE_IN_HOLLAND - buyableFluts.get(i));

			if (profit == totalProfit)
				noOfFlutsToBuyForMaxProfit.add(i + 1);
		}

		return noOfFlutsToBuyForMaxProfit;
	}

	/**
	 * @param noOfFlutPilesInSchuurs
	 * @param totalProfit
	 * @param noOfFlutsToBuy
	 * 
	 *   This method is to print the output
	 */
	public void printProfitDataForSchuurs(int noOfFlutPilesInSchuurs, int totalProfit, List<Integer> noOfFlutsToBuy) {

		System.out.println("schuurs " + noOfFlutPilesInSchuurs);
		System.out.println("Maximum profit is " + totalProfit + ".");
		System.out.print("Number of fluts to buy: ");
		noOfFlutsToBuy.stream().sorted().distinct().limit(OUTPUT_LIMIT).forEach(s -> {
			System.out.print(s + " ");
		});
		System.out.println("");
		System.out.println("");

	}

}
