package org.example.fitnessapp;

public class Legs implements Exercise {
    private int eID;
    private String eName;
    private int caloriesBurned;

    public Legs(int eID, String eName, int caloriesBurned) {
        setEID(eID);
        setEName(eName);
        setCaloriesBurned(caloriesBurned);
    }

    public int geteID() {
        return eID;
    }

    public void setEID(int eID) {
        if (eID <= 0) {
            throw new IllegalArgumentException("eID must be a positive integer.");
        }
        this.eID = eID;
    }

    public String geteName() {
        return eName;
    }

    public void setEName(String eName) {
        if (eName.length() < 1) {
            throw new IllegalArgumentException("eName must contain at least one character.");
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

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(int caloriesBurned) {
        if (caloriesBurned < 0) {
            throw new IllegalArgumentException("caloriesBurned cannot be negative.");
        }
        this.caloriesBurned = caloriesBurned;
    }

    @Override
    public String toString() {
        return "Legs{" +
                "eID=" + eID +
                ", eName='" + eName + '\'' +
                ", caloriesBurned=" + caloriesBurned +
                '}';
    }
}
