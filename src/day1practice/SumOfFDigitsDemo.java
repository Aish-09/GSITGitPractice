package day1practice;

public class SumOfFDigitsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = 125;
        int sum = 0;

        while (num > 0) {
            int lastDigit = num % 10; // Extract the last digit
            sum = sum + lastDigit;    // Add it to our total
            num = num / 10;           // Remove the last digit
        }

        System.out.println("Sum of digits = " + sum);

	}

}
