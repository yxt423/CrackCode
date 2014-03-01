package leetCode;

public class BestTimetoBuyandSellStockIII {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        
        int[] rel = new int[prices.length];
        rel[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            rel[i] = prices[i] - prices[i - 1];
        }
        
        int[] left = new int[prices.length + 1];
        int[] right = new int[prices.length + 1];
        
        int max = 0;
        int tempsum = 0;
        for (int i = 0; i < prices.length; i++) {
            tempsum = Math.max(0, tempsum + rel[i]);
            max = Math.max(max, tempsum);
            left[i + 1] = max;
        }
        max = 0;
        tempsum = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            tempsum = Math.max(0, tempsum + rel[i]);
            max = Math.max(max, tempsum);
            right[i + 1] = max;
        }
        
        max = 0;
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max, left[i] + right[i + 1]);
        }
        
        return max;
    }
    
    public static void main(String argv[]) {
    	int[] A = {1,2};
    	System.out.print(maxProfit(A));
    }
}