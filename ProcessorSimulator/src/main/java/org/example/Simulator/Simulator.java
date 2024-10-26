package org.example.Simulator;
import org.example.Clock.Clock;
import org.example.Processor.Processor;
import org.example.Scheduler.Int.Impl.TaskSelectionStrategyImpl;
import org.example.Scheduler.Scheduler;
import org.example.Scheduler.Int.TaskSelectionStrategy;
import org.example.Simulator.Int.Impl.ProcessorSelectionStrategyImpl;
import org.example.Simulator.Int.Impl.ProcessorStatusUpdateStrategyImpl;
import org.example.Simulator.Int.Impl.TaskCreationStrategyImpl;
import org.example.Task.Task;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Simulator {
    private final List<Processor> processors;
    private final Clock clock;
    private final Scheduler scheduler;
    private final ProcessorSelectionStrategyImpl processorSelectionStrategy;
    private final ProcessorStatusUpdateStrategyImpl processorStatusUpdateStrategy;
    public Simulator(int numProcessors, int totalClockCycles, String tasksFilePath) {
        List<Integer> lines = readLines(tasksFilePath);
        TaskCreationStrategyImpl taskCreationStrategy = new TaskCreationStrategyImpl();
        this.processorSelectionStrategy = new ProcessorSelectionStrategyImpl();
        this.processorStatusUpdateStrategy = new ProcessorStatusUpdateStrategyImpl();

        List<Task> tasks = taskCreationStrategy.createTasks(lines);
        this.processors = initializeProcessors(numProcessors);
        this.clock = new Clock(totalClockCycles);
        TaskSelectionStrategy strategy = new TaskSelectionStrategyImpl();
        this.scheduler = new Scheduler(tasks);
        this.scheduler.setTaskSelectionStrategy(strategy);
    }

    public void run() {
        int tempProcessor;
        Task tempTask;
        Processor processor;

        while (clock.hasReachedMaxCycles()) {
            clock.tick();
            boolean innerLoopBroken = false;
            tempTask=new Task (0,0,0,0);

            while (tempTask != null) {
                tempProcessor = processorSelectionStrategy.getAvailableProcessor(processors);
                processorStatusUpdateStrategy.updateProcessorStatus(processors, clock.getCurrentCycle());

                if (tempProcessor > 0) {

                    tempTask = scheduler.getNextTask(clock.getCurrentCycle());
                    processor = getProcessorById(tempProcessor);

                    if (processor != null && tempTask != null) {
                        processor.setAvailable(false);
                        processor.setCurrentTask(tempTask);
                        processor.setFinishCycle(tempTask.getExecutionTime() + clock.getCurrentCycle());
                    }
                } else {
                    processorStatusUpdateStrategy.updateProcessorStatus(processors, clock.getCurrentCycle());
                    printAllProcessorStatuses();
                    innerLoopBroken = true;
                    break;
                }

            }

            if (!innerLoopBroken) {
                processorStatusUpdateStrategy.updateProcessorStatus(processors, clock.getCurrentCycle());
                printAllProcessorStatuses();
            }
        }

        System.out.println("Simulation ended");
    }


    private List<Integer> readLines(String filePath ) {
        List<Integer> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(Integer.parseInt(line.trim()));
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }
        return lines;
    }
    private List<Processor> initializeProcessors(int numProcessors) {
        List<Processor> processors = new ArrayList<>();
        for (int i = 1; i <= numProcessors; i++) {
            processors.add(new Processor());
        }
        return processors;
    }
    private Processor getProcessorById(int id) {
        for (Processor processor : processors) {
            if (processor.getId() == id) {
                return processor;
            }
        }
        return null;
    }
    public void printAllProcessorStatuses() {
        for (Processor processor : processors) {
            if (processor.isAvailable()) {
                System.out.println("P" + processor.getId() + " is idle.");
            } else {
                Task currentTask = processor.getCurrentTask();
                if (currentTask != null) {
                    System.out.println("P" + processor.getId() + " is executing T" + currentTask.getId());
                } else {
                    System.out.println("P" + processor.getId() + " is idle.");
                }
            }
        }
    }

}
