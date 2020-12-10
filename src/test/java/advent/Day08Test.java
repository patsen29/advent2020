package advent;

import advent.day08.Computer;
import advent.day08.Day08;
import advent.day08.Instruction;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day08Test {


    @Test
    public void testExecution() {
        List<String> testProgram = Arrays.asList(
                "nop +0", "acc +1", "jmp +4", "acc +3", "jmp -3", "acc -99", "acc +1", "jmp -4", "acc +6"
        );
        List<Instruction> program = Day08.parseProgram(testProgram);
        Computer computer = new Computer(program);
        assertEquals(5, computer.traceProgram());

    }
}
