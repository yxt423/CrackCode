package ch18Hard;

public class Add_18_1 {
	
	public static int add(int a, int b){
		if(b == 0) return a;
		int sum = a^b;			// add without carrying
		int carry = (a&b) << 1;	//carry, but don't add
		return add(sum, carry); //recurse
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(add(912,134));
	}

}
