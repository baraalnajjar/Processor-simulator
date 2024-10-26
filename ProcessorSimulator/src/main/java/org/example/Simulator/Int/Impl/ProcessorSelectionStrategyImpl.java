package org.example.Simulator.Int.Impl;

import org.example.Processor.Processor;
import org.example.Simulator.Int.ProcessorSelectionStrategy;

import java.util.List;

public class ProcessorSelectionStrategyImpl implements ProcessorSelectionStrategy {
    @Override
    public int getAvailableProcessor(List<Processor> processors) {
        if (processors == null || processors.isEmpty()) {
            System.out.println("Processor list is null or empty.");
            return -1;
        }

        try {
            for (Processor processor : processors) {
                if (processor == null) {
                    System.out.println("Found null processor in the list.");
                    continue;
                }
                if (processor.isAvailable()) {
                    return processor.getId();
                }
            }
        } catch (Exception e) {
            System.out.println("Error checking processors: " + e.getMessage());
        }

        return -1;
    }

}

