package practice_Upgrade;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// WHAT: Blueprint representing an Employee1 with name, department, and salary fields.
// WHY: Keeps Employee1 attributes encapsulated and provides clean getters and string formatting.
// WHEN: Used as the data model for all five Stream API exercises.
// HOW: Declares private fields, a parameterized constructor, getters, and an overridden toString() method.
class Employee1 {
    private String name;
    private String department;
    private int salary;

    public Employee1(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " - " + department + " - " + salary;
    }
}

public class StreamCodingAssignment {
    public static void main(String[] args) {

        // WHAT: Creates a fixed-size List containing eight Employee1 records.
        // WHY: Supplies the input dataset required across all stream operations without manual loops.
        // WHEN: At the start of main() before running any stream pipelines.
        // HOW: Uses Arrays.asList(...) with new Employee1(...) instances.
        List<Employee1> Employee1s = Arrays.asList(
                new Employee1("Rahul", "IT", 60000),
                new Employee1("Priya", "HR", 45000),
                new Employee1("Amit", "IT", 75000),
                new Employee1("Neha", "Finance", 55000),
                new Employee1("Karan", "IT", 60000),
                new Employee1("Simran", "HR", 50000),
                new Employee1("Rohit", "Finance", 75000),
                new Employee1("Ankit", "IT", 40000)
        );

        // ==================== Question 1: Filter + forEach() ====================
        // WHAT: Filters Employee1s with salary > 50000 and prints each matching Employee1's name.
        // WHY: Isolates higher-earning Employee1s and consumes the stream to display their names.
        // WHEN: When you need to filter records and perform a terminal action on each match without collecting into a new list.
        // HOW: Employee1s.stream() -> filter(e -> e.getSalary() > 50000) -> forEach(e -> System.out.println(e.getName())).
        System.out.println("--- Question 1 ---");
        Employee1s.stream()
                .filter(e -> e.getSalary() > 50000)
                .forEach(e -> System.out.println(e.getName()));

        // ==================== Question 2: Filter + map() ====================
        // WHAT: Filters Employee1s in the "IT" department, transforms each Employee1 to its name, and prints it.
        // WHY: Extracts only the name attribute from department-matched records rather than printing full Employee1 objects.
        // WHEN: When narrowing down objects by a condition and projecting a single field from the result.
        // HOW: stream() -> filter(e -> "IT".equals(e.getDepartment())) -> map(Employee1::getName) -> forEach(System.out::println).
        System.out.println("--- Question 2 ---");
        Employee1s.stream()
                .filter(e -> "IT".equals(e.getDepartment()))
                .map(Employee1::getName)
                .forEach(System.out::println);

        // ==================== Question 3: sorted() ====================
        // WHAT: Sorts all Employee1s by salary in ascending order and prints "name - salary" for each.
        // WHY: Orders records numerically by salary without mutating the original Employee1s list.
        // WHEN: When custom or field-based ordering is needed on a stream of objects.
        // HOW: stream() -> sorted(Comparator.comparingInt(Employee1::getSalary)) -> forEach(e -> System.out.println(e.getName() + " - " + e.getSalary())).
        System.out.println("--- Question 3 ---");
        Employee1s.stream()
                .sorted(Comparator.comparingInt(Employee1::getSalary))
                .forEach(e -> System.out.println(e.getName() + " - " + e.getSalary()));

        // ==================== Question 4: map() + distinct() + sorted() ====================
        // WHAT: Extracts all salaries, removes duplicates, sorts them in ascending order, and prints each salary.
        // WHY: Produces a clean, unique, ordered list of salary tiers present in the organization.
        // WHEN: When you need unique sorted values derived from a property of stream elements.
        // HOW: stream() -> map(Employee1::getSalary) -> distinct() -> sorted() -> forEach(System.out::println).
        System.out.println("--- Question 4 ---");
        Employee1s.stream()
                .map(Employee1::getSalary)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        // ==================== Question 5: filter() + map() + distinct() + sorted() ====================
        // WHAT: Filters Employee1s with salary >= 50000, maps to department, removes duplicate departments, and prints them alphabetically.
        // WHY: Identifies distinct departments that have at least one Employee1 earning 50,000 or more, in A-Z order.
        // WHEN: When combining filtering, field projection, deduplication, and natural sorting in one pipeline.
        // HOW: stream() -> filter(e -> e.getSalary() >= 50000) -> map(Employee1::getDepartment) -> distinct() -> sorted() -> forEach(System.out::println).
        System.out.println("--- Question 5 ---");
        Employee1s.stream()
                .filter(e -> e.getSalary() >= 50000)
                .map(Employee1::getDepartment)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }
}
