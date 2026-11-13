package practice_Upgrade;
import java.util.*;

public class Program_repition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "the day today is a very very very cold day";
		
		// WHAT: HashMap stores each unique word (Key) and its frequency (Value)
		// HOW: Uses hashing (note: output order is arbitrary, e.g., {the=1, a=1, very=3, today=1, is=1, cold=1, day=2})
		// WHEN: Use when you only need counts and do not care about preserving sentence word order
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		// WHAT: Splits the sentence into an array of individual words using space as delimiter
		String[] words = str.split(" ");
		
		// WHAT: Enhanced for-loop iterates through every word in the array (required in BOTH approaches)
		for (String word : words) {
			
			// WHAT: Conditional if-else check for existing keys (Priyanka's explicit approach)
			// HOW: Checks containsKey(word) -> gets current count -> increments -> overwrites entry
			// WHEN: Use in interviews when you want crystal-clear, step-by-step readable logic
			//       (In production code, this entire if-else block can be replaced by:
			//        map.put(word, map.getOrDefault(word, 0) + 1);)
			if (map.containsKey(word)) {
				int count = map.get(word);
				count++;
				map.put(word, count);
			} else {
				map.put(word, 1);
			}
		}
		
		System.out.println(map);
	}

}