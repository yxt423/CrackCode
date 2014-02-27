package leetCode;

import java.util.Arrays;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] num, int target) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(num);
        
        for (int i = 0; i < num.length; i++) {
            int tar = target - num[i];
            int start = i + 1;
            int end = num.length - 1;
            
            while (start < end) {
                int tempSum = num[i] + num[start] + num[end];
                if (result == Integer.MAX_VALUE || Math.abs(tempSum - tar) < Math.abs(result - tar)) {
                    result = tempSum;
                }
                if (tempSum >= tar) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return result;
    }
    
    public static void main(String[] argv) {
    	int[] num = {1,1,-1,-1,3};
    	System.out.println(Integer.toString(threeSumClosest(num, -1)));
    }
}