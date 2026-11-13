package practice_Upgrade;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * SCENARIO A: Broken implementation (Missing hashCode/equals overrides)
 * WHAT: Standard class without overriding Object methods.
 * WHY IT FAILS: Default hashCode() uses heap memory addresses.
 */
class StudentWithoutContract {
    private int rollno;
    private String name;

    public StudentWithoutContract(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student[rollno=" + rollno + ", name=" + name + "]";
    }
}

/**
 * SCENARIO B: Correct implementation (Adhering to equals/hashCode contract)
 * WHAT: Overrides both methods based on business fields.
 * HOW: Guarantees that equal fields generate identical bucket indices.
 */
class StudentWithContract {
    private int rollno;
    private String name;

    public StudentWithContract(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        // Fast path: memory reference check
        if (this == obj) return true;
        // Type and null validation
        if (obj == null || getClass() != obj.getClass()) return false;
        
        StudentWithContract other = (StudentWithContract) obj;
        return rollno == other.rollno && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        // Maps fields to a predictable integer bucket
        return Objects.hash(rollno, name);
    }

    @Override
    public String toString() {
        return "Student[rollno=" + rollno + ", name=" + name + "]";
    }
}

/**
 * Driver class demonstrating HashSet deduplication mechanics.
 */
public class HashSetDeepDive {

    public static void main(String[] args) {

        // =========================================================================
        // CASE 1: The Failure Case (Default Object behavior)
        // =========================================================================
        System.out.println("=== CASE 1: HashSet WITHOUT Overriding hashCode/equals ===");
        
        StudentWithoutContract broken1 = new StudentWithoutContract(1, "Rajat");
        StudentWithoutContract broken2 = new StudentWithoutContract(1, "Rajat");

        Set<StudentWithoutContract> brokenSet = new HashSet<>();
        brokenSet.add(broken1);
        brokenSet.add(broken2); // HashSet allows this because hash codes don't match!

        System.out.println("broken1 hashCode : " + broken1.hashCode());
        System.out.println("broken2 hashCode : " + broken2.hashCode());
        System.out.println("Set size (Expected: 1, Actual: " + brokenSet.size() + ")"); 
        System.out.println("Set contents     : " + brokenSet);
        // Result: Size is 2. Duplicate data leaked into the set.

        System.out.println("\n------------------------------------------------------------\n");

        // =========================================================================
        // CASE 2: The Working Case (Contract Fulfilled)
        // =========================================================================
        System.out.println("=== CASE 2: HashSet WITH Overriding hashCode/equals ===");
        
        StudentWithContract correct1 = new StudentWithContract(1, "Rajat");
        StudentWithContract correct2 = new StudentWithContract(1, "Rajat");

        Set<StudentWithContract> correctSet = new HashSet<>();
        correctSet.add(correct1);
        correctSet.add(correct2); // Step 1: Same hash bucket. Step 2: equals() returns true -> REJECTED.

        System.out.println("correct1 hashCode: " + correct1.hashCode());
        System.out.println("correct2 hashCode: " + correct2.hashCode());
        System.out.println("Set size (Expected: 1, Actual: " + correctSet.size() + ")");
        System.out.println("Set contents     : " + correctSet);
        // Result: Size is 1. Duplicate properly blocked.

        System.out.println("\n------------------------------------------------------------\n");

        // =========================================================================
        // CASE 3: String Hash Collision in HashSet
        // =========================================================================
        System.out.println("=== CASE 3: String Hash Collision (\"Aa\" and \"BB\") ===");
        // str1 and str2 produce the exact same hashCode (2112), landing in the same bucket.
        // But because "Aa".equals("BB") is false, BOTH are retained in that bucket's linked chain.
        Set<String> stringSet = new HashSet<>();
        stringSet.add("Aa");
        stringSet.add("BB");

        System.out.println("stringSet size (Collision resolved by equals): " + stringSet.size());
        System.out.println("stringSet contents: " + stringSet);
    }
}