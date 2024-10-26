package org.example.Simulator.Int.Impl;

import org.example.Simulator.Int.TaskCreationStrategy;
import org.example.Task.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskCreationStrategyImpl implements TaskCreationStrategy {
    @Override
    public List<Task> createTasks(List<Integer> lines) {
        List<Task> tempTasks = new ArrayList<>();
        if (lines == null || lines.isEmpty()) {
            System.out.println("No lines found or the list is empty.");
            return tempTasks;
        }

        try {
            int numberOfTasks = lines.get(0);
            if (numberOfTasks < 1 || numberOfTasks >= lines.size()) {
                System.out.println("Invalid number of tasks specified: " + numberOfTasks);
                return tempTasks;
            }

            for (int i = 1; i <= numberOfTasks; i++) {
                int number = lines.get(i);

                // Extract digits
                int hundreds = number / 100;     // Get hundreds place digit
                int tens = (number / 10) % 10;   // Get tens place digit
                int ones = number % 10;          // Get ones place digit

                // Validate extracted values if needed
                if (hundreds < 0 || tens < 0 || ones < 0) {
                    System.out.println("Invalid task data at line: " + (i + 1));
                    continue;
                }

                // Create Task object and assign values
                Task task = new Task(hundreds, tens, ones);
                tempTasks.add(task);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Not enough lines for the specified number of tasks.");
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

        return tempTasks;
    }

}
