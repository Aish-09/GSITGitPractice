package practice_Upgrade;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ============================================================================
 * 1. WHAT IS THIS CODE FOR?
 * ============================================================================
 * This program demonstrates Java Exception Handling across both:
 *   - Runtime (Unchecked) Exceptions: ArithmeticException, ArrayIndexOutOfBoundsException, NullPointerException
 *   - Compile-Time (Checked) Exceptions: FileNotFoundException, InterruptedException, SQLException
 *   - Multiple Catch Blocks: Handling specific exceptions first, followed by a generic Exception fallback.
 *
 * ============================================================================
 * 2. WHY IS THIS USED?
 * ============================================================================
 * - Prevents Single-Point Failure: Without try-catch, the first runtime error crashes the JVM
 *   and skips every remaining test or instruction below it.
 * - Clean Error Diagnostics: Using ex.getMessage() extracts the exact failure reason
 *   without halting execution.
 * - Resource Safety: Ensures files, database connections, and browser sessions can be closed cleanly.
 *
 * ============================================================================
 * 3. HOW IS THIS USED?
 * ============================================================================
 * - try { ... }   : Wraps risky statements that may fail during execution.
 * - catch (...)   : Catches specific exception objects (always order child exceptions BEFORE parent Exception).
 * - finally { ...}: Optional cleanup block that always runs whether an exception occurred or not.
 *
 * ============================================================================
 * 4. WHERE IS THIS USED IN REAL-WORLD QA AUTOMATION?
 * ============================================================================
 * - Test Data Readers (FileNotFoundException): Reading Excel/CSV/properties files that may be missing.
 * - Dynamic Web Tables & APIs (ArrayIndexOutOfBounds / NullPointer): Accessing list items or null JSON fields.
 * - Database Assertions (SQLException): Validating backend records when DB credentials or connections fail.
 * - Custom Waits (InterruptedException): Handling Thread.sleep() or polling intervals in Selenium/Playwright.
 * ============================================================================
 */
public class Program_AllExceptionTypes {

	public static void main(String[] args) {

		System.out.println("=== 1. RUNTIME (UNCHECKED) EXCEPTIONS ===");

		// 1A. ArithmeticException
		// WHERE USED: Calculating dynamic pagination counts, discounts, or test metrics where divisor can be 0.
		try {
			int num = 10 / 0;
		} catch (ArithmeticException ex) {
			System.out.println("ArithmeticException caught: " + ex.getMessage());
		}

		// 1B. ArrayIndexOutOfBoundsException
		// WHERE USED: Reading dynamic web table rows or API response arrays when fewer elements return than expected.
		try {
			int[] arr = { 10, 20, 30 };
			System.out.println(arr[10]); // Fails because valid indexes are 0, 1, 2
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("ArrayIndexOutOfBoundsException caught: " + ex.getMessage());
		}

		// 1C. NullPointerException
		// WHERE USED: Calling methods on uninitialized Page Objects, WebElements, or null API JSON fields.
		try {
			String text = null;
			System.out.println(text.length());
		} catch (NullPointerException ex) {
			System.out.println("NullPointerException caught: " + ex.getMessage());
		}

		System.out.println("\n=== 2. MULTIPLE CATCH BLOCKS (Specific -> Generic) ===");
		// HOW IT WORKS: Always place specific child exceptions (ArithmeticException) BEFORE generic parent (Exception),
		// otherwise Java throws a compile-time "Unreachable catch block" error.
		try {
			System.out.println("hello");
			int num = 10 / 0;
			System.out.println("bye"); // Skipped because line above throws ArithmeticException
		} catch (ArithmeticException ex) {
			System.out.println("Specific Catch -> Exception is: " + ex.getMessage());
		} catch (Exception ex) {
			System.out.println("Generic Fallback Catch -> " + ex.getMessage());
		}

		System.out.println("\n=== 3. COMPILE-TIME (CHECKED) EXCEPTIONS ===");

		// 3A. FileNotFoundException (File I/O)
		// WHERE USED: Loading config.properties or Apache POI Excel test data sheets.
		try {
			File file = new File("C:\\non_existent_file.txt");
			FileReader fr = new FileReader(file);
		} catch (FileNotFoundException ex) {
			System.out.println("FileNotFoundException caught: " + ex.getMessage());
		}

		// 3B. InterruptedException (Thread)
		// WHERE USED: Handling thread interruptions during explicit waits or Thread.sleep() debugging.
		try {
			System.out.println("Pausing thread for 1 second...");
			Thread.sleep(1000);
			System.out.println("Thread resumed cleanly.");
		} catch (InterruptedException ex) {
			System.out.println("InterruptedException caught: " + ex.getMessage());
		}

		// 3C. SQLException (Database)
		// WHERE USED: Connecting to PostgreSQL/MySQL via JDBC to verify backend data against UI results.
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/invalidDB", "root", "wrongpass");
		} catch (SQLException ex) {
			System.out.println("SQLException caught: " + ex.getMessage());
		}

		System.out.println("\n=== Program Completed Smoothly ===");
	}
}