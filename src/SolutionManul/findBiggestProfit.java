package SolutionManul;

/*Given an array of integers, where each element represents the
 *  stock price on consecutive days. Write a function to find 
 *  the maximum profit if we're allowed to buy exactly once and
 *   sell exactly once over the time period.
 *   */
public class findBiggestProfit {
	
	public static int findProfit(int[] days){
		int minPrice = days[0];
		int maxProfit = 0;
		for(int i=1; i<days.length;i++){
			if(minPrice > days[i])
				minPrice = days[i];
			int currentProfit = days[i] - minPrice;
			if(currentProfit > maxProfit)
				maxProfit = currentProfit;
		}
		return maxProfit;
	}
}
