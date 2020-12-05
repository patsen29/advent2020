package advent;

import advent.day05.BoardingPass;
import advent.day05.Day05;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day05Test {
    @Test
    public void testParsing() {
        BoardingPass one = Day05.parsePass("BFFFBBFRRR");
        assertEquals(70, one.row);
        assertEquals(7, one.column);
        assertEquals(567, one.getSeatId());

        assertEquals(119, Day05.parsePass("FFFBBBFRRR").getSeatId());
        assertEquals(820, Day05.parsePass("BBFFBBFRLL").getSeatId());
    }
}