package com.hospital.system;

public class TreatmentStack {
    private class Node {
        Patient patient;
        Node next;

        Node(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    private Node top;

    public TreatmentStack() {
        this.top = null;
    }

    // Push
    public void push(Patient patient) {
        Node newNode = new Node(patient);
        newNode.next = top;
        top = newNode;
        System.out.println("Treatment completed and record pushed to Stack for: " + patient.name);
    }

    // Pop
    public Patient pop() {
        if (top == null) {
            System.out.println("Treatment History Stack is empty!");
            return null;
        }
        Patient p = top.patient;
        top = top.next;
        System.out.println("Most recent treatment record popped: " + p.name);
        return p;
    }

    // Display
    public void displayStack() {
        if (top == null) {
            System.out.println("No completed treatment records in stack.");
            return;
        }
        System.out.println("--- Treatment History (LIFO) ---");
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.patient);
            temp = temp.next;
        }
    }
}