package day1practice;

import java.util.Scanner;

public class Program_Switch1 {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner sc = new Scanner(System.in);

        // Prompt the user for input
        System.out.print("Enter day number (1-7): ");
        int day = sc.nextInt();

        // Switch statement to match the input day
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Non expected input");
                break;
        }

        // Close the scanner resource
        sc.close();
    }
}