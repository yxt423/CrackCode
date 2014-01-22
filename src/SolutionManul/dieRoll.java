package SolutionManul;

public class dieRoll {
	
	public static int dieroll(){
		int result = 0;
		while(result < 1 || result > 6){
			result = 0;
			if(coinFlip() == 1)
				result |= 1;
			if(coinFlip() == 1)
				result |= 2;
			if(coinFlip() == 1)
				result |= 4;
		}
		return result;
	}
	
	private static int coinFlip() {
		return (int)(Math.random()*2);
	}
	
	public static void main(String[] args) {
		System.out.println(dieroll());
	}

}
