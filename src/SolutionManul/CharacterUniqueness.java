package SolutionManul;

import java.util.HashSet;

public class CharacterUniqueness {
	
	public static boolean uniqueness(String string){
		if(string.isEmpty())
			return false;
		char[] characters = string.toCharArray();
		HashSet <Character> map = new HashSet<Character>();
		for(int i=0; i<string.length(); i++){
			if(map.contains(characters[i]))
				return false;
			else
				map.add(characters[i]);
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hello World!";
		String str2 = "Helo Wrd";
		if(uniqueness(str2))
			System.out.println("yes!");
		else
			System.out.println("no!");
	}

}
