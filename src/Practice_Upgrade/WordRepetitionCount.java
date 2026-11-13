package practice_Upgrade;

import java.util.*;
import java.util.Map.*; // WHAT: Imports Map.Entry directly
                        // HOW: Lets us write Entry<String, Integer> cleanly in the loop
                        // WHEN: Use when iterating over both keys and values of a Map

public class WordRepetitionCount {

	public static void main(String[] args) {
		
		// WHAT: Input sentence (matching Priyanka's Notepad prompt)
		// HOW: Stored as a String; we will split it by spaces into individual words
		String sentence = "the day today is a very very very cold";
		
		// WHAT: String.split(" ") breaks the sentence into an array of words
		// HOW: Uses a single space " " as the delimiter (use "\\s+" if handling multiple spaces)
		// WHEN: Use whenever you need to process individual words from a sentence or log line
		String[] words = sentence.split(" ");
		
		// WHAT: LinkedHashMap stores each unique word (Key) and its occurrence count (Value)
		// HOW: Preserves the exact left-to-right order in which words first appear in the sentence
		// WHEN: Use over HashMap when output order matters (e.g., reporting word frequency in order of appearance)
		Map<String, Integer> wordCountMap = new LinkedHashMap<>();
		
		// WHAT: Enhanced for-loop scanning each word in the array
		// HOW: Checks if the word is already in the map; increments its count by 1, or initializes it to 1
		// WHEN: Use for single-pass O(n) frequency counting instead of slow nested loops O(n^2)
		for (String word : words) {
			// getOrDefault(word, 0) returns the current count if present, or 0 if it's a new word
			wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
		}
		
		// WHAT: Iterating over entrySet() to print each word and its repetition count
		// HOW: Extracts each Entry<String, Integer> pair from the map
		// WHEN: Use when displaying full frequency reports or filtering only duplicate words (e.getValue() > 1)
		System.out.println("Word repetition count:");
		for (Entry<String, Integer> e : wordCountMap.entrySet()) {
			System.out.println(e.getKey() + " : " + e.getValue());
		}
	}
}