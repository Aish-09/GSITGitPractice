package Practice_Upgrade;

interface IUserA
{
	int num = 10;
	void hello();
	default void show()
	{
		System.out.println("Show");
	}
}

interface IUserB
{
	int num = 20;
	void hello();
	void bye();
	default int show()
	{
		return 10;
	}
}


//Feature	                  extends	                        implements
//Primary_Purpose	          Inheritance 	                     Abstraction 
//                          (reusing existing code).      (enforcing a specific behavior).


class IUserC implements IUserA, IUserB
{
	public void hello()
	{
		System.out.println("Hello" + num);
	}
	public void bye()
	{
		System.out.println("Bye");
	}
}
public class Pgrm_MultipleInheritanceusingInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
