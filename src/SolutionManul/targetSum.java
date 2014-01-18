package SolutionManul;

import java.util.Arrays;

//Given an array of integers and a target value, write a function to 
//determine whether the array contains two numbers that add up to the target value.
public class targetSum {
	
	public static int[] func(int[] input, int target){
		Arrays.sort(input);
		int start = 0;
		int end = input.length -1;
		while(start < end){
			int sum = input[start] + input[end];
			if( sum == target){
				int[] result = {start, end};
				return result;
			}
			else if(sum < target)
				start++;
			else
				end--;
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
