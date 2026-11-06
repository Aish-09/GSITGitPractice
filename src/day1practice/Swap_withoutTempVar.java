package day1practice;

public class Swap_withoutTempVar {
	
	public static void main (String [] agrs) {
		
		int num1 =10;
		int num2 = 20;
		
		num1 = num1+ num2; //30
		num2 = num1 - num2 ; //10
		num1 = num1 - num2 ; //30 - 10 = 20
		
		System.out.println("num 1 = " + num1);
		System.out.println("num 2 = "+ num2);
	}

}
