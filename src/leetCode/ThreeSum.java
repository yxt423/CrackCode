package leetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num == null) {
            return result;
        }
        
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }
            
            int target = 0 - num[i];
            int start = i + 1;
            int end = num.length - 1;
            while (start < end) {
                if (num[start] + num[end] == target) {
                    ArrayList<Integer> solution = new ArrayList<Integer>();
                    solution.add(num[i]);
                    solution.add(num[start]);
                    solution.add(num[end]);
                    if (!result.contains(solution)) {
                        result.add(solution);
                    }
                    start++;
                    end--;
                } else if (num[start] + num[end] > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return result;
    }
}
