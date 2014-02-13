package leetCode;

public class SingleNumber_II {
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int result = 0;
        
        for (int i = 0; i < 32; i++){
            int count = 0;
            for (int j = 0; j < A.length; j++){
                count += (A[j] >> i) & 1; // error: forget to add "& 1"
            }
            result |= (count % 3) << i;
        }
        return result;
        
    }
}