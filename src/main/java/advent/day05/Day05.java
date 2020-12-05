package advent.day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Day05 {
    public static void main(String[] args) throws IOException {
        List<BoardingPass> passes = Files.readAllLines(Paths.get("src/main/resources/day05.txt")).stream()
                .map(Day05::parsePass)
                .collect(Collectors.toList());
        System.out.println("Part 1: " + findHighestPass(passes));
    }

    public static BoardingPass parsePass(String code) {
        int id = 0;
        for (int i = 0; i < code.length(); i++) {
            id *= 2;
            char ch = code.charAt(i);
            if (ch == 'B' || ch == 'R') {
                id++;
            }
        }
        int row = id / 8;
        int col = id % 8;
        return new BoardingPass(row, col);
    }

    public static int findHighestPass(List<BoardingPass> passes) {
        return passes.stream()
                .max(BoardingPass::compareTo)
                .map(BoardingPass::getSeatId)
                .orElse(-1);
    }
}