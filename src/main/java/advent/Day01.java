package advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Day01 {
    public static void main(String[] args) throws IOException {

        List<Integer> lines = Files.readAllLines(Paths.get("src/main/resources/day01.txt")).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println("Part 1: " + findProduct(lines, 2020));
    }

    /** Logic for first half of the puzzle. Builds sorted set, looking for complement  */
    static int findProduct(List<Integer> list, int target) {
        SortedSet<Integer> sortedSet = new TreeSet<>();
        for (int num : list) {
            int lookingFor = target - num;
            if (sortedSet.contains(lookingFor)) {
                // println("Found match $num and $lookingFor")
                return num * lookingFor;
            }
            sortedSet.add(num);
        }
        throw new IllegalStateException("Could not find match");
    }

}