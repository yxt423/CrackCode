package leetCode;

import java.util.Arrays;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int plus = 1;
        int index = digits.length - 1;
        
        while (plus != 0 && index >= 0) {
            int digit = digits[index] + plus;
            plus = digit / 10;
            digits[index] = digit % 10;
            index--;
        }
        
        if (plus == 1) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for (int i = 1; i < newDigits.length; i++) {
                newDigits[i] = digits[i - 1];
            }
            return newDigits;
        } else {
            return digits;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {0};
		System.out.println(Arrays.toString(plusOne(num)));
	}
}

