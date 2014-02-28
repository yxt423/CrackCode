package leetCode;

public class MedianofTwoSortedArrays {
    public static double findMedianSortedArrays(int A[], int B[]) {
        int len = A.length + B.length;
        if (len % 2 == 0) {
            return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2;
        } else {
            return findKth(A, 0, B, 0, len / 2 + 1);
        }
    }
    
    public static double findKth(int A[], int indexa, int B[], int indexb, int k) {
        if (indexa >= A.length) {
            return B[indexb + k - 1];
        }
        if (indexb >= B.length) {
            return A[indexa + k - 1];
        }
        if (k == 1) {
            return Math.min(A[indexa], B[indexb]);
        }
        

        int valueA = indexa + k / 2 - 1 < A.length ? A[indexa + k / 2 - 1] : Integer.MAX_VALUE;
        int valueB = indexb + k / 2 - 1 < B.length ? B[indexb + k / 2 - 1] : Integer.MAX_VALUE;
        if (valueA < valueB) {
            return findKth(A, indexa + k / 2, B, indexb, k - k / 2);
        } else {
            return findKth(A, indexa, B, indexb + k / 2, k - k / 2);
        }
    }
    
    public static void main(String[] argv) {
    	int[] A = {1};
    	int[] B = {2,3,4,5,6};
    	System.out.println(findMedianSortedArrays(A, B));
    }
}