package leetCode;
public class SearchinRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return false;
        }
        
        int start = 0;
        int end = A.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return true;
            }
            if (A[mid] > A[start]) {  // increasing period
                if (A[mid] > target && A[start] <= target) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (A[mid] < A[start]) { // disorder period
                if (A[mid] < target && A[end] >= target) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {  //A[start] == A[mid], skip duplicate one
                start++;
            }
        }
        
        if (A[start] == target || A[end] == target) {
            return true;
        } else {
            return false;
        }
    }
}