package day1practice;

public class RightAngledTriangle {

    public static void main(String[] args) {
        int rows = 5;

        // Outer loop controls each row (1 to 5)
        for (int i = 1; i <= rows; i++) {

            // Inner Loop 1: Prints decreasing leading spaces
            for (int j = 1; j <= rows - i; j++) {
                System.out.print("  "); // 2 spaces to align with "* "
            }

            // Inner Loop 2: Prints increasing stars
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }

            // Move to the next line
            System.out.println();
        }
    }
}