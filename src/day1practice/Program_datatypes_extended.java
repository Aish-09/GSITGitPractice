package day1practice;

public class Program_datatypes_extended {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = 1234567898;
		System.out.println("int takes 4 bytes = " + num);
		
		boolean result = false;
		System.out.println("Boolean takes 1 byte : "+result);
		
		byte data = -128; //maximum value taken is 127 (ie. range : -128 to 127)
		System.out.println("byte takes 1 byte : "+data);
		
		char alpha = 'A'; //any number, special characters but only single value
		System.out.println("char takes 2 byte = "+alpha);
		
		short answer = -5845; //Minimum Value: Short.MIN_VALUE (returns -32768)Maximum Value: Short.MAX_VALUE (returns 32767)
		System.out.println("short takes 2 bytes : " + answer);
		
		float values = 12.6589686F; //used for decimal values, F is must appended to values with maximum 7  floating  points. (total digits)
		System.out.println("Float takes 4 bytes : " + values);
		
		float values2 = -153456.654556F;
		System.out.println("Float takes 4 bytes : " + values2);
		
		long phone = 564132461456456789L;
		System.out.println("Long takes 8 bytes : "+ phone);
		
		double pi = 3.14159;
		System.out.println("Double takes 8 bytes : "+ pi);
		
		double gravity = 98798.81;
		System.out.println("Double takes 8 bytes : "+ gravity);


	}

}
