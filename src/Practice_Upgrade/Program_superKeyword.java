package Practice_Upgrade;

class GrandParent{
	String Garden;
}

class Parent1 {
	String House;
	Parent1( String House)
	{
		this.House = House;
		System.out.println("Parent1 Called");
	}
}

class ParentChild extends Parent1
{
	String Car;
	ParentChild( String House)
	{
		super(House);
		System.out.println("Child called");
	}
	void print()
	{
		System.out.println(super.House);
	}
}

public class Program_superKeyword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ParentChild pc =  new ParentChild("Home");
		System.out.println(pc);

	}

}
