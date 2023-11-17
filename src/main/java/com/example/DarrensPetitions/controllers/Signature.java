package com.example.DarrensPetitions.controllers;

public class Signature {
    private String name;
    private String email;

    // Constructor for Signature class
    public Signature(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Setter method for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for email
    public String getEmail() {
        return email;
    }

    // Setter method for email
    public void setEmail(String email) {
        this.email = email;
    }

}