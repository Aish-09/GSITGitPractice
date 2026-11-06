package day1practice;

//==========================================
//PARENT CLASS
//==========================================
class ParentK {
 // Instance variable declared in the parent class
 // Subclasses will automatically inherit this field
 String country;
}

//==========================================
//CHILD CLASS (Inherits from ParentK)
//==========================================
class EmployeeK extends ParentK {
 // Instance variables specific to the EmployeeK class
 int empId;
 String empName;
 String companyName;

 // Setter method to update the employee ID
 // Demonstrates variable shadowing: the parameter -->
// -->,'empId' has the same name as the instance field 'empId'
 void setEmpId(int empId) {
     // 'this.empId' points to the current object's instance variable
     // 'empId' refers to the local parameter passed into the method
     this.empId = empId;
 }

 // Parameterized constructor to initialize instance variables at object creation
 EmployeeK(int empId, String empName, String companyName) {
     // 'this' distinguishes instance fields from constructor arguments
     this.empId = empId;
     this.empName = empName;
     this.companyName = companyName;
 }

 // Method to display details of the employee
 void print() {
     // 'this.country' accesses the field inherited directly from ParentK
     // Concatenates the values separated by colons (:)
     System.out.println(this.empId + ":" + this.empName + ":" + this.companyName + ":" + this.country);
 }
}

//==========================================
//MAIN CLASS (Execution Entry Point)
//==========================================
public class Program_This {
 public static void main(String[] args) {
     // 1. Instantiate the EmployeeK class using the 3-argument constructor
     // Sets empId = 101, empName = "Abhishek", and companyName = "Infosys"
     EmployeeK emp = new EmployeeK(101, "Abhishek", "Infosys");

     // 2. Assign a value to the inherited 'country' field from ParentK
     emp.country = "India";

     // 3. Print the object's details
     // Output: 101:Abhishek:Infosys:India
     emp.print();

     // 4. Update the empId using the setter method
     emp.setEmpId(202);

     // 5. Print the updated details
     // Output: 202:Abhishek:Infosys:India
     emp.print();
 }
}