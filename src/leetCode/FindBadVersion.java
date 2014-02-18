package leetCode;

public class FindBadVersion {
	public static int findBadV(int n) {
		if (n < 2) {
			if (n == 1 && isBadVersion(1)) {
				return 1;
			}
			return -1;
		}
		
		int start = 1;
		int end  = n;
		int mid;
		
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (isBadVersion(mid) == false) {
				start = mid;
			} else {
				end = mid;
			}
		}
		
		if (isBadVersion(start) == true) {
			return start;
		} else if (isBadVersion(end) == true) {
			return end;
		}
		
		return -1;
	}
	
	private static boolean isBadVersion(int i) {
		int badVersion = 3;
		if (i < badVersion) {
			return false;
		} else {
			return true;
		}
	}
	
	public static void main(String[] argv) {
		System.out.println(Integer.toString(findBadV(9)));
	}
}
