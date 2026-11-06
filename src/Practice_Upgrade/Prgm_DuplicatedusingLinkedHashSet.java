package Practice_Upgrade;
import java.util.*;

public class Prgm_DuplicatedusingLinkedHashSet {

	public static void main(String[] args) {
		// 1. Input string containing repeated words ("very" appears 4 times)
	    String str = "the day today is a very very very very cold day";
	    
	    // 2. Initialize an empty string to accumulate the result
	    String ans = "";
	    
	    // 3. Split the input sentence into an array of individual words using space (" ") as the delimiter
	    String[] words = str.split(" ");
	    
	    // 4. Create a LinkedHashSet:
	    //    - Set: Automatically ignores duplicate elements.
	    //    - LinkedHashSet: Maintains insertion order (keeps words in the order they first appeared).
	    Set<String> set = new LinkedHashSet<String>();
	    
	    // 5. Add every word from the array into the set:
	    //    If a word is already in the set (like subsequent "very" or "day"), set.add() simply ignores it.
	    for (String word : words) {
	        set.add(word);
	    }
	    
	    // 6. Iterate through the unique words in the LinkedHashSet and concatenate them back into a single string
	    for (String word : set) {
	        ans = ans + word + " ";
	    }
	    
	    // 7. Print the reconstructed sentence without duplicate words
	    System.out.println(ans);

	}

}
