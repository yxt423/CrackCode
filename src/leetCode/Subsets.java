package leetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(result, list, S, 0);
        return result;
    }
    
    private static void helper(ArrayList<ArrayList<Integer>> result, 
                        ArrayList<Integer> list, int[] s, int pos) {
        
    	result.add(new ArrayList<Integer>(list));
        
        for (int i = pos; i < s.length; i++) {
            list.add(s[i]);
            helper(result, list, s, i + 1);
            list.remove(list.size() - 1);
        }
    }
    
    public static void main(String[] argv) {
    	int[] s = {1,2,3};
    	System.out.println(subsets(s).toString());
    }
}