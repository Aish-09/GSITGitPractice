package day1practice;

public class ReverseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = 54664;
        int rev = 0;

        while (num > 0) {
            int lastDigit = num % 10;   // 1. Get the last digit
            rev = (rev * 10) + lastDigit; // 2. Shift left and append
            num = num / 10;             // 3. Drop the last digit
        }

        System.out.println("Reversed number = " + rev);

	}

}
