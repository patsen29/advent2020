package advent.day08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day08 {
    public static void main(String[] args) throws IOException {
        Path inputFile = Paths.get("src/main/resources/day08.txt");
        List<String> lines = Files.readAllLines(inputFile);
        List<Instruction> program = parseProgram(lines);

        Computer part1 = new Computer(program);
        System.out.println("Part 1: " + part1.traceProgram());

    }

    public static List<Instruction> parseProgram(List<String> testProgram) {
        return testProgram.stream()
                .map(Instruction::parseInstruction)
                .collect(Collectors.toList());
    }
}
