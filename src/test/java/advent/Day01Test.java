package advent;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day01Test {
    @Test
    public void testFindProduct() {
        List<Integer> example = Arrays.asList(1721, 979, 366, 299, 675, 1456);
        assertEquals(514579, Day01.findProductOfTwo(example, 2020));
        assertEquals(241861950, Day01.findProductOfThree(example, 2020));
    }
}