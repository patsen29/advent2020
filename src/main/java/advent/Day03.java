package advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Day03 {
    public static void main(String[] args) throws IOException {
        Path inputFile = Paths.get("src/main/resources/day03.txt");
        List<String> treeMap = Files.readAllLines(inputFile);

        System.out.println("Part 1: " + countTreesFirst(treeMap, 3, 1));
    }

    static long countTreesFirst(List<String> givenMap, int slopeRight, int slopeDown) {
        // y = mx+b , so since we start at (0, 0), and slope becomes slopeRight/slopeDown,
        // we get: column = slopeRight * row (assuming slopeDown remains 1, which is simpler)

        if (givenMap.isEmpty()) return 0; // No map, no trees.
        int worldWidth = givenMap.get(0).length();
        int treeCount = 0;
        for (int row = 0; row < givenMap.size(); row++) {
            int column = (slopeRight * row) % worldWidth;
            String mapRow = givenMap.get(row);
            if (mapRow.charAt(column) == '#') {
                treeCount++;
            }
        }
        return treeCount;
    }
}
