package practice_Upgrade;

/**
 * ============================================================================
 * 1. WHAT IS THIS CODE FOR?
 * ============================================================================
 * This program demonstrates the Java 'throw' keyword:
 *   - Explicitly creating and throwing an exception object manually based on
 *     custom business logic (e.g., validating age < 18), rather than waiting
 *     for the JVM to fail automatically (like 10 / 0).
 *
 * ============================================================================
 * 2. WHY IS THIS USED?
 * ============================================================================
 * - Enforcing Business Rules : Java does not consider "age = 15" a technical error,
 *                              so 'throw' lets you force a failure when application
 *                              rules or test assertions are violated.
 * - Fail-Fast Execution      : Stops invalid data from proceeding further into
 *                              downstream methods, database writes, or checkout flows.
 *
 * ============================================================================
 * 3. HOW IS THIS USED?
 * ============================================================================
 * - Syntax : throw new ExceptionClassName("Custom error message");
 * - Placement : Written INSIDE a method body (unlike 'throws', which goes in the
 *               method signature).
 * - Single Instance : 'throw' can only throw ONE exception object at a time.
 *
 * ============================================================================
 * 4. WHERE IS THIS USED IN REAL-WORLD QA AUTOMATION?
 * ============================================================================
 * - Custom Framework Assertions : Throwing an AssertionError or RuntimeException when
 *                                 an API status code != 200 or UI text mismatches.
 * - Environment / Config Guards : Throwing IllegalArgumentException at test startup if
 *                                 an unsupported browser name (e.g., "safari12") is passed.
 * - Banking / E-Commerce Tests  : Validating negative withdrawal amounts, underage user
 *                                 registrations, or out-of-stock order quantities.
 * ============================================================================
 */
public class Program_throw {

	// Static helper method so main() can call it directly without creating an object
	public static void checkAge(int age) {
		if (age < 18) {
			// Explicitly raising an exception with a custom message
			throw new ArithmeticException("\nAccess denied - You must be at least 18 years old. \nYour Age now = " + age);
		} else {
			System.out.println("\nAccess granted - You are eligible to vote! Age = " + age);
		}
	}

	public static void main(String[] args) {

		// Option 1: Calling without try-catch (crashes the program with your custom message)
		// checkAge(15);

		// Option 2: Wrapping in try-catch so the program handles the custom exception cleanly
		try {
			checkAge(17); // Triggers the 'throw' statement inside checkAge()
		} catch (ArithmeticException ex) {
			System.out.println("Custom Exception Caught: " + ex.getMessage());
		}

		// Valid case check
		checkAge(22);
	}
}