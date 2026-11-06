package day1practice;

public class Program_BreakusingWHile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 1;
		System.out.println("Hello");		
		while (num<=10)
		{
			System.out.print(num+ " ");
			if (num==5)
				break;
			num++;
		}
		System.out.print("\nBye");

	}

}
