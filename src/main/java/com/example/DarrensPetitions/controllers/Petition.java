package com.example.DarrensPetitions.controllers;

public class Petition {
    private String petitionTitle;
    private String petitionDescription;
    private String petitionAuthor;
    private int petitionSignatures;

    // Default constructor
    public Petition() {}

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

    // Getter method for retrieving the petitionSignatures
    public int getPetitionSignatures() {
        return petitionSignatures;
    }

    // Setter method for setting the petitionSignatures
    public void setPetitionSignatures(int petitionSignatures) {
        this.petitionSignatures = petitionSignatures;
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
