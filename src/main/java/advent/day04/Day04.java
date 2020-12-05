package advent.day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Day04 {

    public static void main(String[] args) throws IOException {
        Path inputFile = Paths.get("src/main/resources/day04.txt");
        List<String> passportData = Files.readAllLines(inputFile);

        List<Passport> passports = parseData(passportData);
        System.out.println("Part 1: " + countValidPassports(passports, Passport::isValid));
        System.out.println("Part 2: " + countValidPassports(passports, Passport::isValidExtended));
    }

    public static List<Passport> parseData(List<String> rawData) {
        List<Passport> passports = new ArrayList<>();
        PassportBuilder builder = new PassportBuilder();
        for (String line : rawData) {
            if (line.equals("")) {
                passports.add(builder.build());
                builder = new PassportBuilder();
            } else {
                builder.parseRow(line);
            }
        }
        passports.add(builder.build());
        return passports;
    }

    public static long countValidPassports(List<Passport> passports, Predicate<Passport> predicate) {
        return passports.stream()
                .filter(predicate)
                .count();
    }
}