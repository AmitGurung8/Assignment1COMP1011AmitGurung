package org.example.fitnessapp;

public class Push implements Exercise {
    private int eID;
    private String eName;
    private int caloriesBurned;

    // Constructor
    public Push(int eID, String eName, int caloriesBurned) {
        setEID(eID);
        setEName(eName);
        setCaloriesBurned(caloriesBurned);
    }

    // Getter and Setter for eID
    public int geteID() {
        return eID;
    }

    public void setEID(int eID) {
        if (eID < 0) {
            throw new IllegalArgumentException("ID cannot be negative");
        }
        this.eID = eID;
    }

    // Getter and Setter for eName
    public String geteName() {
        return eName;
    }

    public void setEName(String eName) {
        if (eName.length() < 1) {
            throw new IllegalArgumentException("Name must contain at least one character.");
        }
        this.eName = eName;
    }

    @Override
    public int getEID() {
        return eID;
    }

    @Override
    public String getEName() {
        return eName;
    }

    // Getter and Setter for caloriesBurned
    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(int caloriesBurned) {
        if (caloriesBurned < 0) {
            throw new IllegalArgumentException("Calories burned cannot be negative");
        }
        this.caloriesBurned = caloriesBurned;
    }

    @Override
    public String toString() {
        return "Push{" +
                "eID=" + eID +
                ", eName='" + eName + '\'' +
                ", caloriesBurned=" + caloriesBurned +
                '}';
    }
}
