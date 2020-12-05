package advent.day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class Day05 {
    public static void main(String[] args) throws IOException {
        Set<Integer> passes = Files.readAllLines(Paths.get("src/main/resources/day05.txt")).stream()
                .map(Day05::parsePass)
                .collect(Collectors.toSet());

        int max = findHighestPass(passes);
        System.out.println("Part 1: " + max);
        System.out.println("Part 2: " + findMissingPass(passes, max));
    }

    public static int parsePass(String code) {
        int id = 0;
        for (int i = 0; i < code.length(); i++) {
            id *= 2;
            char ch = code.charAt(i);
            if (ch == 'B' || ch == 'R') {
                id++;
            }
        }
        return id;
    }

    public static int findHighestPass(Collection<Integer> passes) {
        return passes.stream()
                .max(Integer::compareTo)
                .orElse(-1);
    }

    public static int findMissingPass(Set<Integer> passes, int max) {
        for (int i = 1; i < max; i++) {
            if (passes.contains(i - 1) && !passes.contains(i) && passes.contains(i + 1)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Could not find gap on plane");
    }
}