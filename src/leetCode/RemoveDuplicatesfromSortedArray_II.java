package leetCode;

public class RemoveDuplicatesfromSortedArray_II {
    public static int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        } else if (A.length < 3) {
            return A.length;
        }
        
        int cur = 1;
        for (int i = 2; i < A.length; i++) {
            if (!(A[cur] == A[i] && A[cur - 1] == A[i])) {
                A[++cur] = A[i];
            }
        }
        return cur + 1;
    }

    public static void main(String argv[]) {
    	int[] A = {1,1,1,2,3};
    	int n = removeDuplicates(A);
    	for (int i = 0; i < n; i++) {
        	System.out.print(A[i] + " ");
    	}
    }
}