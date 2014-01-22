package ch1ArraysAndStrings;

public class stringCompress {
	
	public static String compress(String str){
		int size = countCompress(str);
		if(size > str.length())
			return str;
		
		StringBuffer sb = new StringBuffer();
		char last = str.charAt(0);
		int count = 1;
		for(int i=1; i<str.length(); i++){
			if(str.charAt(i) == last)
				count++;
			else{
				sb.append(last);
				sb.append(String.valueOf(count));
				last = str.charAt(i);
				count = 1;
			}
		}
		sb.append(last);
		sb.append(count); // sb.append(String.valueOf(count)); is also ok. 
		return sb.toString();
	}
	
	public static int countCompress(String str){
		if(str == null || str.isEmpty())
			return 0;
		int size = 0;
		char last = str.charAt(0);
		int count = 1;
		
		for(int i=1; i<str.length(); i++){
			if(str.charAt(i) == last)
				count++;
			else{
				size += 1 + String.valueOf(count).length();
				last = str.charAt(i);
				count = 1;
			}
		}
		size += 1 + String.valueOf(count).length();
		return size;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aabbbccccd";
		System.out.println(compress(str));
	}

}
