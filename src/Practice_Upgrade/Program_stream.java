package practice_Upgrade;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// ========================================================================
// NOTE: Because this class is in the same '.java' file as 'public class Program_stream',
//       it MUST NOT have the 'public' keyword (Java allows only one 'public' class per file).
class Student_GSIT 
{
    String name;
    int marks;

    // Parameterized Constructor
    public Student_GSIT(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    // Getters & Setters (Used by Stream lambdas like 's -> s.getName()')
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}

// =========================================================================
// 2. THE MAIN DRIVER CLASS: Program_stream 
// =========================================================================
public class Program_stream {

    public static void main(String[] args) {

        // Step 1: Create Student_GSIT objects (Priyanka's exact dataset)
        Student_GSIT obj1 = new Student_GSIT("Astha", 60);
        Student_GSIT obj2 = new Student_GSIT("Chetan", 80);
        Student_GSIT obj3 = new Student_GSIT("Bhawna", 90);
        Student_GSIT obj4 = new Student_GSIT("Dhruv", 50);

        // Step 2: Store objects in an ArrayList
        List<Student_GSIT> list = new ArrayList<Student_GSIT>();
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);
        list.add(obj4);

        
        // Filters students whose names start with "A" OR "B" and collects them into a new List
        System.out.println("FILTER NAME STARTS WITH A OR B");
        List<Student_GSIT> filterList1 = list.stream()
                .filter(s -> s.getName().startsWith("A") || s.getName().startsWith("B"))
                .collect(Collectors.toList());

        for (Student_GSIT obj : filterList1) {
            System.out.println(obj.name + " :" + obj.marks);
        }

        // Step 3B: Cleaner Single-Pass Alternative (Eliminates the extra List & for-loop)
        System.out.println("\n--- Pure Stream Approach ---");
        list.stream()
            .filter(s -> s.getName().startsWith("A") || s.getName().startsWith("B"))
            .forEach(obj -> System.out.println(obj.getName() + " :" + obj.getMarks()));
        
        
     // -----------------------------------------------------------------
        // FILTER 2 (New filterList2): Filter by Marks (e.g., Marks >= 80)
        // -----------------------------------------------------------------
        // WHAT: Uses a numeric Predicate (s -> s.getMarks() >= 80) to filter high scorers.
        // WHY:  Demonstrates filtering on integer properties instead of String methods.
        System.out.println("\nFILTER MARKS >= 80");
        List<Student_GSIT> filterList2 = list.stream()
                .filter(s -> s.getMarks() >= 80)
                .collect(Collectors.toList());

        for (Student_GSIT obj : filterList2) {
            System.out.println(obj.name + " :" + obj.marks);
        }

        // -----------------------------------------------------------------
        // BONUS (Combined Filter): Name starts with A/B AND Marks > 70
        // -----------------------------------------------------------------
        System.out.println("\n---FILTER NAME (A/B) AND MARKS > 70---");
        list.stream()
            .filter(s -> (s.getName().startsWith("A") || s.getName().startsWith("B")) && s.getMarks() > 70)
            .forEach(s -> System.out.println(s.getName() + " :" + s.getMarks()));
        
        
     // =========================================================================
        // ACTIVE CODE ON SCREEN (Lines 68 - 75): SORTING BY MARKS ASCENDING
        // =========================================================================
        System.out.println("\n---SORT ON MARKS ASC---");

        list
            // 1. WHAT: .stream() converts the ArrayList into a sequential data pipeline.
            // WHY: Collections (Lists) don't have built-in functional pipeline operations; 
            // Streams allow chaining filter, map, and sort without mutating the original list.
            .stream()

            // 2. WHAT: .sorted() arranges elements in natural (ascending) order.
            // HOW: Comparator.comparingInt(...) extracts the primitive 'int' marks from each object.
            // WHAT IS '::' (Line 66 note: CLASSNAME::METHODNAME)? It is a Method Reference.
            // WHY use 'Student_GSIT::getMarks' instead of 's -> s.getMarks()'? 
            // It is cleaner shorthand syntax when a lambda simply calls an existing method.
            // WHY comparingInt() instead of comparing()? It avoids autoboxing overhead 
            // (converting primitive int to Integer wrapper objects), making numeric sorting faster.
            .sorted(Comparator.comparingInt(Student_GSIT::getMarks))

            // 3. WHAT: .forEach() is a Terminal Operation that triggers the pipeline.
            // WHEN does the sorting actually happen? ONLY when .forEach() is called (Lazy Evaluation).
            // HOW: It takes a Lambda Expression (s -> ...) to print each sorted student's name and marks.
            .forEach(s -> System.out.println(s.name + ":" + s.marks));


        // =========================================================================
        // COMMENTED CODE ON SCREEN (Lines 77 - 84): SORTING BY Marks DESCENDING
        // =========================================================================
        System.out.println("\n---SORT ON Marks DESC---");

        list
            .stream()
            .sorted(Comparator.comparing(Student_GSIT::getMarks).reversed())
            .forEach(s -> System.out.println(s.name + ":" + s.marks));
        
        System.out.println("\n---SORT ON Name DESC---");

        list
            .stream()
            // HOW: Comparator.comparing() handles Object types (like String) instead of primitives.
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
         //   - Negative result (< 0): 'a' comes BEFORE 'b' (no swap).
         //   - Positive result (> 0): 'a' comes AFTER 'b' (SWAP happens).
         //   - Zero (0): Order stays unchanged.
         // WHY .compareTo()? Strings are Objects, not numbers—you cannot use '-' or '<' on them.
         .sorted((a, b) -> a.getName().compareTo(b.getName()))

         // WHAT: Terminal operation that executes the stream and prints each sorted name.
         // WHEN: Sorting actually runs ONLY when .forEach() is reached (Lazy Evaluation).
         .forEach(s -> System.out.println(s.name));


     // =========================================================================
     // BLOCK 2: SORT ON NAME DESCENDING (Lines 94 - 98)
     // =========================================================================
     System.out.println("\nSORT COMPARATOR NAME DESC ^^^");

     list
         .stream()
         // HOW: Notice 'b' and 'a' are swapped -> b.getName().compareTo(a.getName()).
         // WHY: Flipping 'a' and 'b' reverses the positive/negative signs, forcing Z-to-A order.
         .sorted((a, b) -> b.getName().compareTo(a.getName()))
         .forEach(s -> System.out.println(s.name));


     // =========================================================================
     // BLOCK 3: SORT ON MARKS ASCENDING (Lines 100 - 104)
     // =========================================================================
     System.out.println("\nSORT COMPARATOR MARKS ASC ^^^");

     list
         .stream()
         // HOW (Explained in Priyanka's Notepad): Subtracts primitive int fields (a.marks - b.marks).
         //   - Example from Notepad: List has [10, 5] -> a = 10, b = 5.
         //   - Calculation: 10 - 5 = +5 (which is > 0).
         //   - Rule: Whenever result is > 0, Java SWAPS them -> becomes [5, 10] (Ascending).
         // WHY no getter here? She accessed 'a.marks' directly instead of 'a.getMarks()' 
         // because 'marks' is package-private in the same folder.
         .sorted((a, b) -> a.marks - b.marks)
         .forEach(s -> System.out.println(s.marks));
        
    }
}

