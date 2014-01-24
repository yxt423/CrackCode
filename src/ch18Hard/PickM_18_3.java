package ch18Hard;

import java.util.Arrays;

public class PickM_18_3 {
	
	public static int[] pickm(int[] input, int m){
		int[] result = new int[m];
		
		for(int i=0; i<m; i++)
			result[i] = input[i];
		
		for(int i=m; i<input.length; i++){
			int k = rand(0, i);
			if(k<m)
				result[k] = input[i];
		}
		return result;
	}
	
	public static int rand(int lower, int higher){
		return lower + (int)(Math.random() * (higher - lower +1));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[10];
		for(int i=0; i<input.length;i++)
			input[i] = i;
		System.out.println(Arrays.toString(input));
		System.out.println(Arrays.toString(pickm(input,3)));
	}

}
