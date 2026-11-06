package day1practice;

public class Program_Ifeles1 {

	public static void main (String [] agrs) {
		
		int age = 15;
		
		if (age >= 18) {
			System.out.println("You can vote");
		
		}
		else
		{
			System.out.println("You cannot vote");
		}
		
		main1(agrs);}
	
		// without else block , similarly multiple if is also possible
	
		
		public static void main1 (String [] agrs) {
			
			System.out.println("----------------------------------------vxx`");
			System.out.println("Second main block");
			
			int age = 18;
			
			if (age >= 18) {
				System.out.println("You can vote");
			
			}
			if (age==18) {
				System.out.println("Congratulation on your first vote");
			}
		
		
	}
}
