package Practice_Upgrade;

import java.util.*;

// [Certain] WHAT: Plain Old Java Object (POJO) class representing a Student.
// WHY: Holds student state (marks and name). Notice it does NOT implement Comparable; 
// it remains clean and decoupled from sorting rules.
class Student_3 {
    int marks;
    String name;

    // WHAT: Constructor
    // WHY: Assigns the initial values to instance fields when a new Student_3 is created.
    public Student_3(int marks, String name) {
        this.marks = marks;
        this.name = name;
    }
}

// [Certain] WHAT: class StudentNameComparator implements Comparator<Student_3>
// WHY: Defines an external sorting strategy specifically for Student_3 objects based on their names.
class StudentNameComparator implements Comparator<Student_3> {

    // [Certain] WHAT: compare(Student_3 obj1, Student_3 obj2)
    // WHY: Provides the comparison contract required by Comparator.
    // HOW IT WORKS: Delegates to String's compareTo to arrange names alphabetically (A -> Z).
    @Override
    public int compare(Student_3 obj1, Student_3 obj2) {
        return obj1.name.compareTo(obj2.name);
    }
}

public class Program_Comparator {

    // WHAT: main method
    // WHY: Entry point for the JVM to run the program.
    public static void main(String[] args) {

        // Instantiating Student_3 objects with marks and names
        Student_3 obj1 = new Student_3(90, "John");
        Student_3 obj2 = new Student_3(95, "Alex");
        Student_3 obj3 = new Student_3(80, "Cristopher");

        // WHAT: List<Student_3> list = new ArrayList<Student_3>();
        // WHY: Holds the collection of Student_3 objects dynamically.
        List<Student_3> list = new ArrayList<Student_3>();

        // Adding elements to the list
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);

        // [Certain] WHAT: Collections.sort(list, new StudentNameComparator())
        // WHY: Reorders the list elements using the logic defined in StudentNameComparator.
        // It passes pairs of objects to compare(obj1, obj2) to sort them alphabetically by name.
        Collections.sort(list, new StudentNameComparator());

        // WHAT: Enhanced for-loop (for-each)
        // WHY: Iterates through each sorted Student_3 element without index management.
        for (Student_3 obj : list) {
            // WHAT: System.out.println
            // WHY: Prints marks and name separated by a colon to standard output.
            System.out.println(obj.marks + ":" + obj.name);
        }
    }
}

/* @formatter:off
 * +------------------------+------------------------------------------------+-----------------------------------------------------+
 * | Feature                | Comparable<T>                                  | Comparator<T>                                       |
 * +========================+================================================+=====================================================+
 * | Package                | java.lang (default, no import needed)          | java.util (must import java.util.Comparator)        |
 * +------------------------+------------------------------------------------+-----------------------------------------------------+
 * | Abstract Method        | int compareTo(T obj)                           | int compare(T obj1, T obj2)                         |
 * +------------------------+------------------------------------------------+-----------------------------------------------------+
 * | Target Object          | Compares 'this' instance against another obj   | Compares two distinct objects (obj1 vs obj2)        |
 * +------------------------+------------------------------------------------+-----------------------------------------------------+
 * | Modification Needed    | Yes: entity must implement Comparable          | No: entity untouched; logic lives externally        |
 * +------------------------+------------------------------------------------+-----------------------------------------------------+
 * | Sort Sequences         | Single: defines default "natural" ordering     | Multiple: custom lambdas/classes per field          |
 * +------------------------+------------------------------------------------+-----------------------------------------------------+
 * | Invocation             | Collections.sort(list)                         | Collections.sort(list, comparator)                  |
 * +------------------------+------------------------------------------------+-----------------------------------------------------+
 * | QA Automation Use Case | Default ordering of test steps by priority     | Sorting dynamic UI tables across multiple columns   |
 * +------------------------+------------------------------------------------+-----------------------------------------------------+
 * @formatter:on */