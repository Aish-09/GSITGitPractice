package Practice_Upgrade;

import java.time.LocalDate;
import java.util.*;

// [Certain] WHAT: Employee class containing diverse data types
// WHY: Represents a real-world object with double (salary), char (grade), 
// boolean (isActive), and LocalDate (joiningDate).
class Employee {
    int id;
    String name;
    double salary;
    char grade;
    boolean isActive;
    LocalDate joiningDate;

    // WHAT: Constructor
    // WHY: Initializes all instance variables upon object creation.
    public Employee(int id, String name, double salary, char grade, boolean isActive, LocalDate joiningDate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.grade = grade;
        this.isActive = isActive;
        this.joiningDate = joiningDate;
    }
}

// -------------------------------------------------------------
// 1. COMPARATOR FOR DOUBLE / FLOAT
// -------------------------------------------------------------
// [Certain] WHAT: Comparator comparing primitive double fields
// WHY: Double.compare(e1.salary, e2.salary) prevents fractional rounding errors.
class EmployeeSalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        // Returns -1 if e1 < e2, 0 if equal, 1 if e1 > e2
        return Double.compare(e1.salary, e2.salary);
    }
}

// -------------------------------------------------------------
// 2. COMPARATOR FOR CHAR
// -------------------------------------------------------------
// [Certain] WHAT: Comparator comparing primitive char fields
// WHY: Character.compare(e1.grade, e2.grade) compares Unicode values ('A' < 'B').
class EmployeeGradeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return Character.compare(e1.grade, e2.grade);
    }
}

// -------------------------------------------------------------
// 3. COMPARATOR FOR BOOLEAN
// -------------------------------------------------------------
// [Certain] WHAT: Comparator comparing primitive boolean flags
// WHY: Boolean.compare treats 'false' as less than 'true'.
// If you want active users first, reverse the arguments: Boolean.compare(e2.isActive, e1.isActive).
class EmployeeStatusComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return Boolean.compare(e1.isActive, e2.isActive);
    }
}

// -------------------------------------------------------------
// 4. COMPARATOR FOR DATE OBJECTS
// -------------------------------------------------------------
// [Certain] WHAT: Comparator comparing LocalDate objects
// WHY: LocalDate implements Comparable<LocalDate>, so calling .compareTo() 
// sorts from oldest date to newest date.
class EmployeeJoiningDateComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.joiningDate.compareTo(e2.joiningDate);
    }
}

public class Program_MultiType_Comparator {

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<Employee>();

        list.add(new Employee(101, "Alice", 75000.50, 'B', true, LocalDate.of(2023, 5, 10)));
        list.add(new Employee(102, "Bob", 92000.75, 'A', false, LocalDate.of(2021, 1, 15)));
        list.add(new Employee(103, "Charlie", 54000.20, 'C', true, LocalDate.of(2024, 8, 20)));

        // --- SORT BY DOUBLE (Salary Ascending) ---
        Collections.sort(list, new EmployeeSalaryComparator());
        System.out.println("--- Sorted by Salary (double) ---");
        for (Employee e : list) {
            System.out.println(e.name + " : $" + e.salary);
        }

        // --- SORT BY CHAR (Grade Ascending: 'A' -> 'B' -> 'C') ---
        Collections.sort(list, new EmployeeGradeComparator());
        System.out.println("\n--- Sorted by Grade (char) ---");
        for (Employee e : list) {
            System.out.println(e.name + " : Grade " + e.grade);
        }

        // --- SORT BY DATE (Joining Date Ascending: Oldest -> Newest) ---
        Collections.sort(list, new EmployeeJoiningDateComparator());
        System.out.println("\n--- Sorted by Date ---");
        for (Employee e : list) {
            System.out.println(e.name + " : " + e.joiningDate);
        }
    }
}}
