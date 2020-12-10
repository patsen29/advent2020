package advent.day08;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    private final List<Instruction> program;
    private int accumulator = 0;
    private int instuctionPointer = 0;

    public Computer(List<Instruction> program) {
        this.program = program;
    }

    public void runNext() {
        // if (instuctionPointer < 0 || instuctionPointer >= program.size()) return; // End of program
        Instruction toRun = program.get(instuctionPointer);
        String operation = toRun.operation;
        int currentLine = instuctionPointer;
        int nextLine = instuctionPointer + 1;
        switch (operation) {
            case "acc":
                accumulator += toRun.argument;
                break;
            case "jmp":
                nextLine = instuctionPointer + toRun.argument;
                break;
            case "nop":
                break;
            default:
                throw new IllegalArgumentException("Unknown operation " + operation);
        }
        instuctionPointer = nextLine;
        System.out.printf("Line num %d: %s %d (acc = %d)%n", currentLine, operation, toRun.argument, accumulator);
    }

    public void reset() {
        accumulator = 0;
        instuctionPointer = 0;
    }

    public int traceProgram() {
        Set<Integer> commandsRun = new HashSet<>();
        while (true) {
            int lineNumber = instuctionPointer;
            if (commandsRun.contains(lineNumber)) {
                return accumulator;
            }
            runNext();
            commandsRun.add(lineNumber);
        }
    }
}
