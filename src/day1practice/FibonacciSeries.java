package day1practice;

public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int terms = 10; // Number of Fibonacci numbers to print
        int n1 = 0;
        int n2 = 1;

        System.out.print("Fibonacci Series: " + n1 + " " + n2);

        // Loop begins from 2 because the first two numbers (0 and 1) are already printed
        for (int i = 2; i < terms; i++) {
            int n3 = n1 + n2;
            System.out.print(" " + n3);

            // Shift variables forward for the next iteration
            n1 = n2;
            n2 = n3;
        }
        System.out.println();

	}

}
