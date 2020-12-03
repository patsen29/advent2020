package advent;

import org.junit.jupiter.api.Test;

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
        assertEquals(7, Day03.countTreesFirst(sampleMap, 3, 1));
    }
}
