package day1practice;

public class Program_continue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("Hello");		
//		for (int i= 1; i<=10; i++)
//		{
//			
//			if (i==5)
//				continue; // to skip the itreation
//			System.out.print(i+ " ");
//		}
//		System.out.print("\nBye");
		
		int num = 0;
		System.out.println("Hello");		
		while (num<10)
		{
			
			num ++;
			if (num==5)
				continue; // to skip the itreation
			System.out.print(num+ " ");
		}
		System.out.print("\nBye");
	}

}
