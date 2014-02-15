package leetCode;

public class MaximumSubarray {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int max = 0;
        int tempsum = 0;
        for (int i = 0; i < A.length; i++) {
            tempsum = Math.max(0, tempsum + A[i]);
            max = Math.max(max, tempsum);
        }
        
        if (max > 0) {
            return max;
        } else {
            max = A[0];
            for (int i = 1; i < A.length; i++) {
                max = Math.max(A[i], max);
            }
            return max;
        }
    }
}