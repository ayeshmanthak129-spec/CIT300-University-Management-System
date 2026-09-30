package university;

import university.model.Student;
import university.stackqueue.ActionStack;
import university.stackqueue.ServiceQueue;

public class StackQueueTest {

    public static void main(String[] args) {

        // --------------------
        // STACK TEST
        // --------------------

        ActionStack stack = new ActionStack();

        stack.push("Add Student");
        stack.push("Update Student");
        stack.push("Delete Student");

        System.out.println("STACK TEST:");
        stack.display();

        System.out.println();


        // --------------------
        // QUEUE TEST
        // --------------------

        Student studentA =
                new Student(1001, "Nimal Silva", "BAIT", 78);

        Student studentB =
                new Student(1002, "Kamal Perera", "BSc IT", 84);

        Student studentC =
                new Student(1003, "Amal Fernando", "BIT", 65);

        ServiceQueue queue = new ServiceQueue();

        queue.enqueue(studentA, "Transcript Request");
        queue.enqueue(studentB, "ID Card Request");
        queue.enqueue(studentC, "Payment Request");

        System.out.println("QUEUE TEST:");
        queue.display();

        System.out.println();

        System.out.println("Processing:");
        System.out.println(queue.processNext());
        System.out.println(queue.processNext());
        System.out.println(queue.processNext());
    }
}