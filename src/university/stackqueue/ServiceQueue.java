package university.stackqueue;

import university.model.Student;

public class ServiceQueue {

    private static class Node {
        Student student;
        String request;
        Node next;

        Node(Student student, String request) {
            this.student = student;
            this.request = request;
        }
    }

    private Node front;
    private Node rear;

    public void enqueue(Student student, String request) {
        Node newNode = new Node(student, request);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    public Student processNext() {
        if (front == null) {
            return null;
        }

        Student student = front.student;

        front = front.next;

        if (front == null) {
            rear = null;
        }

        return student;
    }

    public void display() {
        if (front == null) {
            System.out.println("No service requests.");
            return;
        }

        Node current = front;

        System.out.println("--- Service Queue (FIFO) ---");

        while (current != null) {
            System.out.println(
                    current.student
                            + " | Request: " + current.request
            );

            current = current.next;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }
}