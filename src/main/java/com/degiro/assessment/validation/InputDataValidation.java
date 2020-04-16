package com.degiro.assessment.validation;

/**
 * @author Sudhakaran Vasudevan
 * 
 *         This class is to validate input data
 *
 */
public class InputDataValidation {

	/**
	 * @param flutPile
	 * @return true/false
	 * 
	 *         This method will validate input flutPile with different conditions
	 *         and return the result
	 */
	public boolean isValidPileInput(String[] flutPile) {
		return (isFlutPileSizeValid(flutPile) && isDataNotEmpty(flutPile) && isNumberOfFlutsInPileCorrect(flutPile));
	}

	/**
	 * @param flutPile
	 * @return true/false 
	 * This method check weather given flutPile has empty values
	 */
	public boolean isDataNotEmpty(String flutPile[]) {
		boolean isNotEmpty = true;

		for (String flut : flutPile) {
			if (flut.isEmpty()) {
				isNotEmpty = false;
				break;
			}
		}

		return isNotEmpty;
	}

	/**
	 * @param flutPile
	 * @return true/flase 
	 * this method will check whether the given flutPile size is
	 *         valid
	 */
	public boolean isFlutPileSizeValid(String[] flutPile) {
		return flutPile.length > 1;
	}

	/**
	 * @param flutPile
	 * @return true/false 
	 * This method check whether give flutpile size is matches
	 *         with actual value
	 */
	public boolean isNumberOfFlutsInPileCorrect(String[] flutPile) {
		int expectedSize = Integer.parseInt(flutPile[0]);
		int actualSize = flutPile.length - 1;
		return expectedSize == actualSize;
	}

}
