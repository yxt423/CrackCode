package ch18Hard;

public class MaxSubMatrix_18_12 {
	
	public static int maxSubMatrix(int[][] M){
		int rowCount = M.length;
		int colCount = M.length;
		
		int[] partialSum = new int[colCount];
		int maxSum = 0;
		for(int rowStart = 0; rowStart < rowCount; rowStart++){
			clearArray(partialSum);
			for(int rowEnd = rowStart; rowEnd < rowCount; rowEnd++){
				for(int i=0; i<colCount; i++){
					partialSum[i] += M[rowEnd][i];
				}
				maxSum = Math.max(maxSum, maxSubArray(partialSum));
			}
		}
		return maxSum;
	}
	
	public static int maxSubArray(int[] input){
		int max = 0;
		int runningSum = 0;
		for(int i=0; i<input.length; i++){
			runningSum = Math.max(0, runningSum + input[i]);
			max = Math.max(max, runningSum);
		}
		return max;
	}
	
	public static void clearArray(int[] input){
		for(int i=0; i<input.length; i++){
			input[i] = 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
