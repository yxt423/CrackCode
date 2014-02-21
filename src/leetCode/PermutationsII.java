package leetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationsII {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        if (num == null || num.length == 0) {
            return result;
        }
        
        Arrays.sort(num);
        boolean[] visited = new boolean[num.length];
        permuteHelper(result, list, num, visited);
        
        return result;
    }
    
    private void permuteHelper(ArrayList<ArrayList<Integer>> result, 
                               ArrayList<Integer> list, int[] num, boolean[] visited){
        
        if (list.size() == num.length){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < num.length; i++){
            if (visited[i] == true || 
               (i != 0 && num[i] == num[i - 1] && visited[i - 1] == false)) {
                continue;
            }
            list.add(num[i]);
            visited[i] = true;
            permuteHelper(result, list, num, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}