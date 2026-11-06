package Practice_Upgrade;

import java.util.*;

// [Certain] WHAT: "implements Comparable<Student_1>"
// WHY: Tells Java that Student_1 objects can be compared against each other 
// and sorted in a List without causing a ClassCastException at runtime.
class Student_1 implements Comparable<Student_1> {
    
    // Instance variables: fields holding the data for each student
    int marks;
    String name;

    // WHAT: Constructor
    // WHY: Initializes the object's fields when you write 'new Student_1(...)'.
    public Student_1(int marks, String name) {
        this.marks = marks;
        this.name = name;
    }

    // [Certain] WHAT: Overriding compareTo(Student_1 obj)
    // WHY: Provides the concrete sorting logic required by the Comparable interface.
    // HOW IT WORKS:
    // If this.marks = 80 and obj.marks = 90 -> returns -10 (negative -> stays before 90).
    // If this.marks = 95 and obj.marks = 90 -> returns 5 (positive -> moves after 90).
    @Override
    public int compareTo(Student_1 obj) {
        return this.marks - obj.marks; 
    }
}

public class Program_sort {

    // WHAT: main method
    // WHY: The entry point where the Java Virtual Machine (JVM) starts executing code.
    public static void main(String[] args) {
        
        // Creating three independent Student_1 objects in memory
        Student_1 obj1 = new Student_1(90, "A");
        Student_1 obj2 = new Student_1(95, "B");
        Student_1 obj3 = new Student_1(80, "C");

        // WHAT: List<Student_1> list = new ArrayList<Student_1>();
        // WHY: An ArrayList provides a resizable, ordered collection.
        // We use the List interface as the reference type for loose coupling.
        List<Student_1> list = new ArrayList<Student_1>();

        // Adding student objects into the list in arrival order: [90, 95, 80]
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);

        // [Certain] WHAT: Collections.sort(list)
        // WHY: Reorders the list elements in place using TimSort.
        // It relies directly on Student_1's compareTo() method to figure out 
        // that 80 < 90 < 95.
        Collections.sort(list);

        // WHAT: Enhanced for-loop (for-each)
        // WHY: Iterates through each element sequentially from index 0 to size-1 
        // without needing a manual loop counter (int i = 0).
        for (Student_1 obj : list) {
            // WHAT: System.out.println()
            // WHY: Prints data to standard output with an automatic newline at the end.
            System.out.println(obj.marks + ":" + obj.name);
        }
    }
}
