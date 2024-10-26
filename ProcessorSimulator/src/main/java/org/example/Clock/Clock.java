package org.example.Clock;

public class Clock {
    private static int currentCycle=0;
    private final int maxCycles;

    public Clock(int maxCycles) {
        this.maxCycles = maxCycles;
    }

    public void tick() {
        if (hasReachedMaxCycles()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Tick interrupted: " + e.getMessage());
            }
            currentCycle++;
            System.out.println("Current cycle: " + currentCycle);
        }
    }

    public int getCurrentCycle() {
        return currentCycle;
    }

    public boolean hasReachedMaxCycles() {return currentCycle < maxCycles;
    }
}
