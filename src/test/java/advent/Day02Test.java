package advent;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Day02Test {
    @Test
    public void testPasswordCheck() {
        assertTrue(Day02.isValidPassword(1, 3, 'a', "abcde"));
        assertFalse(Day02.isValidPassword(1, 3, 'b', "cdefg"));
        assertTrue(Day02.isValidPassword(2, 9, 'c', "ccccccccc"));
    }

    @Test
    public void regexTest() {
        assertTrue(Day02.isValidPassword("1-3 a: abcde"));
        assertFalse(Day02.isValidPassword("1-3 b: cdefg"));
        assertTrue(Day02.isValidPassword("2-9 c: ccccccccc"));
    }
}