package practice_Upgrade;
import java.util.*;
import java.util.Map.*; // WHAT: Imports nested interfaces inside Map (specifically Map.Entry)
                        // HOW: Allows writing 'Entry<Integer,String>' directly instead of 'Map.Entry<Integer,String>'
                        // WHEN: Use when iterating over map entries frequently to keep loop headers shorter

public class Program_Linkedhashmap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// WHAT: LinkedHashMap is a subclass of HashMap that maintains a doubly-linked list across all entries
		// HOW: Upcasted to a HashMap<Integer,String> reference and instantiated as new LinkedHashMap<Integer,String>()
		//      Because it tracks insertion order, key 3 stays FIRST even when its value is overwritten from "C" to "D"
		// WHEN: Use when you need fast O(1) key lookups PLUS predictable insertion order (e.g., preserving API JSON field order, LRU caches, or ordered UI form data)
		HashMap<Integer,String>map=new LinkedHashMap<Integer,String>();
		map.put(3, "C"); // Inserted 1st -> Locks key 3 into the 1st position
		map.put(1, "A"); // Inserted 2nd -> 2nd position
		map.put(2, "B"); // Inserted 3rd -> 3rd position
		map.put(3, "D"); // Updates value for key 3 to "D" WITHOUT changing its 1st-place position
		
		System.out.println(map);        // Prints in exact insertion order: {3=D, 1=A, 2=B}
		System.out.println(map.get(3)); // Retrieves value for key 3 -> prints: D
		
		// WHAT: Enhanced for-loop iterating over map.entrySet()
		// HOW: Iterates through the doubly-linked entries in exact insertion order (3 -> 1 -> 2)
		// WHEN: Use whenever you need BOTH the key and the value in the exact sequence they were added
		for(Entry<Integer,String>e:map.entrySet())
		{
			// WHAT: e.getKey() extracts the key; e.getValue() extracts the mapped value
			// HOW: Concatenates key and value separated by ":"
			// WHEN: Use inside an Entry loop to access individual keys and values cleanly
			System.out.println(e.getKey()+":"+e.getValue());
		}

	}

}