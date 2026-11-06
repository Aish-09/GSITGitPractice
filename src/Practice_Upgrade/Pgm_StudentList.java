package Practice_Upgrade;

import java.util.*;

// Student Class definition
class Student {
    private int rollno;
    private String name;

    // Constructor
    public Student(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

    // Method to display individual details
    public void display() {
        System.out.println(this.rollno + " : " + this.name);
    }

    // Getters
    public int getRollno() {
        return rollno;
    }

    public String getName() {
        return name;
    }

    // Overriding toString for clean printing inside collections
    @Override
    public String toString() {
        return "Student[rollno=" + rollno + ", name=" + name + "]";
    }
}

public class Pgm_StudentList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Student> studentList = new ArrayList<>();

        // 2. Add function (list.add())
        studentList.add(new Student(101, "Rajat"));
        studentList.add(new Student(102, "Rohan"));
        studentList.add(new Student(103, "Shreya"));

        // 3. Size function (list.size())
        System.out.println("Total Students: " + studentList.size());
        
        System.out.println("\nIterating through full student list:");
        for (Student s : studentList) {
            s.display();
        }

	}

}
