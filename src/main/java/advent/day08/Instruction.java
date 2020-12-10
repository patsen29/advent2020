package advent.day08;

public class Instruction {
    final String operation;
    final int argument;

    public Instruction(String operation, int argument) {
        this.operation = operation;
        this.argument = argument;
    }

    public static Instruction parseInstruction(String line) {
        String[] tokens = line.split(" ");
        String operation = tokens[0];
        int argument = Integer.parseInt(tokens[1]);
        return new Instruction(operation, argument);
    }
}
