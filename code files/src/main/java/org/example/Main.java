package org.example;
import org.example.Simulator.Simulator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of processors: ");
        int numberOfProcessors = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter the total number of clock cycles: ");
        int totalClockCycles = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter the path to the tasks file: ");
        String tasksFilePath = scanner.nextLine().trim();
        scanner.close();

        Simulator simulator= new Simulator(numberOfProcessors,totalClockCycles,tasksFilePath);
        simulator.run();

    }


}
