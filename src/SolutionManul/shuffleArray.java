package SolutionManul;

import java.util.Arrays;

public class shuffleArray {
	
	public static int[] shuffle(int[] input){
		for(int i=0; i< input.length; i++){
			int swap = i + (int)(Math.random()*(input.length-i)); 
			int temp = input[swap];
			input[swap] = input[i];
			input[i] = temp;
		}
		return input;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,2,3,4,5,6,7};
		System.out.println(Arrays.toString(shuffle(input)));  //Arrays.toString(int[])  print out an array just like an array
	}

}
