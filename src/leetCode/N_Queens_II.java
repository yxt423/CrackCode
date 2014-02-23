package leetCode;

import java.util.ArrayList;

public class N_Queens_II {
    private int result = 0;
    
    public int totalNQueens(int n) {
        ArrayList<Integer> queenPosition = new ArrayList<Integer>();
        helper(queenPosition, n);
        return result;
    }
    
    private void helper(ArrayList<Integer> queenPosition, int n) {
        
        if (queenPosition.size() == n) {
            result++;
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (isValid(i, queenPosition)) {
                queenPosition.add(i);
                helper(queenPosition, n);
                queenPosition.remove(queenPosition.size() - 1);
            }
        }
    }
    
    private boolean isValid(int p, ArrayList<Integer> queenPosition) {
        for (int i = 0; i < queenPosition.size(); i++) {
            int val = queenPosition.get(i);
            if (val == p || Math.abs(i - queenPosition.size()) == Math.abs(queenPosition.get(i) - p)) {
                return false;
            }
        }
        return true;
    }
}