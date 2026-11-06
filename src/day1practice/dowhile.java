package day1practice;

public class dowhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 10; // Start at 10
		
		do {
			System.out.print(num +" ");
			num -=2 ; // Decrement by 2 to get the next reverse even number
		}while(num >= -2); // Continue until -2 is reached and printed
		
	}

}
