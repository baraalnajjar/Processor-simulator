package org.example.Simulator.Int;

import org.example.Processor.Processor;

import java.util.List;

public interface ProcessorStatusUpdateStrategy {
    void updateProcessorStatus(List<Processor> processors, int currentCycle);
}