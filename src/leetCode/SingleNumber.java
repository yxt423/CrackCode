package leetCode;

public class SingleNumber {
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0){
            return -1;
        }
        
        int sum = 0;
        for (int i = 0; i < A.length; i++){
            sum = sum ^ A[i];
        }
        return sum;
    }
}