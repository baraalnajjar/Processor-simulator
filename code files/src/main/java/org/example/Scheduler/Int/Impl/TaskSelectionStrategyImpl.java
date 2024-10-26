package org.example.Scheduler.Int.Impl;

import org.example.Scheduler.Int.TaskSelectionStrategy;
import org.example.Task.Task;

import java.util.List;

public class TaskSelectionStrategyImpl implements TaskSelectionStrategy {
    @Override
    public Task selectTask(List<Task> tasks, int clockCycle) {
        if (tasks == null || tasks.isEmpty()) {
            System.out.println("Task list is null or empty.");
            return null;
        }

        Task selectedTask = null;
        int selectedIndex = -1;

        try {
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                if (task == null) {
                    System.out.println("Found null task in the list at index " + i);
                    continue;
                }
                if (task.getCreationTime() <= clockCycle) {
                    if (selectedTask == null ||
                            task.getPriority() > selectedTask.getPriority() ||
                            (task.getPriority() == selectedTask.getPriority() && task.getExecutionTime() > selectedTask.getExecutionTime())) {
                        selectedTask = new Task(task.getCreationTime(), task.getExecutionTime(), task.getPriority(), task.getId());
                        selectedIndex = i;
                    }
                }
            }

            if (selectedTask != null) {
                System.out.println("Selected Task:");
                System.out.println("T" + selectedTask.getId());
                tasks.remove(selectedIndex);
            } else {
                System.out.println("No tasks waiting at clock cycle " + clockCycle);
            }
        } catch (Exception e) {
            System.out.println("Error selecting task: " + e.getMessage());
            return null;
        }

        return selectedTask;
    }

}
