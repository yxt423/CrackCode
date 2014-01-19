package SolutionManul;

public class QuickSort {
	
	public static void quicksort(int[] input){
		quicksort(input,0,input.length-1);
	}
	
	public static void quicksort(int[] input, int left, int right){
		if(left >= right)
			return;
		else{
			int mid = partition(input, left, right);
			quicksort(input, left, mid-1);
			quicksort(input, mid+1, right);
		}
	}
	
	public static int partition(int[] input, int left, int right){
		int pivot = input[right];
		int leftp = left - 1;
		int rightp = right;
		while(leftp < rightp){
			while(input[++leftp] < pivot)
				;
			while(input[--rightp] > pivot && rightp > left)
				;
			if(leftp < rightp)
				swap(input, leftp, rightp);
		}
		swap(input,leftp,right);
		return leftp;
	}
	
	public static void swap(int[] input, int one, int two){
		int temp = input[one];
		input[one] = input[two];
		input[two] = temp;
	}

	public static void main(String[] args) {
		int[] input = {3,6,2,5,4,7,9,8,1,0};
		quicksort(input);
		for(int i=0; i< input.length; i++)
			System.out.print(input[i] + " ");
	}

}
