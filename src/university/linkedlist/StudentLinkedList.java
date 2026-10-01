package university.linkedlist;

import university.model.Student;

public class StudentLinkedList {

    private static class Node {
        Student data;
        Node next;

        Node(Student data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public boolean addStudent(Student student) {

        if (searchStudent(student.getStudentId()) != null) {
            return false;
        }

        Node newNode = new Node(student);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        size++;
        return true;
    }

    public Student searchStudent(int studentId) {

        Node current = head;

        while (current != null) {

            if (current.data.getStudentId() == studentId) {
                return current.data;
            }

            current = current.next;
        }

        return null;
    }

    public boolean updateStudent(
            int studentId,
            String name,
            String programme,
            double marks) {

        Student student = searchStudent(studentId);

        if (student == null) {
            return false;
        }

        student.setName(name);
        student.setProgramme(programme);
        student.setMarks(marks);

        return true;
    }

    public boolean deleteStudent(int studentId) {

        if (head == null) {
            return false;
        }

        if (head.data.getStudentId() == studentId) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.data.getStudentId() == studentId) {
                current.next = current.next.next;
                size--;
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public void displayStudents() {

        if (head == null) {
            System.out.println("No student records found.");
            return;
        }

        Node current = head;

        System.out.println("\n===== Student Records =====");

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }

        System.out.println("Total Students: " + size);
    }

    public int getSize() {
        return size;
    }
}