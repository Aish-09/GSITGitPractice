package Practice_Upgrade;

public class WrapperClasses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		A wrapper class in Java is a predefined class in the java.lang package that encapsulates (wraps) 
//		a primitive data type within an object. Java provides a corresponding wrapper class for each of 
//		its eight primitive data types, allowing them to be treated as standard Java objects
//		---------------------------------------------------------------------------------------------------
//		Primitive Type	Wrapper Class
//		byte	Byte
//		short	Short
//		int	Integer
//		long	Long
//		float	Float
//		double	Double
//		char	Character
//		boolean	Boolean
		
//
//Why Are Wrapper Classes Needed?
//
//1. Java Collections Framework: Collections 
//like ArrayList, HashMap, or HashSet can only store objects, not primitive data. For example, ArrayList<int> will throw 
//a compilation error, but ArrayList<Integer> works perfectly
//
//1. Utility Methods: They offer powerful helper methods to parse strings, compare values, or convert between number bases 
//(e.g., Integer.parseInt("123")).
//2. Handling null Values: Primitive types cannot hold a null value, whereas wrapper classes can represent 
//the absence of a value.
//3. Object-Oriented Features: They enable primitives to participate in processes requiring objects, 
//such as serialization and multithreading synchronization.

		int num = 10;
		Integer data = 10;
		
//		int converted to Integer --> Autoboxing primitive --> Wrapper class

		int num2 = data;
		
//		Integer conver to Int ---> Unboxing
		
		char alpha = 'A';
		if (Character.isDigit(alpha))
		{
			System.out.println("Digit ");
		}else
		{
			System.out.println("Not a Digit");
		}
		
		String str = "154";
		int num1 = Integer.parseInt(str);
		System.out.println("num1 : " + num1);
		num1++;
		System.out.println("num1 : "+ num1);

	}

}
