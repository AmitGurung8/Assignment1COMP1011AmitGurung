-- Creating a new database called 'Lab5'
CREATE DATABASE Lab5;

-- Using the 'Lab5' database
USE Lab5;

-- Creating the 'Exercises' table to store exercise information
CREATE TABLE Exercises (
eID INT NOT NULL PRIMARY KEY,
eName VARCHAR(80) NOT NULL,
eDifficulty VARCHAR(80) NOT NULL,
caloriesBurned INT NOT NULL,
reps VARCHAR(80) NOT NULL,
sets VARCHAR(80) NOT NULL);

-- Inserting exercise data into the 'Exercises' table
INSERT INTO Exercises (eID, eName, eDifficulty, caloriesBurned, reps, sets) VALUES
(1, 'Push-ups', 'Medium', 50, '15', '3'),
(2, 'Squats', 'Low', 35, '20', '3'),
(3, 'Jumping Jacks', 'Low', 30, '30', '2'),
(4, 'Burpees', 'Hard', 80, '10', '3'),
(5, 'Lunges', 'Medium', 45, '12', '3'),
(6, 'Pull-ups', 'Hard', 70, '8', '3'),
(7, 'Plank', 'Medium', 25, '60 sec', '3'),
(8, 'Bicycle Crunches', 'Low', 40, '20', '3'),
(9, 'Mountain Climbers', 'Medium', 60, '25', '4'),
(10, 'Bench Press', 'Hard', 90, '10', '4'),
(11, 'Deadlifts', 'Hard', 100, '5', '3'),
(12, 'Sit-ups', 'Low', 30, '20', '3'),
(13, 'Leg Raises', 'Medium', 50, '15', '4'),
(14, 'Dumbbell Curls', 'Low', 25, '12', '3'),
(15, 'Overhead Press', 'Medium', 55, '10', '3'),
(16, 'Kettlebell Swings', 'Hard', 85, '15', '3'),
(17, 'Wall Sit', 'Low', 20, '60 sec', '3'),
(18, 'Tricep Dips', 'Medium', 45, '15', '3'),
(19, 'Box Jumps', 'Hard', 75, '12', '3'),
(20, 'Skater Jumps', 'Medium', 60, '20', '3'),
(21, 'High Knees', 'Low', 35, '30', '3'),
(22, 'Treadmill Run', 'Medium', 120, '10 min', '1'),
(23, 'Rowing Machine', 'Medium', 110, '10 min', '1'),
(24, 'Jump Rope', 'Low', 55, '5 min', '2'),
(25, 'Lat Pulldown', 'Hard', 95, '10', '3'),
(26, 'Russian Twists', 'Medium', 50, '20', '4'),
(27, 'Hip Thrusts', 'Low', 40, '15', '3'),
(28, 'Dumbbell Rows', 'Medium', 65, '12', '3'),
(29, 'Cable Crossovers', 'Hard', 85, '10', '3'),
(30, 'Leg Press', 'Hard', 90, '8', '3'),
(31, 'Calf Raises', 'Low', 20, '15', '3'),
(32, 'Glute Bridges', 'Medium', 45, '12', '4'),
(33, 'Side Plank', 'Low', 25, '30 sec', '3'),
(34, 'Windshield Wipers', 'Hard', 75, '12', '3'),
(35, 'Battle Ropes', 'Medium', 80, '30 sec', '3'),
(36, 'Farmer Walk', 'Low', 60, '1 min', '2'),
(37, 'Jump Squats', 'Medium', 70, '15', '3'),
(38, 'Pistol Squats', 'Hard', 85, '8', '3'),
(39, 'Step-ups', 'Low', 35, '15', '3'),
(40, 'Clapping Push-ups', 'Hard', 100, '10', '3'),
(41, 'Sprint Intervals', 'Medium', 130, '15 min', '1'),
(42, 'Incline Push-ups', 'Low', 40, '12', '3'),
(43, 'Hollow Body Hold', 'Medium', 25, '60 sec', '3'),
(44, 'Sumo Deadlift', 'Hard', 105, '5', '3'),
(45, 'Reverse Lunges', 'Medium', 50, '12', '4'),
(46, 'Flutter Kicks', 'Low', 30, '20', '4'),
(47, 'Dumbbell Flyes', 'Medium', 60, '10', '3'),
(48, 'Tire Flips', 'Hard', 90, '10', '3'),
(49, 'Ab Wheel Rollouts', 'Medium', 65, '15', '3'),
(50, 'Boxing', 'Medium', 150, '20 min', '1');

-- Creating a new user 'Lab5' with localhost access and setting a password
CREATE USER 'Lab5'@'localhost' IDENTIFIED BY 'Lab5';

-- Granting all privileges on the database to the new user
GRANT ALL PRIVILEGES ON * . * TO 'Lab5'@'localhost';