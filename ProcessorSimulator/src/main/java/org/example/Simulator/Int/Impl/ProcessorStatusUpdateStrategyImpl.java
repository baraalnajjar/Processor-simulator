package org.example.Simulator.Int.Impl;

import org.example.Processor.Processor;
import org.example.Simulator.Int.ProcessorStatusUpdateStrategy;

import java.util.List;

public class ProcessorStatusUpdateStrategyImpl implements ProcessorStatusUpdateStrategy {
    @Override
    public void updateProcessorStatus(List<Processor> processors, int currentCycle) {
        if (processors == null) {
            System.out.println("Processor list is null.");
            return;
        }

        try {
            for (Processor processor : processors) {
                if (processor == null) {
                    System.out.println("Found null processor in the list.");
                    continue;
                }

                if (processor.getFinishCycle() <= currentCycle) {
                    processor.setAvailable(true);
                    processor.setCurrentTask(null);
                }
            }
        } catch (Exception e) {
            System.out.println("Error updating processor status: " + e.getMessage());
        }
    }

}