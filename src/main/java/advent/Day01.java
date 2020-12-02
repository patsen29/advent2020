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
        System.out.println("Part 1: " + findProductOfTwo(lines, 2020));
        System.out.println("Part 2: " + findProductOfThree(lines, 2020));
    }

    /** Logic to find a given pair in a set with a given target sum.
     * @return the product of the two numbers, or 0 if none were found. */
    private static int findPairWithSum(Set<Integer> set, int target) {
        if (target <= 0) return 0;
        // TODO: Only loop over numbers smaller than half?
        for (int first : set) {
            int second = target - first;
            if (set.contains(second)) {
                return first * second;
            }
        }
        return 0;
    }

    /** Function to find a product of two numbers in a list with a given sum. */
    static int findProductOfTwo(List<Integer> list, int target) {
        Set<Integer> sorted = new TreeSet<>(list);
        return findPairWithSum(sorted, target);
    }

    /** Function to find a product of three numbers in a list with a given sum. */
    static int findProductOfThree(List<Integer> list, int target) {
        Set<Integer> sortedSet = new TreeSet<>();
        for (int num : list) {
            int remaining = target - num;
            int potentialProduct = findPairWithSum(sortedSet, remaining);
            if (potentialProduct > 0) {
                // println("Found triple: $num, ${potentialPair.first}, ${potentialPair.second}")
                return num * potentialProduct;
            }
            sortedSet.add(num);
        }
        throw new IllegalStateException("Could not find match");
    }

}