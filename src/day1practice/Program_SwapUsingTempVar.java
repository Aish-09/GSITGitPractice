package day1practice;

public class Program_SwapUsingTempVar {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num1 = 10;
		int num2 = 20 ;
		
		int temp = num1;
		num1 = num2;
		num2 = temp;
		
		System.out.println("Value of num1 = "+ num1);
		System.out.println("Value of num2 = "+ num2);
		
	}

}
