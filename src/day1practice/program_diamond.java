package day1practice;

public class program_diamond {

	public static void main(String[] args) {
        int n = 5; // Height of the upper pyramid

        // -------------------------------------------------------------
        // PART 1: Upper Half of the Diamond
        // -------------------------------------------------------------
        for (int i = 1; i <= n; i++) {
            // Print leading spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // Print stars with a trailing space
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // -------------------------------------------------------------
        // PART 2: Lower Half of the Diamond
        // -------------------------------------------------------------
        for (int i = n - 1; i >= 1; i--) {
            // Print leading spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // Print stars with a trailing space
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

}
