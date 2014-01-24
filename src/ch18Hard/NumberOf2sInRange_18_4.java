package ch18Hard;

public class NumberOf2sInRange_18_4 {
	
	// 1. brute force solution
	public static int numberOf2sInRange(int n){
		int count = 0;
		for(int i=2; i<=n; i++){
			count += numberOf2s(i);
		}
		return count;
	}
	
	public static int numberOf2s(int n){ // It's cleaner to separate out numberOf2s
		int count = 0;
		while(n > 0){
			if(n%10 == 2)
				count++;
			n = n/10;
		}
		return count;
	}
	
	// improved solution: calculate digit by digit
	public static int count2sInRange(int n){
		int count = 0;
		int len = String.valueOf(n).length();
		for(int digit = 0; digit<len; digit++){
			count += count2sInRangeAtDigit(n, digit);
		}
		return count;
	}
	
	public static int count2sInRangeAtDigit(int number, int d){
		int powerOf10 = (int)Math.pow(10, d);
		int nextPowerOf10 = powerOf10 * 10;
		int right = number % powerOf10;
		
		int roundDown = number - number % nextPowerOf10;
		int roundUp = roundDown + nextPowerOf10;
		
		int digit = (number / powerOf10) % 10;
		if(digit < 2)
			return roundDown / 10;
		else if(digit == 2)
			return roundDown / 10 + right + 1;
		else
			return roundUp / 10;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
