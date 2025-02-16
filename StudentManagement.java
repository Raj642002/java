package one;
import java.util.Scanner;
class Student {
    String name;
    int marks;
    int rollNo;

    // Method to input student details
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student name: ");
        name = sc.nextLine();
        System.out.print("Enter student roll number: ");
        rollNo = sc.nextInt();
        System.out.print("Enter student marks: ");
        marks = sc.nextInt();
    }

    // Method to output student details
    public void output() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNo);
        System.out.println("Marks: " + marks);
    }

    // Method to update student marks
    public void updateMarks() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter new marks for " + name + ": ");
        marks = sc.nextInt();
    }

    // Method to search student by name
    public boolean searchByName(String searchName) {
        return name.equalsIgnoreCase(searchName);
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[10]; // Array to store up to 10 students
        int studentCount = 0;
        boolean exit = false;

        while (!exit) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View Student Details");
            System.out.println("3. Search Student by Name");
            System.out.println("4. Update Marks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (studentCount < students.length) {
                        students[studentCount] = new Student();
                        students[studentCount].input();
                        studentCount++;
                    } else {
                        System.out.println("Cannot add more students. Array is full.");
                    }
                    break;
                case 2:
                    if (studentCount > 0) {
                        for (int i = 0; i < studentCount; i++) {
                            students[i].output();
                        }
                    } else {
                        System.out.println("No students added yet.");
                    }
                    break;
                case 3:
                    System.out.print("Enter student name to search: ");
                    sc.nextLine(); // Consume leftover newline character
                    String searchName = sc.nextLine();
                    boolean found = false;
                    for (int i = 0; i < studentCount; i++) {
                        if (students[i].searchByName(searchName)) {
                            students[i].output();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student with name " + searchName + " not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter student name to update marks: ");
                    sc.nextLine(); // Consume leftover newline character
                    String updateName = sc.nextLine();
                    boolean updated = false;
                    for (int i = 0; i < studentCount; i++) {
                        if (students[i].searchByName(updateName)) {
                            students[i].updateMarks();
                            updated = true;
                            break;
                        }
                    }
                    if (!updated) {
                        System.out.println("Student with name " + updateName + " not found.");
                    }
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

