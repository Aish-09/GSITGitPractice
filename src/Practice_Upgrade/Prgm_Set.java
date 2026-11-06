package Practice_Upgrade;
import java.util.*;

public class Prgm_Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set <Integer> set = new HashSet <Integer>();
		set.add(100);
		set.add(200);
		System.out.println(set);
		
		Set <Integer> set1 = new LinkedHashSet <Integer>();
		set1.add(100);
		set1.add(200);
		System.out.println(set1);
	}

}
