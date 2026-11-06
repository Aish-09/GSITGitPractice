package Practice_Upgrade;
import java.util.*;

public class Prgm_stringBuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. Input string containing repeated words ("very" and "day")
	    String str = "the day today is a very very very very cold day";

	    // 2. Use StringBuilder instead of String:
	    //    StringBuilder is mutable and far more memory/performance efficient
	    //    than repeated string concatenation inside a loop.
	    StringBuilder ans = new StringBuilder();

	    // 3. Split the sentence into an array of words using whitespace (" ") as the delimiter
	    String[] words = str.split(" ");

	    // 4. Create a LinkedHashSet:
	    //    - Set: Disallows duplicates (only keeps the first occurrence of each word).
	    //    - LinkedHashSet: Maintains insertion order so the sentence sequence remains intact.
	    Set<String> set = new LinkedHashSet<String>();

	    // 5. Add all words from the array into the set:
	    //    Any repeated words (e.g., extra "very", trailing "day") are automatically ignored.
	    for (String word : words) {
	        set.add(word);
	    }

	    // 6. Append each unique word and a trailing space to the StringBuilder
	    for (String word : set) {
	        ans.append(word).append(" ");
	    }

	    // 7. Convert StringBuilder to String, trim off any extra leading/trailing whitespace,
	    //    and print the result to the console.
	    System.out.println(ans.toString().trim());

	}

}
