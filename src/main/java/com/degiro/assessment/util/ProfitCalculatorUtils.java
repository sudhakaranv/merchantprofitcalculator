package com.degiro.assessment.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sudhakaran Vasudevan
 * 
 * Custom utility class to assist Profit calculation
 *
 */
public class ProfitCalculatorUtils {
	
	
	/**
	 * @param noOfFlutsToBuy1
	 * @param noOfFlutsToBuy2
	 * @return noOfFlutsToBuy
	 * 
	 * This method is to add elements of two lists and return single list with added values
	 */
	public static List<Integer> addListElements(List<Integer> noOfFlutsToBuy1, List<Integer> noOfFlutsToBuy2)
	{
       List<Integer> noOfFlutsToBuy=new ArrayList<>();
    	
    	for(int a:noOfFlutsToBuy1)
    	{
    		for(int b: noOfFlutsToBuy2)
    		{
    			noOfFlutsToBuy.add(a+b);
    		}
    		
    	}
		return noOfFlutsToBuy;
	}
	

	 /**
	 * @param index
	 * @param avgFlutPrice
	 * @param flutPile
	 * @return true/flase
	 * 
	 * This method is to determine whether the flut is eligible to buy or not
	 */
	public static boolean isBuyableFlut(int index, int avgFlutPrice, String[] flutPile)
	    {
	    	    int flutPriceSum=0;
	    	    int flutCount=0;
	    	    boolean isBuyable=false;
	    	     	 
		    	for(int i=index;i<flutPile.length;i++)
		    	{
		    		flutCount++;
		    		flutPriceSum+=Integer.parseInt(flutPile[i]);
		  
		    		if(flutPriceSum<=(flutCount*avgFlutPrice))
		    		{
		    			isBuyable=true;
		    			break;	 
		    		}
		    
		    	}
		    	
		    	return isBuyable;
		    	
	    }
	    	


}
