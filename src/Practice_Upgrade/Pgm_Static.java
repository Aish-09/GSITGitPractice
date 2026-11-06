package Practice_Upgrade;

class Emp{
	String name;
	int age;
	static String cmpname = "Wipro";
	void bye()
	{
		System.out.println("Bye");
	}
	static void hello()
	{
		System.out.println("Hello");
	}
	Emp(String name, int age){
		this.name = name;
		this.age = age;
	}
}



public class Pgm_Static {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Emp e1 = new Emp("Rajat", 25);
		e1.cmpname = "Qburst";
		System.out.println("Employee 1 : " + e1.name + " " + e1.age + " "+ e1.cmpname);
//		e1.cmpname = "Qburst";
		Emp e2 = new Emp("Praveen", 35);
		System.out.println("Employee 2 : " + e2.name + " " + e2.age + " "+ e2.cmpname);
		Emp e3 = new Emp("JK", 37);
		System.out.println("Employee 3 : " + e3.name + " " + e3.age + " "+ e3.cmpname);

	}

}
