package Practice_Upgrade;
import java.util.*;

public class Program_Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Roll number : ");
		int num = sc.nextInt();
		System.out.println(" ROll : " + num);
		
		System.out.println("Enter Name : ");
		String name = sc.next();
		System.out.println("Name :" + name);
		
		System.out.println("Are you willing to join : ");
		boolean bool = sc.nextBoolean();
		System.out.println(" Are you willing to join :" + bool);
		
		System.out.println("How many year of exp? : ");
		float flt = sc.nextFloat();
		System.out.println("How many year of exp? : " + flt);
		
		System.out.println("Any comments? : ");
		sc.nextLine();
		String lines=sc.nextLine();
		System.out.println("Any comments? : " + lines);
		
       
	}

}
