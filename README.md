# Mini Hospital Emergency Management System

A Java-based simulation of a hospital emergency department developed for **CIT300 - Data Structures and Algorithms**.

---

## Project Overview

The **Mini Hospital Emergency Management System** simulates the basic operations of a hospital emergency department using core Data Structures. The system manages patient registration, emergency waiting queues, treatment records, and patient visit history.

---

## Data Structures Implemented

### 1. Binary Search Tree (BST)
Used for managing registered patients using **Patient ID** as the key.

* **Register new patient:** Inserts a unique patient record.
* **Search patient by ID:** Retrieves patient details using BST search.
* **Delete patient by ID:** Removes patient record from the tree.
* **In-order traversal:** Displays patients sorted in ascending order of ID.

### 2. Queue (FIFO)
Used to manage the **Emergency Unit Waiting Queue** following the First-In, First-Out (FIFO) principle.

* **Enqueue:** Add patient to waiting queue.
* **Dequeue:** Remove next patient for treatment.
* **Display:** View all currently waiting patients.
* **Empty Handling:** Handles empty queue conditions gracefully.

### 3. Stack (LIFO)
Used to maintain **Completed Treatment Records History** following the Last-In, First-Out (LIFO) principle.

* **Push:** Add completed treatment record to history.
* **Pop:** Remove the most recent treatment record.
* **Display:** View all past treatment records.

### 4. Singly Linked List
Used to manage each patient's dynamic **Visit History**.

* **Add visit:** Append a new visit record.
* **Remove visit:** Delete a specific visit record.
* **Search visit:** Search past visits.
* **Display:** Display complete patient visit history.

---

## Project Structure

```text
MiniHospitalSystem/
│
├── src/
│   └── com/
│       └── hospital/
│           └── system/
│               ├── Patient.java
│               ├── PatientBST.java
│               ├── EmergencyQueue.java
│               ├── TreatmentStack.java
│               ├── Visit.java
│               ├── VisitLinkedList.java
│               └── Main.java
│
├── README.md
└── .gitignore