package SolutionManul;

/*Given an array, describe an algorithm to identify 
 * the subarray with the maximum sum.*/
public class maxSubarray {
	
	public static int maxSubA(int[] input){
		int maxSofar = 0;
		int maxEndingHere = 0;
		for(int i=0; i<input.length;i++){
			maxEndingHere = Math.max(0, maxEndingHere) + input[i];
			maxSofar = Math.max(maxSofar, maxEndingHere);
		}
		return maxSofar;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
