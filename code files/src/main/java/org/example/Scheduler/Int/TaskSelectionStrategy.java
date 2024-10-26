package org.example.Scheduler.Int;

import org.example.Task.Task;

import java.util.List;

public interface TaskSelectionStrategy {
    Task selectTask(List<Task> tasks, int clockCycle);
}