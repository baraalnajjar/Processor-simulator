package org.example.Task;
public class Task {
    private final int creationTime;
    private final int executionTime;
    private final int priority;
    private final int id;
    private static int i=1;
    public Task(int creationTime, int executionTime, int priority) {
        this.creationTime = creationTime;
        this.executionTime = executionTime;
        this.priority = priority;
        this.id = i;
        i++;
    }
    public Task(int creationTime, int executionTime, int priority,int id) {
        this.creationTime = creationTime;
        this.executionTime = executionTime;
        this.priority = priority;
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
    public int getCreationTime() {
        return creationTime;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Task{creationTime=" + creationTime + ", executionTime=" + executionTime + ", priority=" + priority + "}";
    }


}
