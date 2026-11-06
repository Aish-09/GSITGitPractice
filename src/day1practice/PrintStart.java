package day1practice;

public class PrintStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int row = 5;
		int column =3 ;
		
		for (int i = 1; i<= row ; i++)
		{
			for (int j = 1; j<= column ; j++)
			{
				System.out.print("* ");
			}
			System.out.println( );
		}
	}

}
