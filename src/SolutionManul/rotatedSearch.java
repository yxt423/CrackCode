package SolutionManul;

//Given a sorted array of integers that has been rotated, 
//find a particular value in the array without finding the pivot.
public class rotatedSearch {
	
	public static int func(int[] values, int min, int max, int x) {
		if (values[min] == x) 
			return min;
		else if (values[max] == x)
			return max;
		else if(max-min==1) 
			return -1;
		
		int mid=(min+max)/2;
		
		if (values[min] <= values[mid]) {
			if (x <= values[mid] && x >= values[min])
				return func(values, min, mid, x);
			else
				return func(values, mid, max, x);
		}
		else {
			if (x >= values[mid] && x <= values[max]) 
				return func(values, mid, max, x);
			else
				return func(values, min, mid, x);
		}
	}
	
	// slight modification
	public static int func2(int[] values, int min, int max, int x) {
		if (values[min] == x) 
			return min;
		else if (values[max] == x)
			return max;
		else if(max-min <= 1) 
			return -1;

		int mid=(min+max)/2;
		if (values[min] < values[mid]) {
			if (x <= values[mid] && x > values[min])
				return func(values, min+1, mid, x);
			else
				return func(values, mid, max-1, x);
		}
		else{
			if (x >= values[mid] && x <= values[max]) 
				return func(values, mid, max-1, x);
			else
				return func(values, min+1, mid, x);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {4,5,6,7,8,9,1,2,3};
		System.out.println(func2(input, 0, input.length-1, 1));
	}

}
