
package university;

import university.model.Student;
import university.linkedlist.StudentLinkedList;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static StudentLinkedList studentList = new StudentLinkedList();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n=================================");
            System.out.println(" UNIVERSITY STUDENT RECORD SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Student Record");
            System.out.println("2. Update Student Record");
            System.out.println("3. Delete Student Record");
            System.out.println("4. Display All Records");
            System.out.println("5. Add Service Request");
            System.out.println("6. Process Next Service Request");
            System.out.println("7. Display Recent Actions");
            System.out.println("8. Display Students using BST");
            System.out.println("9. Search Student using Hashing");
            System.out.println("10. Add Campus Location");
            System.out.println("11. Remove Campus Location");
            System.out.println("12. Add Campus Connection");
            System.out.println("13. Remove Campus Connection");
            System.out.println("14. Display Campus Connections");
            System.out.println("15. Traverse Campus using BFS");
            System.out.println("16. Exit");
            System.out.print("Enter choice: ");

            choice = readInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    updateStudent();
                    break;

                case 3:
                    deleteStudent();
                    break;

                case 4:
                    studentList.displayStudents();
                    break;

                case 5:
                    System.out.println("Service Queue is not connected yet.");
                    break;

                case 6:
                    System.out.println("Service Queue is not connected yet.");
                    break;

                case 7:
                    System.out.println("Action Stack is not connected yet.");
                    break;

                case 8:
                    System.out.println("Student BST is not connected yet.");
                    break;

                case 9:
                    searchStudent();
                    break;

                case 10:
                    System.out.println("Campus Graph is not connected yet.");
                    break;

                case 11:
                    System.out.println("Campus Graph is not connected yet.");
                    break;

                case 12:
                    System.out.println("Campus Graph is not connected yet.");
                    break;

                case 13:
                    System.out.println("Campus Graph is not connected yet.");
                    break;

                case 14:
                    System.out.println("Campus Graph is not connected yet.");
                    break;

                case 15:
                    System.out.println("Campus Graph is not connected yet.");
                    break;

                case 16:
                    System.out.println("System closed.");
                    break;

                default:
                    System.out.println("Invalid choice. Enter 1-16.");
            }

        } while (choice != 16);

        scanner.close();
    }

    static void addStudent() {

        System.out.print("Enter Student ID: ");
        int id = readInt();

        if (studentList.searchStudent(id) != null) {
            System.out.println("Error: Student ID already exists.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Programme: ");
        String programme = scanner.nextLine().trim();

        if (name.isEmpty() || programme.isEmpty()) {
            System.out.println("Name and programme cannot be empty.");
            return;
        }

        System.out.print("Enter Marks (0-100): ");
        double marks = readDouble();

        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks. Enter a value from 0 to 100.");
            return;
        }

        Student student = new Student(id, name, programme, marks);

        if (studentList.addStudent(student)) {
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Error: Student ID already exists.");
        }
    }

    static void updateStudent() {

        System.out.print("Enter Student ID to update: ");
        int id = readInt();

        Student existing = studentList.searchStudent(id);

        if (existing == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter new name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter new programme: ");
        String programme = scanner.nextLine().trim();

        if (name.isEmpty() || programme.isEmpty()) {
            System.out.println("Name and programme cannot be empty.");
            return;
        }

        System.out.print("Enter new marks (0-100): ");
        double marks = readDouble();

        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks. Enter a value from 0 to 100.");
            return;
        }

        if (studentList.updateStudent(id, name, programme, marks)) {
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Unable to update student.");
        }
    }

    static void deleteStudent() {

        System.out.print("Enter Student ID to delete: ");
        int id = readInt();

        if (studentList.deleteStudent(id)) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    static void searchStudent() {

        System.out.print("Enter Student ID to search: ");
        int id = readInt();

        Student student = studentList.searchStudent(id);

        if (student != null) {
            System.out.println("Student found:");
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    static int readInt() {

        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a whole number: ");
            }
        }
    }

    static double readDouble() {

        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a number: ");
            }
        }
    }
}