package practice_Upgrade;

/**
 * ============================================================================
 * 1. WHAT IS THIS CODE FOR?
 * ============================================================================
 * This program demonstrates the complete Java Exception Handling lifecycle:
 *   - try block             : Executes risky operations (division and array indexing).
 *   - Multiple catch blocks : Catches specific child exceptions first (ArithmeticException,
 *                             ArrayIndexOutOfBoundsException) before falling back to the
 *                             generic parent (Exception).
 *   - finally block         : Guarantees execution of critical cleanup code regardless
 *                             of whether an exception occurred or was caught.
 *
 * ============================================================================
 * 2. WHY IS THIS USED?
 * ============================================================================
 * - Precise Error Routing : Different failures need different recovery actions (e.g., logging
 *                           a math error vs. handling missing test data).
 * - Guaranteed Cleanup    : Without a finally block, any code written after a failing line
 *                           inside 'try' is skipped—leaving browsers, files, or DB connections
 *                           open in memory.
 *
 * ============================================================================
 * 3. HOW IS THIS USED?
 * ============================================================================
 * - Specific-to-Generic Rule : Child exception classes MUST be caught BEFORE the parent
 *                              'Exception' class, or Java fails to compile ("Unreachable catch block").
 * - Execution Guarantee      : The 'finally' block runs 100% of the time after 'try' or 'catch'
 *                              finishes (unless System.exit(0) kills the JVM).
 *
 * ============================================================================
 * 4. WHERE IS THIS USED IN REAL-WORLD QA AUTOMATION?
 * ============================================================================
 * - WebDriver / Playwright Teardown : Closing browser instances (driver.quit() / browser.close())
 *                                     inside 'finally' even when an assertion fails mid-test.
 * - Database & API Testing          : Closing JDBC connections or file streams after querying
 *                                     PostgreSQL/MySQL or reading Excel test data sheets.
 * - Dynamic Web Table Scraping      : Catching ArrayIndexOutOfBoundsException when a table
 *                                     returns fewer rows than expected without aborting the suite.
 * ============================================================================
 */
public class Program_MultipleCatchWithFinally {

	public static void main(String[] args) {

		try {
			System.out.println("hello");

			// Scenario A: Uncomment the line below to trigger ArithmeticException (1st catch block)
			//int num = 10 / 0;
		
			//Scenario C: To Catch other expection like null point expection
			int num = (Integer) null;

			// Scenario B: Active right now -> triggers ArrayIndexOutOfBoundsException (2nd catch block)
			int arr[] = { 10, 20, 30 };
			System.out.println(arr[0]); // Valid indexes are only 0, 1, 2

			// This line is ALWAYS skipped if any exception occurs above it
			System.out.println("bye inside try");

		} catch (ArithmeticException ex) {
			// 1st Specific Catch: Runs ONLY if a divide-by-zero error occurs
			System.out.println("ArithmeticException caught: " + ex.getMessage());

		} catch (ArrayIndexOutOfBoundsException ex) {
			// 2nd Specific Catch: Runs ONLY if an invalid array index is accessed
			System.out.println("ArrayIndexOutOfBoundsException caught: " + ex.getMessage());

		} catch (Exception ex) {
			// 3rd Generic Fallback Catch: Catches any other unexpected exception (e.g., NullPointerException)
			System.out.println("Other exception caught: " + ex.getMessage());

		} finally {
			// Cleanup Block: Executes ALWAYS (whether an exception happened or not)
			System.out.println("finally block executed: Closing browser / DB resources safely.");
		}

		System.out.println("Program finished cleanly.");
	}
}