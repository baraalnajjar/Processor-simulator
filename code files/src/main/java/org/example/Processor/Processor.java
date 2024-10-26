package org.example.Processor;

import org.example.Task.Task;

public class Processor {
    private final int id;
    private static int i=1;
    public Processor() {
        this.id = i;
        i++;
        this.available = true;
        this.currentTask = null;
    }
    private int finishCycle;
    private boolean available;
    private Task currentTask;

    public int getId() {
        return id;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    public void setCurrentTask(Task currentTask) {
        this.currentTask = currentTask;
    }
    public Task getCurrentTask() {
        return currentTask;
    }
    public int getFinishCycle() {
        return finishCycle;
    }

    public void setFinishCycle(int finishCycle) {
        this.finishCycle = finishCycle;
    }


}
