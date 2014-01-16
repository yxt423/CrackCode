package SolutionManul;

public class WordOrderReversal {
	
	public static char[] reversal(String string){
		char[] characters = string.toCharArray();
		
		characters = reverse(0, string.length()-1, characters);
		int lastindex = 0;
		int currentindex = 0;
		for(int i=0; i<string.length(); i++){
			if(characters[i] == ' '){
				currentindex = i-1;
				if( i-lastindex>1)
					reverse(lastindex, currentindex, characters);
				lastindex = i+1;
			}
		}
		if(lastindex < string.length()-1)
			characters = reverse(lastindex,string.length()-1, characters);
		return characters;
	}
	
	public static char[] reverse(int left, int right, char[] characters){
		for(;left<right;left++,right--){
			char temp = characters[left];
			characters[left] = characters[right];
			characters[right] = temp;
		}
		return characters;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hello World! Have a nice day.";
		System.out.println(reversal(str));
	}

}
