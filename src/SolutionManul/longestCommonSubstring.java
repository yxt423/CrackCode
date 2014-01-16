package SolutionManul;

public class longestCommonSubstring {
	
	public static int func(String str1, String str2){
		int n = str1.length();
		int m = str2.length();
		
		if(n == 0 || m == 0)
			return 0;
		
		int maxLength = 0;
		int[][] memorized = new int[n][m];
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(str1.charAt(i) == str2.charAt(j)){
					if(i == 0 || i == 0)
						memorized[i][j] = 1;
					else
						memorized[i][j] = memorized[i-1][j-1];
					if(memorized[i][j] > maxLength)
						maxLength = memorized[i][j];
				}
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
