package leetCode;

public class RemoveDuplicatesfromSortedArray {
    public static int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        } else if (A.length == 1) {
            return 1;
        }
        
        int left = 0;
        int right = 1;
        for (; right < A.length; right++) {
            if (A[left] != A[right]) {
                left++;
                if (right != left) {
                    A[left] = A[right];
                }
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