package Practice_Upgrade;

abstract class Parent
{
	String House;

	static void print() { //Compile time or static polymorphishm
		// TODO Auto-generated method stub
		
		System.out.println("parent");
		
	}
}

class Child extends Parent
{
	String Car;

	static void print() {
		// TODO Auto-generated method stub
		
		System.out.println("Child");
		
	}
}

public class Pgrm_PloyMorphism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Parent p = new Parent();
		
		Parent c = new Child(); //FASTER
		c.print(); //Dynamic Overriding  //When static used instead of public the overridding is not happening
		
//		Dynamic Method Overriding (also known as Runtime Polymorphism or Dynamic Method Dispatch) is the mechanism by which a call to 
//		an overridden method is resolved at runtime rather than at compile time.
//		When a parent class reference variable points to a child class object, Java uses the actual object type at runtime to determine 
//		which version of the method to execute, ignoring the type of the reference variable
		Child c2 = new Child(); //Slower
//		c2.print(); //Overridding

	}

}
