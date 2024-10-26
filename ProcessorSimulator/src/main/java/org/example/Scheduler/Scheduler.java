package org.example.Scheduler;

import org.example.Scheduler.Int.TaskSelectionStrategy;
import org.example.Task.Task;

import java.util.List;

public class Scheduler {
    private final List<Task> tasks;
    private TaskSelectionStrategy taskSelectionStrategy;

    public Scheduler(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void setTaskSelectionStrategy(TaskSelectionStrategy taskSelectionStrategy) {
        this.taskSelectionStrategy = taskSelectionStrategy;
    }

    public Task getNextTask(int clockCycle) {
        return taskSelectionStrategy.selectTask(tasks, clockCycle);
    }
}
