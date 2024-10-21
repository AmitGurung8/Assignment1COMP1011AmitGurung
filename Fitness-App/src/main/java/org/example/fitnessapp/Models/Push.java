package org.example.fitnessapp.Models;

// Implementing the Exercise interface
public class Push implements Exercise {
    private int eID; // Variable to store exercise ID
    private String eName; // Variable to store exercise name
    private int caloriesBurned; // Variable to store calories burned

    // Constructor to initialize the Push object
    public Push(int eID, String eName, int caloriesBurned) {
        setEID(eID); // Setting exercise ID
        setEName(eName); // Setting exercise name
        setCaloriesBurned(caloriesBurned); // Setting calories burned
    }

    // Getter method for exercise ID
    public int geteID() {
        return eID; // Returning exercise ID
    }

    // Setter method for exercise ID with validation
    public void setEID(int eID) {
        if (eID < 0) { // Validating that eID is not negative
            throw new IllegalArgumentException("ID cannot be negative");
        }
        this.eID = eID; // Setting the exercise ID
    }

    // Getter method for exercise name
    public String geteName() {
        return eName; // Returning exercise name
    }

    // Setter method for exercise name with validation
    public void setEName(String eName) {
        if (eName.length() < 1) { // Validating that eName has at least one character
            throw new IllegalArgumentException("Name must contain at least one character.");
        }
        this.eName = eName; // Setting the exercise name
    }

    // Implementing the getEID method from the Exercise interface
    @Override
    public int getEID() {
        return eID; // Returning exercise ID
    }

    // Implementing the getEName method from the Exercise interface
    @Override
    public String getEName() {
        return eName; // Returning exercise name
    }

    // Getter method for calories burned
    public int getCaloriesBurned() {
        return caloriesBurned; // Returning calories burned
    }

    // Setter method for calories burned with validation
    public void setCaloriesBurned(int caloriesBurned) {
        if (caloriesBurned < 0) { // Validating that calories burned cannot be negative
            throw new IllegalArgumentException("Calories burned cannot be negative");
        }
        this.caloriesBurned = caloriesBurned; // Setting the calories burned
    }

    // Overriding toString method to provide a string representation of the Push object
    @Override
    public String toString() {
        return "Push{" +
                "eID=" + eID + // Including exercise ID
                ", eName='" + eName + '\'' + // Including exercise name
                ", caloriesBurned=" + caloriesBurned + // Including calories burned
                '}';
    }
}
