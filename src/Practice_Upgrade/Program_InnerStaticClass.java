package Practice_Upgrade;

//class cannot be static
class Students{
	int rollNo;
	String name;
//	menawhile inner class can be Static
	static class Address
	{
		String city;
		String state;
		String country;
		int pincode;
	}
}

public class Program_InnerStaticClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Students s1 = new Students();
		s1.rollNo = 101;
		s1.name = " Yamini";
		Students.Address address =  new Students.Address();
		address.city = "ClT";
		address.state = "Kerala";
		address.pincode = 678568;
		
//		since independtly not exisiting we need add the main class 
//		Students.Address address = s1.new Address();
//		address.city = "Pune";
//		address.state = "Maharastra";
//		address.country = "India";
//		address.pincode = 458928;
		System.out.println(s1.rollNo + " " + s1.name + " " + address.city + " " + address.pincode);
	}

}
