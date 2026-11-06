package Practice_Upgrade;

interface ITest
{
	final static public int num = 10;
	void hello(); //abstract public by default
	default void printData()
	{
		System.out.println("Gello All");
	}
	static void showData()
	{
		System.out.println("Show All");
	}
}

class Test implements ITest
{
	public void hello()
	{
		System.out.println("Hello");
	}
	public void bye()
	{
		System.out.println("Bye");
	}
}
public class Program_Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
