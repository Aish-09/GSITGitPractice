package practice_Upgrade;

import java.util.*;

// [Certain] WHAT: Student3 POJO class
// WHY: Defines the structure for student records.
// ISSUE: Because equals() and hashCode() are NOT overridden, 
// two objects with the exact same field values are treated as distinct entities.
class Student3
{
    int rollNo;
    String name;

    // WHAT: Parameterized Constructor
    // WHY: Initializes the fields of the object upon instantiation.
    Student3(int rollNo, String name)
    {
        this.rollNo = rollNo;
        this.name = name;
    }
}

public class Program_setduplicate {

    // WHAT: main method
    // WHY: Entry point where JVM starts program execution.
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // WHAT: Set<Student3> set = new HashSet<Student3>();
        // WHY: Creates an unordered collection backed by a hash table that rejects duplicate items.
        Set<Student3> set = new HashSet<Student3>();

        // Creating two distinct object instances with identical field values
        Student3 obj1 = new Student3(1, "A");
        Student3 obj2 = new Student3(1, "A");

        // [Certain] WHAT: set.add(obj)
        // WHY: Inserts elements into the set.
        // Even though fields match, default Object.equals() compares memory addresses (obj1 != obj2),
        // so BOTH objects are added to the HashSet.
        set.add(obj1);
        set.add(obj2);

        // WHAT: Enhanced for-loop
        // WHY: Iterates through each Student3 instance stored in the Set.
        for (Student3 obj : set)
        {
            // Prints the student details; will print '1:A' twice on the console
            System.out.println(obj.rollNo + ":" + obj.name);
        }
    }
}
