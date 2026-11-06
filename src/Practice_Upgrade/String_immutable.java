package Practice_Upgrade;


public class String_immutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="Hello";

		System.out.println(str);

		str.concat(" Bye");

		System.out.println(str);
		
		String str1 = "Today is Thursday";
		
		System.out.println("\n");
		
		System.out.println("Initalzing text:" + str1);
		
		
		System.out.println("Char at :" + str1.charAt(2));
		System.out.println("Index of : "+str1.indexOf('T'));
		System.out.println("Length of string : "+str1.length());
		System.out.println("Replace : "+str1.replace("Thursday", "His Birthday"));
		System.out.println("Substring : "+str1.substring(0,5));
		System.out.println("Uppercase : "+str1.toUpperCase());
		System.out.println("Lowercase :"+str1.toLowerCase());
		System.out.println("EmptyString: "+str1.isEmpty());
		
		System.out.println("\n");
		String str2 = "   Hello   All  ";
		System.out.println(str2.trim()); //Trims white space
		
		System.out.println("\n");
		String str3 = "I am Sad";
		String[]words = str3.split(" ");
		System.out.println(words[2]); //Prints the indexed value
		
		String str4 = "Hello I am good";
		System.out.println("Reverse data : "+str4.);
	}

}
