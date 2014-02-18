package leetCode;

public class FindPeek {
	public int findP(int[] A) {
		if (A == null | A.length < 3) {
			return -1;
		}
		
		int start = 0;
		int end = A.length - 1;
		int mid;
		
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (A[mid - 1] < A[mid] && A[mid] > A[mid + 1]) {
				return mid;
			} else if (A[mid - 1] < A[mid] && A[mid] < A[mid + 1]) {
				start = mid;
			} else {
				end = mid;
			}
		}
		
		return -1;
	}
}
