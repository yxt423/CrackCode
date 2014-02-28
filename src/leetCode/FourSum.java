package leetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
    public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        
        for (int i = 0; i < num.length - 3; i++) {
            int tar1 = target - num[i];
            for (int j = i + 1; j < num.length - 2; j++) {
                int tar2 = tar1 - num[j];
                int start = j + 1;
                int end = num.length - 1;
                
                while (start < end) {
                    if (num[start] + num[end] == tar2) {
                        ArrayList<Integer> solution = new ArrayList<Integer>();
                        solution.add(num[i]);
                        solution.add(num[j]);
                        solution.add(num[start]);
                        solution.add(num[end]);
                        result.add(solution);
                        start++;
                        end--;
                    } else if (num[start] + num[end] > tar2) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {-3,-2,-1,0,0,1,2,3};
		System.out.println(fourSum(num, 0).toString());
	}
}