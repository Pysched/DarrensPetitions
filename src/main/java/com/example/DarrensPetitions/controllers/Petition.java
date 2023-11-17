package com.example.DarrensPetitions.controllers;

import java.util.ArrayList;
import java.util.List;

public class Petition {
    private String petitionTitle; // Store the title of the petition
    private String petitionDescription; // Store the description of the petition
    private String petitionAuthor; // Store the author of the petition
    private int petitionSignatures; // Integer to store the number of signatures
    private List<Signature> signatures; // List to store signature objects
    private String signupSignature; // Store the signup signature
    private String signupEmail; // Store the signup email

    // Default constructor
    public Petition() {
        signatures = new ArrayList<>(); // Initialize the signatures list
    }

    // Constructor with parameters
    public Petition(String petitionTitle, String petitionDescription, String petitionAuthor) {
        this.petitionTitle = petitionTitle;
        this.petitionDescription = petitionDescription;
        this.petitionAuthor = petitionAuthor;
        this.petitionSignatures = 0; // Initialize the number of signatures to 0
        signatures = new ArrayList<>(); // Initialize the signatures list
    }

    // Getter method for retrieving the petitionTitle
    public String getPetitionTitle() {
        return petitionTitle;
    }

    // Setter method for setting the petitionTitle
    public void setPetitionTitle(String petitionTitle) {
        this.petitionTitle = petitionTitle;
    }

    // Getter method for retrieving the petitionDescription
    public String getPetitionDescription() {
        return petitionDescription;
    }

    // Setter method for setting the petitionDescription
    public void setPetitionDescription(String petitionDescription) {
        this.petitionDescription = petitionDescription;
    }

    // Getter method for retrieving the petitionAuthor
    public String getPetitionAuthor() {
        return petitionAuthor;
    }

    // Setter method for setting the petitionAuthor
    public void setPetitionAuthor(String petitionAuthor) {
        this.petitionAuthor = petitionAuthor;
    }

    // Getter method for retrieving the signupSignature
    public String getSignupSignature() {
        return signupSignature;
    }

    // Setter method for setting the signupSignature
    public void setSignupSignature(String signupSignature) {
        this.signupSignature = signupSignature;
    }

    // Getter method for retrieving the signupEmail
    public String getSignupEmail() {
        return signupEmail;
    }

    // Setter method for setting the signupEmail
    public void setSignupEmail(String signupEmail) {
        this.signupEmail = signupEmail;
    }

    // Getter method for retrieving the petitionSignatures
    public int getPetitionSignatures() {
        return petitionSignatures;
    }

    // Setter method for setting the petitionSignatures
    public void setPetitionSignatures(int petitionSignatures) {
        this.petitionSignatures = petitionSignatures;
    }

    // Increment the petition signatures count
    public void incrementPetitionSignatures() {
        this.petitionSignatures++;
    }

    // Getter method to get the number of signatures
    public int getNumberOfSignatures() {
        return signatures.size(); // Return the size of the signatures list
    }

    // Getter method to get the list of signatures
    public List<Signature> getSignatures() {
        return signatures; // Return the signatures list
    }

    // Method to add a signature to the list and increment the signature count
    public void addSignature(Signature signature) {
        signatures.add(signature); // Add the signature to the signatures list
        incrementPetitionSignatures(); // Increment the number of signatures
    }

    // toString method for displaying the petition object
    @Override
    public String toString() {
        return "Petition{" +
                "petitionTitle='" + petitionTitle + '\'' +
                ", petitionDescription='" + petitionDescription + '\'' +
                ", petitionAuthor='" + petitionAuthor + '\'' +
                ", petitionSignatures=" + petitionSignatures +
                '}';
    }


}
