package SolutionManul;

public class findKSmallest {
	
	public static int FindK(int[] input, int k){
		if(k>input.length || k<1)
			return -1;
		return findK(input, 0, input.length-1, k-1);
	}
	
	public static int findK(int[] input, int min, int max, int k){
		int pivotIndex = partition(input, min, max);
		if(pivotIndex == k)
			return input[k];
		else if(pivotIndex > k)
			return findK(input, min, pivotIndex-1, k);
		else
			return findK(input, pivotIndex +1, max, k);
	}
	
	public static int partition(int[] input, int min, int max){
		int pivot = input[max];
		int left = min;
		int right = max-1;
		while(left<right){
			while(input[left] < pivot)
				left++;
			while(input[right] > pivot && right > min)  // here should be right > min, not right >= min, 
				right--;
			if(left < right)
				swap(input, left, right);
		}
		swap(input, left, max);
		return left;
	}
	
	public static void swap(int[] input, int left, int right){
		int temp = input[left];
		input[left] = input[right];
		input[right] = temp;
	}

	public static void main(String[] args) {
		int[] input = {3,6,2,5,4,7,9,8,1,0};
		System.out.println(FindK(input,6));
	}

}
