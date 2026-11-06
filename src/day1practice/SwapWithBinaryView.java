package day1practice;

public class SwapWithBinaryView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 10; // Binary: 01010
		int num2 = 20; // Binary: 10100

		// Step 1: XOR both values and store the combined bitmask in num1
		// 01010 (10) ^ 10100 (20) = 11110 (30)
		num1 = num1 ^ num2; // num1 is now 30

		// Step 2: XOR the combination with num2 to cancel out num2 and extract original num1
		// 11110 (30) ^ 10100 (20) = 01010 (10)
		num2 = num1 ^ num2; // num2 is now 10 (swapped!)

		// Step 3: XOR the combination with new num2 to cancel out original num1 and extract original num2
		// 11110 (30) ^ 01010 (10) = 10100 (20)
		num1 = num1 ^ num2; // num1 is now 20 (swapped!)

		System.out.println("num1:" + num1); // prints 20
		System.out.println("num2:" + num2); // prints 10
		
		// Explicitly invoke main1
				main1(args);
	}
	
	public static void main1 (String[] args) {
		// TODO Auto-generated method stub
		int num1 = 6; // Binary: 110 (4 + 2)
		int num2 = 3; // Binary: 011 (2 + 1)

		// Step 1: Combine both values into num1 using XOR
		// 110 (6) ^ 011 (3) = 101 (5)
		num1 = num1 ^ num2; // num1 is now 5

		// Step 2: Cancel out num2 to extract original num1 into num2
		// 101 (5) ^ 011 (3) = 110 (6)
		num2 = num1 ^ num2; // num2 is now 6 (swapped!)

		// Step 3: Cancel out original num1 to extract original num2 into num1
		// 101 (5) ^ 110 (6) = 011 (3)
		num1 = num1 ^ num2; // num1 is now 3 (swapped!)

		System.out.println("num1:" + num1); // prints 3
		System.out.println("num2:" + num2); // prints 6
	}
}

