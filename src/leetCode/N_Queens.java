package leetCode;

import java.util.ArrayList;

public class N_Queens {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<String[]>();
        ArrayList<Integer> queenPosition = new ArrayList<Integer>();
        helper(result, queenPosition, n);
        return result;
    }
    
    private void helper(ArrayList<String[]> result, ArrayList<Integer> queenPosition, int n) {
        
        if (queenPosition.size() == n) {
            result.add(drawSolution(queenPosition, n));
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (isValid(i, queenPosition)) {
                queenPosition.add(i);
                helper(result, queenPosition, n);
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
    
    private String[] drawSolution(ArrayList<Integer> queenPosition, int n) {
        String[] solution = new String[n];
        for (int i = 0; i < n; i++) {
            solution[i] = drawLine(queenPosition.get(i), n);
        }
        return solution;
    }
    
    private String drawLine(int pos, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == pos) {
                sb.append('Q');
            } else {
                sb.append('.');
            }
        }
        return sb.toString();
    }
}