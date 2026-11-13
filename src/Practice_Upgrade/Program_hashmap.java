package practice_Upgrade;

import java.util.*;
import java.util.Map.*; // WHAT: Imports nested interfaces inside Map (specifically Map.Entry)
                        // HOW: Allows writing 'Entry<Integer,String>' directly instead of 'Map.Entry<Integer,String>'
                        // WHEN: Use when iterating over map entries frequently to keep loop headers shorter

public class Program_hashmap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// WHAT: HashMap stores unique Key-Value pairs using hashing for fast O(1) lookup
		// HOW: Declared with Wrapper types <Integer, String> (collections do not accept primitive int)
		// WHEN: Use when you need fast data retrieval by key (e.g., test data, API headers, config settings)
		HashMap<Integer,String>map=new HashMap<Integer,String>();
		map.put(3, "C");
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "D"); // Duplicate key '3' overwrites previous value "C" with "D"
		
		System.out.println(map);        // Prints entire map: {1=A, 2=B, 3=D}
		System.out.println(map.get(3)); // Retrieves value for key 3 -> prints: D
		
		// WHAT: Enhanced for-loop iterating over map.entrySet()
		// HOW: entrySet() converts the HashMap into a Set of Key-Value pairs (Entry objects)
		// WHEN: Use whenever you need BOTH the key and the value together (e.g., validating UI tables or API responses)
		for(Entry<Integer,String>e:map.entrySet())
		{
			// WHAT: e.getKey() extracts the key; e.getValue() extracts the mapped value
			// HOW: Concatenates key and value separated by ":"
			// NOTE: There is a stray typo 't' after getValue() on screen that will cause a compile error until removed
			System.out.println(e.getKey()+":"+e.getValue());
		}

	}

}