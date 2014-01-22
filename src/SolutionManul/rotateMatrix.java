package SolutionManul;

import java.util.Arrays;

/*Write a function that rotates an two dimensional square 
 * matrix 90 degrees using O(1) additional memory.*/
public class rotateMatrix {
	
	public static void rotateM(int input[][]) {
		int n = input.length;
		if(n<=1)
			return;
		
		for(int i=0; i<n/2; i++){
			for(int j=i; j<n-1-i; j++){
				int temp = input[i][j];
				input[i][j] = input[j][n-1-i];
				input[j][n-1-i] = input[n-1-i][n-1-j];
				input[n-1-i][n-1-j] = input[n-1-j][i];
				input[n-1-j][i] = temp;
			}
			
		}
	}

	public static void main(String[] args) {
		int[][] M = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		rotateM(M);
		//System.out.println(Arrays.deepToString(M));
		for(int i=0; i<M[0].length;i++){
			System.out.println(Arrays.toString(M[i]));
		}
	}

}
