package advent;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day03Test {
    private List<String> sampleMap = Arrays.asList(
            "..##.......",
            "#...#...#..",
            ".#....#..#.",
            "..#.#...#.#",
            ".#...##..#.",
            "..#.##.....",
            ".#.#.#....#",
            ".#........#",
            "#.##...#...",
            "#...##....#",
            ".#..#...#.#"
    );

    @Test
    public void testSampleMap() {
        assertEquals(2, Day03.countTreesOnPath(sampleMap, 1, 1));
        assertEquals(7, Day03.countTreesOnPath(sampleMap, 3, 1));
        assertEquals(3, Day03.countTreesOnPath(sampleMap, 5, 1));
        assertEquals(4, Day03.countTreesOnPath(sampleMap, 7, 1));
        assertEquals(2, Day03.countTreesOnPath(sampleMap, 1, 2));
        assertEquals(336, Day03.countMultiplePaths(sampleMap));
    }
}
