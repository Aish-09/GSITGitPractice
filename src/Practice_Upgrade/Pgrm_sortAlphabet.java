package Practice_Upgrade;

import java.util.*;

// [Certain] WHAT: class Student_2 implements Comparable<Student_2>
// WHY: Informs Java that Student_2 instances have a natural sort order.
class Student_2 implements Comparable<Student_2> {
    int marks;
    String name;

    // WHAT: Constructor
    // WHY: Initializes the fields of Student_2 during instantiation.
    public Student_2(int marks, String name) {
        this.marks = marks;
        this.name = name;
    }

    // [Certain] WHAT: Overriding compareTo(Student_2 obj)
    // WHY: Defines the sorting logic. Instead of marks, we delegate comparison 
    // to Java's built-in String.compareTo() method.
    @Override
    public int compareTo(Student_2 obj) {
        // [Certain] Sorts ascending (alphabetical: A -> B -> C):
        return this.name.compareTo(obj.name);

        // If you needed case-insensitive sorting (e.g., 'a' and 'A' treated equally):
        // return this.name.compareToIgnoreCase(obj.name);

        // If you needed descending order (Z -> A):
        // return obj.name.compareTo(this.name);
    }
}

public class Pgrm_sortAlphabet {

    public static void main(String[] args) {
        // Creating student objects with different names and marks
        Student_2 obj1 = new Student_2(90, "John");
        Student_2 obj2 = new Student_2(95, "Alex");
        Student_2 obj3 = new Student_2(80, "Chris");

        // Declaring a dynamic list to hold Student_2 objects
        List<Student_2> list = new ArrayList<Student_2>();

        // Adding objects in original order: John, Alex, Chris
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);

        // [Certain] WHAT: Collections.sort(list)
        // WHY: Sorts the list in-place using Student_2's compareTo() method.
        // It compares names: "Alex" comes before "Chris", which comes before "John".
        Collections.sort(list);

        // Traversing and printing the alphabetically sorted results
        for (Student_2 obj : list) {
            // Output format: marks:name
            System.out.println(obj.marks + ":" + obj.name);
        }
    }
}