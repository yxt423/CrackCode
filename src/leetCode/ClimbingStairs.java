package leetCode;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        
        int last = 2, lastlast = 1;
        int cur = 0;
        for (int i = 3; i <= n; i++) {
            cur = lastlast + last;
            lastlast = last;
            last = cur;
        }
        return cur;
    }
}