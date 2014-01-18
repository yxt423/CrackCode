package SolutionManul;

//binary search

public class findValueFromSortedArray {
	
	public static int findValue(int[] input, int value){
		return findValue2( input, value, 0, input.length-1);
	}
	
	//recursion
	public static int findValue(int[] input, int value, int min, int max){
		int mid = (min + max)/2;
		if(max < min) // check for error first, otherwise may "out of range"
			return -1;
		else if(input[mid] == value)
			return mid;
		else if(input[mid] > value)
			return findValue(input, value, min, mid-1);
		else
			return findValue(input, value, mid+1, max);
	}
	
	// no recursion
	public static int findValue2(int[] input, int value, int min, int max){
		while(min<=max){
			int mid = (min+max)/2;
			if(input[mid] == value)
				return mid;
			else if(input[mid] > value)
				max = mid -1;
			else
				min = mid +1;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,2,3,4,5,6,7,8,9};
		System.out.println(findValue(input, 3));
	}

}
