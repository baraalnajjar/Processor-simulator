package org.example.Simulator.Int;

import org.example.Task.Task;

import java.util.List;

public interface TaskCreationStrategy {
    List<Task> createTasks(List<Integer> lines);
}