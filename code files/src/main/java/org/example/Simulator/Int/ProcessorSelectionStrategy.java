package org.example.Simulator.Int;

import org.example.Processor.Processor;

import java.util.List;

public interface ProcessorSelectionStrategy {
    int getAvailableProcessor(List<Processor> processors);
}