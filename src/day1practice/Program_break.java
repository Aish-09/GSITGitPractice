package day1practice;

public class Program_break {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello");		
		for (int i= 1; i<=10; i++)
		{
			System.out.print(i+ " ");
			if (i==5)
				break;
		}
		System.out.print("\nBye");
	}

}
