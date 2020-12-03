package advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day03 {
    public static void main(String[] args) throws IOException {
        Path inputFile = Paths.get("src/main/resources/day03.txt");
        List<String> treeMap = Files.readAllLines(inputFile);

        System.out.println("Part 1: " + countTreesOnPath(treeMap, 3, 1));
        System.out.println("Part 2: " + countMultiplePaths(treeMap));
    }

    static int countTreesOnPath(List<String> givenMap, int slopeRight, int slopeDown) {
        // y = mx+b , so since we start at (0, 0), and slope becomes slopeRight/slopeDown,
        // we get: column = slopeRight * row (assuming slopeDown remains 1, which is simpler)

        if (givenMap.isEmpty()) return 0; // No map, no trees.
        int worldWidth = givenMap.get(0).length();
        int treeCount = 0;
        for (int row = 0; row < givenMap.size(); row += slopeDown) {
            int column = (slopeRight * row / slopeDown) % worldWidth;
            String mapRow = givenMap.get(row);
            if (mapRow.charAt(column) == '#') {
                treeCount++;
            }
        }
        return treeCount;
    }

    static int countMultiplePaths(List<String> givenMap) {
        List<Integer> treeCounts = new ArrayList<>();
        treeCounts.add(countTreesOnPath(givenMap, 1, 1));
        treeCounts.add(countTreesOnPath(givenMap, 3, 1));
        treeCounts.add(countTreesOnPath(givenMap, 5, 1));
        treeCounts.add(countTreesOnPath(givenMap, 7, 1));
        treeCounts.add(countTreesOnPath(givenMap, 1, 2));

        // Multiply every element in the list together, using reduce call
        return treeCounts.stream()
                .reduce(1, (a, b) -> a * b);
    }
}
