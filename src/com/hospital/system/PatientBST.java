package com.hospital.system;

public class PatientBST {
    private Patient root;

    public PatientBST() {
        this.root = null;
    }

    // Insert Patient
    public void insert(Patient newPatient) {
        root = insertRec(root, newPatient);
        System.out.println("Patient registered successfully!");
    }

    private Patient insertRec(Patient root, Patient newPatient) {
        if (root == null) {
            root = newPatient;
            return root;
        }
        if (newPatient.patientId < root.patientId) {
            root.left = insertRec(root.left, newPatient);
        } else if (newPatient.patientId > root.patientId) {
            root.right = insertRec(root.right, newPatient);
        } else {
            System.out.println("Patient ID already exists!");
        }
        return root;
    }

    // Search Patient
    public Patient search(int patientId) {
        return searchRec(root, patientId);
    }

    private Patient searchRec(Patient root, int patientId) {
        if (root == null || root.patientId == patientId) {
            return root;
        }
        if (patientId < root.patientId) {
            return searchRec(root.left, patientId);
        }
        return searchRec(root.right, patientId);
    }

    // Delete Patient
    public void delete(int patientId) {
        root = deleteRec(root, patientId);
    }

    private Patient deleteRec(Patient root, int patientId) {
        if (root == null) {
            System.out.println("Patient not found!");
            return root;
        }
        if (patientId < root.patientId) {
            root.left = deleteRec(root.left, patientId);
        } else if (patientId > root.patientId) {
            root.right = deleteRec(root.right, patientId);
        } else {
            // Node with only one child or no child
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            // Node with two children: Get in-order successor
            root.patientId = minValue(root.right);
            root.right = deleteRec(root.right, root.patientId);
            System.out.println("Patient record deleted.");
        }
        return root;
    }

    private int minValue(Patient root) {
        int minv = root.patientId;
        while (root.left != null) {
            minv = root.left.patientId;
            root = root.left;
        }
        return minv;
    }

    // In-order Traversal
    public void inOrder() {
        if (root == null) {
            System.out.println("No patient records available.");
            return;
        }
        inOrderRec(root);
    }

    private void inOrderRec(Patient root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root);
            inOrderRec(root.right);
        }
    }
}
