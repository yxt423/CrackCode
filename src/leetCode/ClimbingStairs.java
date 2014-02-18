package leetCode;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        
        if (n == 1) {
            return 1;
        }
        
        if (n == 2) {
            return 2;
        }
        
        int prevv = 1;
        int prev = 2;
        int cur;
        for (int i = 3; i <= n; i++) {
            cur = prev + prevv;
            if (i == n) {
                return cur;
            }
            prevv = prev;
            prev = cur;
        }
        return 0;
    }
}