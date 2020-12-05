package advent;

import advent.day05.Day05;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day05Test {
    @Test
    public void testParsing() {
        assertEquals(567, Day05.parsePass("BFFFBBFRRR"));
        assertEquals(119, Day05.parsePass("FFFBBBFRRR"));
        assertEquals(820, Day05.parsePass("BBFFBBFRLL"));
    }
}