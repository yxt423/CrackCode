package leetCode;

public class RemoveDuplicatesfromSortedArray {
    public static int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        } else if (A.length == 1) {
            return 1;
        }
        
        int left = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[left] != A[i]) {
                A[++left] = A[i];
            }
        }
        return left + 1;
    }

    public static void main(String argv[]) {
    	int[] A = {1,1,1,2,3};
    	int n = removeDuplicates(A);
    	for (int i = 0; i < n; i++) {
        	System.out.print(A[i] + " ");
    	}
    }
}