package Practice_Upgrade;

public class Program_stringBuffer {
	
//	The StringBuffer class in Java represents a mutable sequence of characters. 
//	Unlike the standard String class—which is immutable and creates a new object 
//	every time it is modified—StringBuffer allows you to change, append, insert, 
//	or delete content inside the same object

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringBuffer sf = new StringBuffer("Hello");
		sf.append("World");
		System.out.println(sf.reverse());

	}

}
