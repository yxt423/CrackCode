package SolutionManul;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

public class getAnagrams {
	
	private static HashMap<String, List<String>> map = new HashMap<String, List<String>>();
	
	public static void preCompute(List<String> englishDictionary){
		for(String word: englishDictionary){
			char[] letters = word.toCharArray();
			Arrays.sort(letters);
			String sortedStr = String.valueOf(letters);
			if(map.get(sortedStr) != null)
				map.get(sortedStr).add(word);
			else{
				List<String> words = new ArrayList<String>();
				words.add(word);
				map.put(sortedStr, words);
			}
		}
	}
	
	public static List<String> getAnagram(String input){
		char[] letters = input.toCharArray();
		Arrays.sort(letters);
		String sortedStr = String.valueOf(letters);
		return map.get(sortedStr);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
