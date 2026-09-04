package com.hospital.system;

public class EmergencyQueue {
    private class Node {
        Patient patient;
        Node next;

        Node(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    private Node front, rear;

    public EmergencyQueue() {
        this.front = this.rear = null;
    }

    // Enqueue
    public void enqueue(Patient patient) {
        Node newNode = new Node(patient);
        if (rear == null) {
            front = rear = newNode;
            System.out.println("Patient " + patient.name + " added to emergency queue.");
            return;
        }
        rear.next = newNode;
        rear = newNode;
        System.out.println("Patient " + patient.name + " added to emergency queue.");
    }

    // Dequeue
    public Patient dequeue() {
        if (front == null) {
            System.out.println("Emergency Queue is empty!");
            return null;
        }
        Patient p = front.patient;
        front = front.next;
        if (front == null) rear = null;
        System.out.println("Patient " + p.name + " removed from queue for treatment.");
        return p;
    }

    // Display
    public void displayQueue() {
        if (front == null) {
            System.out.println("No waiting patients in emergency queue.");
            return;
        }
        System.out.println("--- Emergency Queue (FIFO) ---");
        Node temp = front;
        while (temp != null) {
            System.out.println(temp.patient);
            temp = temp.next;
        }
    }
}