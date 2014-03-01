package leetCode;

import java.util.Arrays;

public class JumpGameII {
    public static int jump(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int cur = 0;
        int last = 0;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (i > last) {
                count++;
                last= cur;
            }
            cur = Math.max(cur, A[i] + i);
        }
        
        return count;
    }

    public static void main(String argv[]) {
    	int[] A = {1,2};
    	System.out.print(jump(A));
    }
}