package org.example.fitnessapp.Models;

// Defining the Exercise interface
public interface Exercise {
    // Method to get the exercise ID
    int getEID();

    // Method to get the exercise name
    String getEName();

    // Method to get the calories burned during the exercise
    int getCaloriesBurned();
}
