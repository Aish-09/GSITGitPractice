package Practice_Upgrade;

public class Pgm_Equals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		In Java, the equals() method compares 
//		the actual content or logical state of two objects, whereas the == operator compares memory addresses (reference equality)
		
		String str1 = "Hello";
		String str2= "Hello";
		String str3 = new String("Hello");
		String str4 = new String("Hello");
		
//		if (str1.equals(str3))
//			System.out.println("One");
//		else if (str1==str2)
//			System.out.println("two");
//		else if (str1==str3)
//		System.out.println("Three");
//		else
//			System.out.println("Null");

		if (str1.equals(str3))
		    System.out.println("One");
		if (str1==str2)
		    System.out.println("two");
		if (str1==str3)
		    System.out.println("Three");
			

	}

}
