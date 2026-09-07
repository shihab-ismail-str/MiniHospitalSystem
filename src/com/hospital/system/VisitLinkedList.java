package com.hospital.system;

public class VisitLinkedList {
    private Visit head;

    public VisitLinkedList() {
        this.head = null;
    }

    // Add new visit
    public void addVisit(int visitId, String date, String doctor, String diagnosis, String treatment) {
        Visit newVisit = new Visit(visitId, date, doctor, diagnosis, treatment);
        if (head == null) {
            head = newVisit;
        } else {
            Visit temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newVisit;
        }
        System.out.println("Visit added successfully!");
    }

    // Remove visit by Visit ID
    public void removeVisit(int visitId) {
        if (head == null) {
            System.out.println("No visits to remove.");
            return;
        }
        if (head.visitId == visitId) {
            head = head.next;
            System.out.println("Visit ID " + visitId + " removed.");
            return;
        }
        Visit current = head;
        Visit prev = null;
        while (current != null && current.visitId != visitId) {
            prev = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("Visit ID not found.");
            return;
        }
        prev.next = current.next;
        System.out.println("Visit ID " + visitId + " removed.");
    }

    // Search visit
    public void searchVisit(int visitId) {
        Visit temp = head;
        while (temp != null) {
            if (temp.visitId == visitId) {
                System.out.println("Visit Found: " + temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Visit ID " + visitId + " not found.");
    }

    // Display all visits
    public void displayVisits() {
        if (head == null) {
            System.out.println("No visit history found.");
            return;
        }
        Visit temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
}