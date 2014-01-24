package ch18Hard;

import java.util.Arrays;

public class ShuffleArray_18_1 {
	
	public static int[] shuffle(int[] input){
		for(int i=0; i<input.length; i++){
			int swap = rand(i,input.length-1);
			//swap input[i] and input[swap]
			int temp = input[swap];
			input[swap] = input[i];
			input[i] = temp;
		}
		return input;
	}
	
	public static int rand(int lower, int higher){
		return lower + (int)(Math.random() * (higher - lower +1));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[10];
		for(int i=0; i<input.length;i++)
			input[i] = i;
		System.out.println(Arrays.toString(shuffle(input)));
	}

}
