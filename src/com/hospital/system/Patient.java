package com.hospital.system;

public class Patient {
    int patientId;
    String name;
    int age;
    String contactNumber;
    String medicalCondition;
    
    VisitLinkedList visitHistory; // Linked List for Visit History
    Patient left, right;

    public Patient(int patientId, String name, int age, String contactNumber, String medicalCondition) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.medicalCondition = medicalCondition;
        this.visitHistory = new VisitLinkedList();
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "ID: " + patientId + " | Name: " + name + " | Age: " + age + 
               " | Contact: " + contactNumber + " | Condition: " + medicalCondition;
    }
}