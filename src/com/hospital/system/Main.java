package com.hospital.system;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PatientBST bst = new PatientBST();
        EmergencyQueue queue = new EmergencyQueue();
        TreatmentStack stack = new TreatmentStack();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM ===");
            System.out.println("1. Register New Patient (BST)");
            System.out.println("2. Search Patient (BST)");
            System.out.println("3. Delete Patient (BST)");
            System.out.println("4. Display All Patients In-Order (BST)");
            System.out.println("5. Add Patient to Emergency Queue (Enqueue)");
            System.out.println("6. Treat Next Patient (Dequeue -> Push to Stack)");
            System.out.println("7. Display Emergency Queue");
            System.out.println("8. Display Completed Treatment History (Stack)");
            System.out.println("9. Pop Recent Treatment Record (Stack)");
            System.out.println("10. Manage Patient Visit History (Singly Linked List)");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Name: "); String name = sc.nextLine();
                    System.out.print("Enter Age: "); int age = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Contact: "); String contact = sc.nextLine();
                    System.out.print("Enter Condition: "); String cond = sc.nextLine();
                    bst.insert(new Patient(id, name, age, contact, cond));
                    break;
                case 2:
                    System.out.print("Enter Patient ID to search: ");
                    Patient found = bst.search(sc.nextInt());
                    if (found != null) System.out.println("Found: " + found);
                    else System.out.println("Patient not found!");
                    break;
                case 3:
                    System.out.print("Enter Patient ID to delete: ");
                    bst.delete(sc.nextInt());
                    break;
                case 4:
                    System.out.println("--- All Patients In Ascending ID Order ---");
                    bst.inOrder();
                    break;
                case 5:
                    System.out.print("Enter Patient ID for Emergency: ");
                    Patient eqP = bst.search(sc.nextInt());
                    if (eqP != null) queue.enqueue(eqP);
                    else System.out.println("Patient ID not registered!");
                    break;
                case 6:
                    Patient treated = queue.dequeue();
                    if (treated != null) stack.push(treated);
                    break;
                case 7:
                    queue.displayQueue();
                    break;
                case 8:
                    stack.displayStack();
                    break;
                case 9:
                    stack.pop();
                    break;
                case 10:
                    System.out.print("Enter Patient ID to manage visit history: ");
                    Patient pVisit = bst.search(sc.nextInt());
                    if (pVisit != null) {
                        System.out.println("1. Add Visit  2. Remove Visit  3. Search Visit  4. Display Visits");
                        int vChoice = sc.nextInt(); sc.nextLine();
                        if (vChoice == 1) {
                            System.out.print("Visit ID: "); int vId = sc.nextInt(); sc.nextLine();
                            System.out.print("Date: "); String vDate = sc.nextLine();
                            System.out.print("Doctor: "); String vDoc = sc.nextLine();
                            System.out.print("Diagnosis: "); String vDiag = sc.nextLine();
                            System.out.print("Treatment: "); String vTrt = sc.nextLine();
                            pVisit.visitHistory.addVisit(vId, vDate, vDoc, vDiag, vTrt);
                        } else if (vChoice == 2) {
                            System.out.print("Visit ID to remove: ");
                            pVisit.visitHistory.removeVisit(sc.nextInt());
                        } else if (vChoice == 3) {
                            System.out.print("Visit ID to search: ");
                            pVisit.visitHistory.searchVisit(sc.nextInt());
                        } else if (vChoice == 4) {
                            pVisit.visitHistory.displayVisits();
                        }
                    } else {
                        System.out.println("Patient not found!");
                    }
                    break;
                case 11:
                    System.out.println("Exiting System. Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}