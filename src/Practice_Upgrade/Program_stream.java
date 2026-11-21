package practice_Upgrade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// =========================================================================
// 2. THE MAIN DRIVER CLASS: Program_stream 
// =========================================================================
public class Program_stream {

	public static void main(String[] args) {

		// Step 1: Create Student_GSIT objects (Priyanka's exact dataset)
		Student_GSIT obj1 = new Student_GSIT("Astha", 60 , "EC");
		Student_GSIT obj2 = new Student_GSIT("Chetan", 80, "CSE");
		Student_GSIT obj3 = new Student_GSIT("Bhawna", 90, "CSE");
		Student_GSIT obj4 = new Student_GSIT("Dhruv", 50, "EC");
		Student_GSIT obj5 = new Student_GSIT("Astha", 60,"CSE");
		Student_GSIT obj6 = new Student_GSIT("Bhawna", 90, "EC");
		System.out.println("HasCode of Obj5 : " + obj5.hashCode());
		System.out.println("HasCode of Obj1 : " + obj1.hashCode());
		// Step 2: Store objects in an ArrayList
		List<Student_GSIT> list = new ArrayList<Student_GSIT>();
		list.add(obj1);
		list.add(obj2);
		list.add(obj3);
		list.add(obj4);

		// Filters students whose names start with "A" OR "B" and collects them into a
		// new List
		System.out.println("\n--FILTER NAME STARTS WITH A OR B");
		List<Student_GSIT> filterList1 = list.stream()
				.filter(s -> s.getName().startsWith("A") || s.getName().startsWith("B")).collect(Collectors.toList());

		for (Student_GSIT obj : filterList1) {
			System.out.println(obj.name + " :" + obj.marks);
		}

		// Step 3B: Cleaner Single-Pass Alternative (Eliminates the extra List &
		// for-loop)
		System.out.println("\n--- Pure Stream Approach ---");
		list.stream().filter(s -> s.getName().startsWith("A") || s.getName().startsWith("B"))
				.forEach(obj -> System.out.println(obj.getName() + " :" + obj.getMarks()));

		// -----------------------------------------------------------------
		// FILTER 2 (New filterList2): Filter by Marks (e.g., Marks >= 80)
		// -----------------------------------------------------------------
		// WHAT: Uses a numeric Predicate (s -> s.getMarks() >= 80) to filter high
		// scorers.
		// WHY: Demonstrates filtering on integer properties instead of String methods.
		System.out.println("\nFILTER MARKS >= 80");
		List<Student_GSIT> filterList2 = list.stream().filter(s -> s.getMarks() >= 80).collect(Collectors.toList());

		for (Student_GSIT obj : filterList2) {
			System.out.println(obj.name + " :" + obj.marks);
		}

		// -----------------------------------------------------------------
		// BONUS (Combined Filter): Name starts with A/B AND Marks > 70
		// -----------------------------------------------------------------
		System.out.println("\n---FILTER NAME (A/B) AND MARKS > 70---");
		list.stream().filter(s -> (s.getName().startsWith("A") || s.getName().startsWith("B")) && s.getMarks() > 70)
				.forEach(s -> System.out.println(s.getName() + " :" + s.getMarks()));

		// =========================================================================
		// ACTIVE CODE ON SCREEN (Lines 68 - 75): SORTING BY MARKS ASCENDING
		// =========================================================================
		System.out.println("\n---SORT ON MARKS ASC---");

		list
				// 1. WHAT: .stream() converts the ArrayList into a sequential data pipeline.
				// WHY: Collections (Lists) don't have built-in functional pipeline operations;
				// Streams allow chaining filter, map, and sort without mutating the original
				// list.
				.stream()

				// 2. WHAT: .sorted() arranges elements in natural (ascending) order.
				// HOW: Comparator.comparingInt(...) extracts the primitive 'int' marks from
				// each object.
				// WHAT IS '::' (Line 66 note: CLASSNAME::METHODNAME)? It is a Method Reference.
				// WHY use 'Student_GSIT::getMarks' instead of 's -> s.getMarks()'?
				// It is cleaner shorthand syntax when a lambda simply calls an existing method.
				// WHY comparingInt() instead of comparing()? It avoids autoboxing overhead
				// (converting primitive int to Integer wrapper objects), making numeric sorting
				// faster.
				.sorted(Comparator.comparingInt(Student_GSIT::getMarks))

				// 3. WHAT: .forEach() is a Terminal Operation that triggers the pipeline.
				// WHEN does the sorting actually happen? ONLY when .forEach() is called (Lazy
				// Evaluation).
				// HOW: It takes a Lambda Expression (s -> ...) to print each sorted student's
				// name and marks.
				.forEach(s -> System.out.println(s.name + ":" + s.marks));

		// =========================================================================
		// COMMENTED CODE ON SCREEN (Lines 77 - 84): SORTING BY Marks DESCENDING
		// =========================================================================
		System.out.println("\n---SORT ON Marks DESC---");

		list.stream().sorted(Comparator.comparing(Student_GSIT::getMarks).reversed())
				.forEach(s -> System.out.println(s.name + ":" + s.marks));

		System.out.println("\n---SORT ON Name DESC---");

		list.stream()
				// HOW: Comparator.comparing() handles Object types (like String) instead of
				// primitives.
				// .reversed() flips the natural A-Z alphabetical order to Z-A (Descending).
				.sorted(Comparator.comparing(Student_GSIT::getName).reversed())
				.forEach(s -> System.out.println(s.name + ":" + s.marks));

		// =========================================================================
		// BLOCK 1: SORT ON NAME ASCENDING (Lines 88 - 92)
		// =========================================================================
		System.out.println("\nSORT ON NAME IN ASCENDING ORDER");

		list
				// WHAT: Converts the ArrayList into a sequential Stream pipeline.
				// WHY: Lets you sort data without modifying the original 'list' in memory.
				.stream()

				// WHAT: Sorts elements using a manual two-parameter Lambda Comparator.
				// HOW: Takes two objects (a, b) and calls String's .compareTo() method.
				// - Negative result (< 0): 'a' comes BEFORE 'b' (no swap).
				// - Positive result (> 0): 'a' comes AFTER 'b' (SWAP happens).
				// - Zero (0): Order stays unchanged.
				// WHY .compareTo()? Strings are Objects, not numbers—you cannot use '-' or '<'
				// on them.
				.sorted((a, b) -> a.getName().compareTo(b.getName()))

				// WHAT: Terminal operation that executes the stream and prints each sorted
				// name.
				// WHEN: Sorting actually runs ONLY when .forEach() is reached (Lazy
				// Evaluation).
				.forEach(s -> System.out.println(s.name));

		// =========================================================================
		// BLOCK 2: SORT ON NAME DESCENDING (Lines 94 - 98)
		// =========================================================================
		System.out.println("\nSORT COMPARATOR NAME DESC ^^^");

		list.stream()
				// HOW: Notice 'b' and 'a' are swapped -> b.getName().compareTo(a.getName()).
				// WHY: Flipping 'a' and 'b' reverses the positive/negative signs, forcing
				// Z-to-A order.
				.sorted((a, b) -> b.getName().compareTo(a.getName())).forEach(s -> System.out.println(s.name));

		// =========================================================================
		// BLOCK 3: SORT ON MARKS ASCENDING (Lines 100 - 104)
		// =========================================================================
		System.out.println("\nSORT COMPARATOR MARKS ASC ^^^");

		list.stream()
				// HOW (Explained in Priyanka's Notepad): Subtracts primitive int fields
				// (a.marks - b.marks).
				// - Example from Notepad: List has [10, 5] -> a = 10, b = 5.
				// - Calculation: 10 - 5 = +5 (which is > 0).
				// - Rule: Whenever result is > 0, Java SWAPS them -> becomes [5, 10]
				// (Ascending).
				// WHY no getter here? She accessed 'a.marks' directly instead of 'a.getMarks()'
				// because 'marks' is package-private in the same folder.
				.sorted((a, b) -> a.marks - b.marks).forEach(s -> System.out.println(s.marks));

		// =========================================================================
		// CODE BLOCK .map() vs .sorted() & .collect()
		// =========================================================================
		System.out.println("\nMAP INTO NAME***");

		// WHAT is 'nameList'? A brand-new List holding ONLY Strings (not Student_GSIT
		// objects).
		// WHY did the type change from List<Student_GSIT> to List<String>?
		// - With .sorted() (previous block): Object type stays the SAME (Student_GSIT
		// -> Student_GSIT); only positions change.
		// - With .map() (this block): Object type TRANSFORMS (Student_GSIT -> String);
		// each object is replaced by its extracted name.
		List<String> nameList = list
				// 1. WHAT: Starts a Stream<Student_GSIT> pipeline from the original ArrayList.
				// WHY: Keeps the original 'list' untouched in memory.
				.stream()

				// 2. WHAT is .map()? An Intermediate Operation that transforms every element's
				// value and/or data type.
				// HOW does it differ from .sorted()?
				// - .sorted(Comparator): Compares 2 items (a, b) to reorder them; output count
				// & type stay identical.
				// - .map(Function): Takes 1 item (Student_GSIT), extracts/converts it via
				// Student_GSIT::getName,
				// and outputs a Stream<String>.
				// WHEN to use .map(): Whenever you want to extract a single field (like names
				// or marks) or convert data formats.
				.map(Student_GSIT::getName)

				// 3. WHAT is .collect(Collectors.toList())? A Terminal Operation that ends the
				// pipeline.
				// WHY use it instead of .forEach()? .forEach() prints and discards the stream;
				// .collect() saves the transformed Stream<String> into a reusable List<String>
				// variable.
				// WHEN does .map() actually execute? Right here—Streams are lazy and won't
				// transform anything until .collect() runs.
				.collect(Collectors.toList());

		// 4. WHAT is happening on Line 117?
		// HOW: Calls List's built-in .forEach() directly on 'nameList' (no .stream()
		// needed just to print).
		// NOTE: Notice 's' is now a String (e.g., "Chetan", "Bhawna" seen in your
		// console output), NOT a Student_GSIT object.
		nameList.forEach(s -> System.out.println(s));
		
		// =========================================================================
		// CODE BLOCK 1 (Lines 120 - 125): STREAM .map() WITH A LAMBDA EXPRESSION
		// =========================================================================
		System.out.println("\n---MAP SQUARE***");

		// 1. WHAT is Arrays.asList(1,2,3,4,5)? A quick shortcut to create a fixed-size List<Integer>.
		// WHY Integer instead of int? Java Generics (List<...>) cannot hold primitive types (int); 
		// Java automatically converts 1, 2, 3, 4, 5 into Integer wrapper objects (Autoboxing).
		List<Integer> number = Arrays.asList(1, 2, 3, 4, 5);

		number
		    // 2. WHAT: Converts the List<Integer> into a Stream<Integer>.
		    .stream()

		    // 3. WHAT is .map(num -> num * num)? Transforms every number's value while keeping its type (Integer).
		    // WHY use a Lambda (->) here instead of a Method Reference (::) like line 114?
		    // Because multiplying a number by itself (num * num) is a custom math expression—not a single 
		    // existing method on the Integer class—so you MUST use a Lambda expression.
		    // HOW: Takes each element 'num', squares it (1->1, 2->4, 3->9, 4->16, 5->25), and passes it downstream.
		    .map(num -> num * num)

		    // 4. WHAT: Terminal operation that triggers the stream and prints each squared result.
		    // WHEN does the squaring math actually happen? Right here, when .forEach() executes.
		    .forEach(num -> System.out.println(num));
		
		
		// =========================================================================
		// PART 1 (Lines 129 - 130): THE CONCEPT — MANUAL UNBOXING (WRAPPER -> PRIMITIVE)
		// =========================================================================
		// WHAT: Creates an 'Integer' Wrapper Object (stored in Heap memory).
		Integer num2 = 100;

		// WHAT: Manual Unboxing — extracts the raw primitive 'int' out of the 'Integer' object.
		// WHY is Priyanka showing this standalone example? 
		// To demonstrate the exact method (.intValue()) that the Stream on line 138 will call automatically 
		// on every student's marks using a Method Reference (Integer::intValue).
		int data2 = num2.intValue();


		// =========================================================================
		// PART 2 (Lines 132 - 140): APPLYING UNBOXING TO SUM MARKS IN A STREAM
		// =========================================================================
		System.out.println("\n---MARKS TOTAL**");

		int sum = 
		    list
		        // 1. WHAT: Starts a sequential Stream<Student_GSIT> from the list.
		        .stream()

		        // 2. WHAT: Extracts each student's marks.
		        // WHY does this produce Stream<Integer> instead of primitive ints? 
		        // Standard .map() always outputs Wrapper Objects (Stream<Integer>), even if getMarks() returns an int.
		        .map(Student_GSIT::getMarks)

		        // 3. WHAT is .mapToInt(Integer::intValue)? Converts Stream<Integer> into a specialized primitive 'IntStream'.
		        // WHY do we need this step? A regular Stream<Integer> does NOT have .sum(), .average(), or .max() methods—
		        // Java only provides math aggregation methods on primitive streams (IntStream, LongStream, DoubleStream).
		        // HOW does it work? For every Integer object in the stream, it calls .intValue() (just like line 130!) 
		        // to unbox it into a fast, primitive 'int'.
		        .mapToInt(Integer::intValue)

		        // 4. WHAT: Terminal operation that adds all primitive 'int' values together and returns a single 'int'.
		        // WHEN does the extraction and unboxing actually run? Right here, when .sum() triggers the pipeline.
		        .sum();

		// 5. Prints the final calculated integer total.
		System.out.println(sum);
		
		// =========================================================================
		// NEW CODE BLOCK (Lines 146 - 149): SUMMING WITHOUT UNBOXING USING .reduce()
		// =========================================================================
		System.out.println("\n---MARKS TOTAL USING REDUCE(STREAM OF INTEGER)**");

		// 1. WHAT is 'Optional<Integer>'? A container object that may or may not hold a non-null Integer.
		// WHY does .reduce() return Optional<Integer> instead of a plain 'int' (like .sum() did on line 138)?
		// Because if 'list' is empty, there are no numbers to add! Instead of crashing with a NullPointerException 
		// or guessing a default value, Java wraps the result safely inside an Optional container.
		Optional<Integer> sum2 = 
		    list
		        // 2. WHAT: Creates a Stream<Student_GSIT> from the list.
		        .stream()

		        // 3. WHAT: Extracts marks into a Stream<Integer> (Wrapper objects).
		        // NOTE: Priyanka's screen has a typo here ('Student::getMarks' with a red error underline). 
		        // It MUST be 'Student_GSIT::getMarks' to match your class name.
		        .map(Student_GSIT::getMarks)

		        // 4. WHAT is .reduce(Integer::sum)? A Terminal Operation that combines all elements in the stream 
		        // into a single result by repeatedly applying a combining function.
		        // WHY use .reduce() here? In the previous block (lines 141-143), we had to unbox Integer -> int 
		        // using .mapToInt(Integer::intValue) just to call .sum(). With .reduce(Integer::sum), you can add 
		        // Wrapper Objects directly on a normal Stream<Integer> without converting to a primitive IntStream!
		        // HOW does Integer::sum work under the hood? It takes two numbers at a time (a, b) -> Integer.sum(a, b):
		        //   - Step 1: Takes 1st & 2nd marks -> adds them into a running total.
		        //   - Step 2: Takes that running total & 3rd mark -> adds them together, until 1 final sum remains.
		        .reduce(Integer::sum);

		// 5. WHAT is 'sum2.get()'? Unwraps and extracts the actual Integer value out of the Optional container.
		// WHEN is .get() safe vs. unsafe? 
		//   - Safe ONLY when you are 100% sure 'list' is not empty.
		//   - Unsafe if 'list' could be empty (it throws NoSuchElementException). In production code, 
//		     use 'sum2.orElse(0)' instead of 'sum2.get()' so an empty list safely returns 0.
		System.out.println(sum2.get());
		
		// WHAT: Prints a section header to the console for clarity.
		// WHY: To distinguish the output of this first approach from other calculations.
		System.out.println("\n----MAXIMUM MARKS-1");

		// WHAT: Finds the highest mark among all students and wraps it in an Optional<Integer>.
		// HOW: 
		//   1. list.stream() -> Converts the list of Student_GSIT objects into a sequential Stream.
		//   2. .map(Student_GSIT::getMarks) -> Transforms each student object into their Integer marks using a method reference.
		//   3. .reduce(Integer::max) -> Compares elements pairwise using Integer.max() to boil the stream down to a single maximum value.
		// WHY Optional?: If the student list is empty, there is no maximum value; Optional prevents a NullPointerException.
		// WHEN to use: When working directly with wrapper objects (Integer) and using general reduction operations.
		Optional<Integer> max = list.stream()
		                            .map(Student_GSIT::getMarks)
		                            .reduce(Integer::max);

		// WHAT: Extracts and prints the actual Integer value stored inside the Optional container.
		// WARNING (WHERE it can fail): Calling .get() directly throws a NoSuchElementException if the list was empty.
		System.out.println(max.get());


		// WHAT: Prints a header for the second, more optimized approach.
		System.out.println("\n----MAXIMUM MARKS-2");

		// WHAT: Finds the highest mark using a primitive int stream, returning an OptionalInt.
		// HOW:
		//   1. list.stream() -> Creates a stream of Student_GSIT objects.
		//   2. .map(Student_GSIT::getMarks) -> Extracts the marks as boxed Integer objects.
		//   3. .mapToInt(Integer::intValue) -> Unboxes Integer objects into primitive ints, converting Stream<Integer> to IntStream.
		//   4. .max() -> Uses IntStream's built-in terminal operation to directly find the maximum primitive int.
		// WHY this is better: Avoids repeated autoboxing/unboxing overhead during comparisons, improving memory and CPU performance.
		// WHEN to use: Preferred approach whenever performing numeric aggregations (max, min, sum, average) on large datasets.
		OptionalInt max3 = list.stream()
		                       .map(Student_GSIT::getMarks)
		                       .mapToInt(Integer::intValue)
		                       .max();

		// WHAT: Extracts and prints the primitive int value from OptionalInt.
		// NOTE: Uses .getAsInt() instead of .get() because OptionalInt holds a primitive int rather than an Object.
		System.out.println(max3.getAsInt());
		
		// WHAT: Prints a section header to the console.
		// WHY: To label the output showing the name of the student with the highest marks.
		System.out.println("\n---MAXIMUM MARKS PERSON's NAME");

		// WHAT: Finds the entire Student object with the highest marks and wraps it in an Optional<Student>.
		// WHY keep the whole object?: Unlike previous blocks that used .map() to extract only the marks (losing the student's name), 
//		      calling .max() directly on Stream<Student> preserves the complete Student object so you can access any of its fields later.
		// HOW:
		//   1. list.stream() -> Creates a sequential stream of Student objects.
		//   2. .max(...) -> Terminal operation that finds the maximum element according to a given Comparator.
		//   3. Comparator.comparingInt(Student::getMarks) -> Cleanly builds a Comparator that extracts primitive int marks from each Student 
//		      to compare them without autoboxing overhead (replacing the verbose commented-out lambda: (a,b) -> Integer.compare(a.getMarks(), b.getMarks())).
		// WHEN to use: Whenever you need the object owning the max/min attribute (e.g., top-scoring student, highest-paid employee) rather than just the numeric value itself.
		// NOTE (WHERE an error exists in the screenshot): Lines 167 & 170 reference 'Student' instead of 'Student_GSIT' (used in earlier lines) and line 170 has a missing opening parenthesis/syntax error on the screen.
		Optional<Student_GSIT> maxMarks = list.stream()
		                                 .max(Comparator.comparingInt(Student_GSIT::getMarks));

		// WHAT: Unwraps the Student object from the Optional and accesses its 'name' field to print it.
		// WARNING (WHERE it can fail): 
		//   1. Calling .get() throws a NoSuchElementException if the list is empty.
		//   2. Accessing .name directly requires 'name' to have package-private or public visibility (otherwise a getter like .getName() is needed).
		System.out.println(maxMarks.get().name + " : " + maxMarks.get().marks);
		
		System.out.println("\n---MINIMUM MARKS PERSON's NAME");

		// WHAT: Finds the entire Student object with the highest marks and wraps it in an Optional<Student>.
		// WHY keep the whole object?: Unlike previous blocks that used .map() to extract only the marks (losing the student's name), 
//		      calling .max() directly on Stream<Student> preserves the complete Student object so you can access any of its fields later.
		// HOW:
		//   1. list.stream() -> Creates a sequential stream of Student objects.
		//   2. .max(...) -> Terminal operation that finds the maximum element according to a given Comparator.
		//   3. Comparator.comparingInt(Student::getMarks) -> Cleanly builds a Comparator that extracts primitive int marks from each Student 
//		      to compare them without autoboxing overhead (replacing the verbose commented-out lambda: (a,b) -> Integer.compare(a.getMarks(), b.getMarks())).
		// WHEN to use: Whenever you need the object owning the max/min attribute (e.g., top-scoring student, highest-paid employee) rather than just the numeric value itself.
		// NOTE (WHERE an error exists in the screenshot): Lines 167 & 170 reference 'Student' instead of 'Student_GSIT' (used in earlier lines) and line 170 has a missing opening parenthesis/syntax error on the screen.
		Optional<Student_GSIT> maxMarks1 = list.stream()
		                                 .max(Comparator.comparingInt(Student_GSIT::getMarks).reversed());

		// WHAT: Unwraps the Student object from the Optional and accesses its 'name' field to print it.
		// WARNING (WHERE it can fail): 
		//   1. Calling .get() throws a NoSuchElementException if the list is empty.
		//   2. Accessing .name directly requires 'name' to have package-private or public visibility (otherwise a getter like .getName() is needed).
		System.out.println(maxMarks1.get().name + " : " + maxMarks1.get().marks);
		
		// WHAT: Prints a section header to the console.
		// WHY: To label the output showing the total number of students who scored 70 or above.
		System.out.println("\n---Count students scoring more than 70");

		// WHAT: Counts how many Student_GSIT objects in the list have marks >= 70.
		// HOW:
		//   1. list.stream() -> Converts the list of Student_GSIT objects into a sequential Stream.
		//   2. .filter(s -> s.marks >= 70) -> Intermediate operation that evaluates a Predicate (boolean condition) on each student,
//		      keeping only those whose marks are greater than or equal to 70 and discarding the rest.
		//   3. .count() -> Terminal operation that counts the remaining elements in the filtered stream and returns a primitive long
//		      (which is automatically boxed here into a wrapper Long).
		// WHY long/Long instead of int?: Streams can theoretically process massive datasets exceeding Integer.MAX_VALUE (~2.14 billion), 
//		      so Java's Stream.count() is designed to return a 64-bit long.
		// WHEN to use: Whenever you need the total count of items matching a condition without collecting the actual objects into a new list.
		// NOTE (WHERE a subtle discrepancy exists): The print statement says "more than 70" (> 70), but the code on screen uses >= 70 (70 or more).
		Long count = list.stream()
		                 .filter(s -> s.marks >= 70)
		                 .count();

		// WHAT: Prints the final count to the console.
		// WHY it's safe (unlike .get() in previous examples): .count() always returns a valid number (0 if no students match), 
//		      so it never returns an Optional or throws an exception on an empty stream.
		System.out.println(count);
		
		// =========================================================================
		// SECTION 1: TOPPER OF THE BATCH (Lines 178 - 181)
		// =========================================================================

		// WHAT: Prints a section header to the console.
		// WHY: To label the output intended to show the batch topper's name.
		System.out.println("\n---TOPPER OF THE BATCH");

		// WHAT: Sorts the students and grabs the first element in the sorted stream, wrapping it in an Optional<Student_GSIT>.
		// HOW:
		//   1. list.stream() -> Creates a sequential stream of Student_GSIT objects.
		//   2. .sorted(Comparator.comparing(Student_GSIT::getMarks)) -> Sorts the stream elements in natural (ASCENDING) order 
//		      based on marks (lowest marks first, highest marks last).
		//   3. .findFirst() -> Short-circuiting terminal operation that stops processing as soon as it encounters the very first 
//		      element in the sorted stream and returns it inside an Optional.
		// CRITICAL BUG (WHERE the logic fails on screen): 
		//   Comparator.comparing(...) sorts in ASCENDING order (lowest to highest). Therefore, .findFirst() actually returns 
		//   the student with the LOWEST marks, NOT the topper! 
		//   HOW to fix it: Add .reversed() -> Comparator.comparing(Student_GSIT::getMarks).reversed()
		// WHY Optional?: If the list is empty, there is no "first" element, so Optional safely represents the absence of a result.
		Optional<Student_GSIT> opt1 = list.stream()
		                                  .sorted(Comparator.comparing(Student_GSIT::getMarks))
		                                  .findFirst();

		// WHAT: Extracts the Student_GSIT object from the Optional and prints their name.
		// WARNING (WHERE it can fail): Throws NoSuchElementException if the list is empty.
		System.out.println(opt1.get().name);


		// =========================================================================
		// SECTION 2: TOP 3 BASED ON MARKS (Lines 183 - 185)
		// =========================================================================

		// WHAT: Prints a section header to the console.
		// WHY: To label the output showing the top 3 highest-scoring students.
		System.out.println("\n---TOP 3 BASED ON MARKS LIMIT**");

		// WHAT: Sorts all students from highest to lowest marks, slices the top 3, and prints each of their names.
		// HOW:
		//   1. list.stream() -> Creates a stream of Student_GSIT objects.
		//   2. .sorted((a, b) -> b.marks - a.marks) -> Custom Comparator lambda that sorts in DESCENDING order. 
//		      (When b.marks > a.marks, it returns a positive number, placing 'b' before 'a'—so highest marks come first).
		//   3. .limit(3) -> Short-circuiting intermediate operation that truncates the stream to contain at most 3 elements.
		//   4. .forEach(s -> System.out.println(s.name)) -> Terminal operation that iterates over those 3 remaining students 
//		      and prints each student's name directly (returns void, so no variable assignment is needed).
		// WHEN to use .limit(n): Whenever you need a "Top N" leaderboard or pagination slice after sorting.
		// NOTE (WHERE an edge-case risk exists): Using subtraction (b.marks - a.marks) works fine for normal exam scores, 
//		      but in general Java development, Integer.compare(b.marks, a.marks) is safer to prevent integer overflow.
		list.stream()
		    .sorted((a, b) -> b.marks - a.marks)
		    .limit(3)
		    .forEach(s -> System.out.println(s.name));
		
		System.out.println("\n---LOW OF THE BATCH");
		Optional<Student_GSIT> opt11 = list.stream()
                .sorted(Comparator.comparing(Student_GSIT::getMarks).reversed()).findAny();
//                .findFirst();
		     
		System.out.println(opt11.get().name);
		
		// =========================================================================
		// SECTION 1: DISTINCT ELEMENTS (Lines 205 - 206)
		// =========================================================================

		// WHAT: Prints a section header to the console.
		// WHY: To label the output showing unique student entries after removing duplicates.
		System.out.println("\n--DISTINCT**");

		// WHAT: Filters out duplicate Student objects from the stream and prints each unique student's name.
		// HOW:
		//   1. list.stream() -> Creates a sequential stream of Student objects.
		//   2. .distinct() -> Stateful intermediate operation that removes duplicate elements by comparing them 
//		      using their .equals() and .hashCode() methods, preserving the order of first appearance.
		//   3. .forEach(s -> System.out.println(s.name)) -> Terminal operation that prints each remaining student's name.
		// CRITICAL CATCH (WHY "Dhruv" appears twice in the SKIP output below, yet only once here):
		//   - If 'list' had two references pointing to the EXACT SAME object instance in memory (e.g., list.add(s4); list.add(s4);),
//		     Object.equals() returns true, so .distinct() removes the duplicate reference!
		//   - HOWEVER, if you create two separate objects with identical data (new Student("Dhruv", 70) twice) WITHOUT 
//		     overriding equals() and hashCode() in your Student class, .distinct() will NOT treat them as duplicates.
		// WHEN to use: Whenever you need unique items from a list (e.g., unique cities, unique student IDs) without manually creating a Set.
		list.stream()
		    .distinct()
		    .forEach(s -> System.out.println(s.name));


		// =========================================================================
		// SECTION 2: SKIPPING TOP N ELEMENTS (Lines 209 - 210)
		// =========================================================================

		// WHAT: Prints a section header to the console.
		// WHY: To label the output showing students ranked 3rd and below after skipping the top 2 scorers.
		System.out.println("\n---SKIP**");

		// WHAT: Sorts all students from highest to lowest marks, skips the first 2 students, and prints the remaining names.
		// HOW:
		//   1. list.stream() -> Creates a stream of Student objects (note: this is a fresh stream from 'list', so the duplicate 
//		      'Dhruv' entry from the original list is still present here!).
		//   2. .sorted((a, b) -> b.marks - a.marks) -> Sorts the stream in DESCENDING order (highest marks first).
		//   3. .skip(2) -> Stateful intermediate operation that discards the first 2 elements of the sorted stream 
//		      (in the console output: Bhawna and Chetan are skipped) and passes the rest downstream (Astha, Dhruv, Dhruv).
		//   4. .forEach(s -> System.out.println(s.name)) -> Terminal operation that prints each remaining student's name.
		// WHEN to use .skip(n): 
		//   - Pagination (e.g., .skip((pageNumber - 1) * pageSize).limit(pageSize)).
		//   - Excluding top outliers or podium winners (e.g., finding runners-up after rank #2).
		// NOTE (WHERE an edge-case risk exists): If the stream has fewer than 2 elements, .skip(2) safely returns an empty stream 
//		      without throwing an exception.
		list.stream()
		    .sorted((a, b) -> b.marks - a.marks)
		    .skip(2)
		    .forEach(s -> System.out.println(s.name));
		
		// WHAT: Groups identical numbers together, counts their frequency, and extracts those with a count > 1.
		// HOW:
		//   1. numbers.stream() -> Creates a stream of Integers.
		//   2. .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) -> Builds a Map<Integer, Long> 
//		      where Key = the number, and Value = how many times it appeared ({1=3, 2=2, 3=1, 4=1, 5=1}).
		//   3. .entrySet().stream() -> Converts the Map's key-value pairs into a new Stream so we can filter them.
		//   4. .filter(entry -> entry.getValue() > 1) -> Keeps only entries whose frequency count is greater than 1.
		//   5. .map(Map.Entry::getKey) -> Extracts just the number (the Key) from each surviving Map.Entry.
		//   6. .collect(Collectors.toList()) -> Gathers the duplicate numbers into a List: [1, 2].
		// WHY this is great for interviews: It is 100% stateless (no external HashSet needed) and safe for parallel streams.
		// WHEN to use: When the interviewer asks for a pure functional approach without external state, or when you also need exact counts.
		List<Integer> numbers = Arrays.asList(1, 1, 1, 2, 2, 3, 4, 5);
		List<Integer> duplicatesByCount = numbers.stream()
		                                         .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		                                         .entrySet()
		                                         .stream()
		                                         .filter(entry -> entry.getValue() > 1)
		                                         .map(Map.Entry::getKey)
		                                         .collect(Collectors.toList());

		System.out.println("Duplicates : " + duplicatesByCount); 
		
		// 1. WHAT: Filters map entries (val > 1) and finds highest-scoring Student_GSIT per department.
		// 2. WHY: Comparator.comparingInt avoids subtraction overflow; Optional<Student_GSIT> models empty groups safely.
		// 3. WHERE: Calling .get() without checking isPresent() risks NoSuchElementException; null fields risk NPE.
		// 4. WHEN: Use groupingBy + maxBy when aggregating one max item per bucket across a Stream.
		// 5. HOW: Stream map entries (>1) -> group list by dept with maxBy(comparingInt(marks)) -> print entry key & values.
		System.out.println("\n----HIGHEST SCORER IN EACH DEPT**");
		Map<String, Optional<Student_GSIT>> groupList =
		    list
		        .stream()
		        .collect(
		            Collectors.groupingBy(
		                Student_GSIT::getDept,
		                Collectors.maxBy(Comparator.comparingInt(Student_GSIT::getMarks))));

		for (Map.Entry<String, Optional<Student_GSIT>> e : groupList.entrySet()) {
		    System.out.println(
		        e.getKey() + ":" + e.getValue().get().getMarks() + ":" + e.getValue().get().getName());
		}
		
		/*
		 * WHAT: Generates and prints the first 10 Fibonacci numbers (0 1 1 2 3 5 8 13 21 34) on one line.
		 * WHY: Stream.iterate with a 2-element int[] seed {0, 1} carries the current and next Fibonacci values
		 *      without needing an external loop counter or mutable outside variable.
		 * WHERE: Uses Java Stream.iterate (lines 260-261) in Program_stream.java; watch out for int overflow
		 *        if .limit(n) is raised high (48th Fibonacci number exceeds Integer.MAX_VALUE).
		 * WHEN: Useful in interviews/demos to show stateful stream generation with a bounded .limit(10);
		 *       for large sequences or clarity in production code, a standard loop or BigInteger is safer.
		 * WHO / WHAT: Stream.iterate creates the infinite stream, arr -> new int[] {arr[1], arr[1] + arr[0]}
		 *             advances the pair, .limit(10) caps evaluation, and .forEach prints s[0] (" " separated).
		 * HOW: Seed {0, 1} -> next state {prevCurr, prevCurr + prevPrev} -> take 10 elements -> print s[0] + " ".
		 */
		System.out.println("\n---FIBONACCI**");
		Stream.iterate(new int[] {0, 1}, arr -> new int[] {arr[1], arr[1] + arr[0]})
		    .limit(15)
		    .forEach(s -> System.out.print(s[0] + " "));
		
		/*
		 * WHAT: Prints the first 10 Fibonacci numbers (0 1 1 2 3 5 8 13 21 34) on a single line.
		 * WHY: A simple for-loop with two int variables (a = 0, b = 1) is easy to read, avoids stream/array
		 *      allocation overhead per step, and shows straightforward iterative logic in interviews.
		 * WHERE: Replaces the Stream.iterate Fibonacci block in Program_stream.java using standard Java primitives.
		 * WHEN: Best when you want readable, low-overhead sequence generation for small counts or clear interview walkthroughs.
		 * WHO / WHAT: Two int variables (a, b) and a next variable hold the sequence state across a loop of 10 iterations,
		 *             while System.out.print prints each value separated by a space.
		 * HOW: Start with a = 0, b = 1; in each step print a, compute next = a + b, shift a = b and b = next.
		 */
		System.out.println("\n\n---FIBONACCI for loop**");
		int n = 15, a = 0, b = 1;
		for (int i = 0; i < n; i++) {
		    System.out.print(a + " ");
		    int next = a + b;
		    a = b;
		    b = next;
		}
		
		/*
		 * WHAT: Prints "TESTING STREAM ITERATE**" followed by a 10-element sequence starting at 10 (10 100 1000...).
		 * WHY: Demonstrates how changing the seed and step expression in Stream.iterate alters the generated series
		 *      when testing stream iteration behavior rather than standard Fibonacci.
		 * WHERE: Lines 263-267 in Program_stream.java right after the "Next we will see**" block, corresponding
		 *        to the "TESTING STREAM ITERATE**" console line in Eclipse IDE.
		 * WHEN: Useful in interviews or practice sessions to show how Stream.iterate seeds and lambda state transitions
		 *       control every emitted element and expose growth/overflow behavior.
		 * WHO / WHAT: System.out.println prints the section header, Stream.iterate generates the sequence up to
		 *             .limit(10), and .forEach prints each s[0] separated by a space.
		 * HOW: Seed initial state -> apply next-state lambda -> cap stream with .limit(10) -> print s[0] + " ".
		 */
		System.out.println("\n\n----TESTING STREAM ITERATE**");
		Stream.iterate(new int[] {10, 100}, arr -> new int[] {arr[1], arr[1] * 10})
		    .limit(10)
		    .forEach(s -> System.out.print(s[0] + " "));
		
		
		/*
		 * WHAT: Creates a List<Integer> from 1 to 10 (prints "1 2 3 4 5 6 7 8 9 10 ") and then generates
		 *       3 scaled random numbers using Math.random() * 10, rounded with Math.round(), and printed on one line.
		 * WHY: Demonstrates boxing a primitive IntStream into List<Integer> via .boxed() and generating bounded
		 *      random values with Stream.generate, .limit(3), and map/map(Math::round) in Java Stream API.
		 * WHERE: Lines 280-289 of Program_stream.java in Eclipse IDE (note the stray semicolon on line 287 in the
		 *        current editor view causes a "Syntax error on token ';', delete this token" error until removed).
		 * WHEN: Useful in interviews or practice to compare primitive IntStream vs. boxed Stream<Integer> and to
		 *       show how Stream.generate produces non-deterministic streams that require .limit(n).
		 * WHO / WHAT: IntStream.range(1, 11).boxed() and Collectors.toList() build list2; Stream.generate(Math::random)
		 *             with .limit(3), map(num -> num * 10), map(Math::round), and .forEach prints the rounded numbers.
		 * HOW: Range 1..10 -> boxed() -> toList() -> print elements; then generate random doubles -> limit(3) ->
		 *      scale by 10 -> round -> print each value -> print newline.
		 */
		System.out.println("\nBOXED INT STREAM TO STREAM<INTEGER>");
		//IntStream to List<Integer>
		List<Integer> list2 = IntStream.range(1, 11).boxed().collect(Collectors.toList());
		list2.forEach(s -> System.out.print(s + " "));

		System.out.println("Random");
		Stream.generate(Math::random).limit(3).map(num -> num * 10)
		    .map(Math::round)
		    .forEach(s -> System.out.print(s + " "));
		System.out.println();
		
	}
	
	
}

// ========================================================================
// NOTE: Because this class is in the same '.java' file as 'public class Program_stream',
//       it MUST NOT have the 'public' keyword (Java allows only one 'public' class per file).
class Student_GSIT {
	int marks;
	String name;
	String dept;

	// Parameterized Constructor
	public Student_GSIT(String name, int marks, String dept) {
		this.name = name;
		this.marks = marks;
		this.dept = dept;
	}
	
	public String getDept() {
        return dept;
    }

	public int getMarks() {
		return marks;
	}

	// Getters & Setters (Used by Stream lambdas like 's -> s.getName()')
	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(marks), name);
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student_GSIT other = (Student_GSIT) obj;
		return marks == other.marks && Objects.equals(name, other.name);
	}
	
	
}
