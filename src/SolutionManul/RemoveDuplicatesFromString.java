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
	
	// no additional buffer, no copy of array
	public static String removeDups2(String string) {
		if (string == null) 
			return null;
		char[] str = string.toCharArray();
		int len = str.length;
		if (len < 2) 
			return string;
		
		int tail = 1;
		for(int i=1; i<len; i++){ // see if i is duplicate with former characters. 
			int j;
			for(j=0; j<tail; j++){
				if(str[i] == str[j])
					break;
			}
			if(j == tail){   // if: no duplicates, str[i] is a new character. 
				str[tail] = str[i]; //tail: the position to be replaced.
				tail++;
			}
		}
		for(;tail<len;tail++)  //put '0/'s at the end of the string
			str[tail] = 0;
		return new String(str);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "Hello World!!";
		System.out.println(removeDups(str));
		String str2 = "abaefbg";
		System.out.println(removeDups2(str2));
	}

}
