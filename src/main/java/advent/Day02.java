package advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day02 {
    static final Pattern regexPattern = Pattern.compile("(\\d+)-(\\d+) ([a-z]): (.+)");

    public static void main(String[] args) throws IOException {
        String filename = "src/main/resources/day02.txt";
        List<String> lines = Files.readAllLines(Paths.get(filename));
        long count = lines.stream()
                .filter(Day02::isValidPassword)
                .count();
        System.out.println("Part 1: " + count);
    }

    /** Helper function to parse the lines from the input file, and call the more specific logic. */
    static boolean isValidPassword(String line) {
        Matcher matcher = regexPattern.matcher(line);
        if (!matcher.find()) {
            return false;
        }
        int minAllowed = Integer.parseInt(matcher.group(1));
        int maxAllowed = Integer.parseInt(matcher.group(2));
        char targetChar = matcher.group(3).charAt(0);
        String password = matcher.group(4);
        return isValidPassword(minAllowed, maxAllowed, targetChar, password);
    }

    /** Determines whether a given password fills the given constraints. */
    static boolean isValidPassword(int minAllowed, int maxAllowed, char targetChar, String password) {
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) == targetChar) {
                count++;
            }
        }
        return (count >= minAllowed && count <= maxAllowed);
    }
}