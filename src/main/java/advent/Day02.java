package advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day02 {
    static final Pattern regexPattern = Pattern.compile("(\\d+)-(\\d+) ([a-z]): (.+)");

    public static void main(String[] args) throws IOException {
        String filename = "src/main/resources/day02.txt";
        List<PasswordVerificationRequest> requests = Files.readAllLines(Paths.get(filename)).stream()
                .map(Day02::parseLine)
                .collect(Collectors.toList());
        long countFirst = requests.stream().filter(Day02::isValidPassword).count();
        long countSecond = requests.stream().filter(Day02::isValidPasswordSecond).count();
        System.out.println("Part 1: " + countFirst);
        System.out.println("Part 2: " + countSecond);
    }

    static PasswordVerificationRequest parseLine(String line) {
        Matcher matcher = regexPattern.matcher(line);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Could not parse line " + line);
        }
        int first = Integer.parseInt(matcher.group(1));
        int second = Integer.parseInt(matcher.group(2));
        char targetChar = matcher.group(3).charAt(0);
        String password = matcher.group(4);
        return new PasswordVerificationRequest(first, second, targetChar, password);
    }

    /** Determines whether a given password fills the given constraints. */
    static boolean isValidPassword(PasswordVerificationRequest req) {
        int count = 0;
        for (int i = 0; i < req.password.length(); i++) {
            if (req.password.charAt(i) == req.targetChar) {
                count++;
            }
        }
        int minAllowed = req.first;
        int maxAllowed = req.second;
        return (count >= minAllowed && count <= maxAllowed);
    }

    static boolean isValidPasswordSecond(PasswordVerificationRequest req) {
        char first = req.password.charAt(req.first - 1);
        char second = req.password.charAt(req.second - 1);
        return (first == req.targetChar) ^ (second == req.targetChar); // ^ is XOR
    }

    static class PasswordVerificationRequest {
        final int first, second;
        final char targetChar;
        final String password; // this should probably be char[] if it was a real password

        PasswordVerificationRequest(int first, int second, char targetChar, String password) {
            this.first = first;
            this.second = second;
            this.targetChar = targetChar;
            this.password = password;
        }
    }
}