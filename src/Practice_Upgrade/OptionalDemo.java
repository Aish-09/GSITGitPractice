package practice_Upgrade;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {

        // =========================================================================
        // 1. WHAT & WHY: Creating an Optional Container
        // =========================================================================
        // WHAT: Optional<T> is a container box introduced in Java 8 that may or may not hold a non-null value.
        // WHY does it exist? To eliminate NullPointerException (NPE) crashes by forcing you 
        // to explicitly handle the "value is missing" case before using the data.

        // HOW to create an Optional when data might be null (e.g., from a database or Stream .reduce()):
        String rawName = null; 
        Optional<String> safeName = Optional.ofNullable(rawName); // Safely wraps null into Optional.empty()

        // NOTE: Never use Optional.of(null) — it immediately throws a NullPointerException!


        // =========================================================================
        // 2. WHEN & HOW: Safely Checking and Extracting Values (Replacing blind .get())
        // =========================================================================
        
        // BAD PRACTICE (What Priyanka did on line 149):
        // Calling safeName.get() directly without checking throws 'NoSuchElementException' if empty!

        // GOOD PRACTICE A — Check first with .isPresent() (Mentioned on line 81 of Optional.class):
        // WHEN to use: When you only want to run code if a value actually exists.
        if (safeName.isPresent()) {
            System.out.println("Found: " + safeName.get());
        } else {
            System.out.println("No name found!");
        }

        // GOOD PRACTICE B — Provide a fallback with .orElse() (Most common in real projects):
        // HOW: Unwraps the value if present; otherwise returns your default fallback value ("Guest").
        String finalName = safeName.orElse("Guest"); 
        System.out.println(finalName); // Prints: Guest

        // GOOD PRACTICE C — Functional style with .ifPresent():
        // HOW: Runs a lambda expression ONLY if a value is inside the box; does nothing if empty.
        Optional<Integer> totalMarks = Optional.of(270);
        totalMarks.ifPresent(marks -> System.out.println("Total Marks: " + marks));
    }
}