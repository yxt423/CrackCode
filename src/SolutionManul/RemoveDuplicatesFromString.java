package SolutionManul;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesFromString {
	
	public static String removeDups(String string){
		char[] characters = string.toCharArray();
		Set <Character> charSet = new LinkedHashSet<Character>(); 
		for(char c : characters)  // LinkedHashSet: list characters in order with no duplicates.
			charSet.add(c);
		
		StringBuilder sb = new StringBuilder();
		for(Character c : charSet)
			sb.append(c);
		
		return sb.toString();  // don't forget to turn it back to string.
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "Hello World!!";
		System.out.println(removeDups(str));
	}

}
