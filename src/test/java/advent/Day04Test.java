package advent;

import advent.day04.Day04;
import advent.day04.Passport;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Day04Test {
    private List<String> sampleData = Arrays.asList(
            "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd",
            "byr:1937 iyr:2017 cid:147 hgt:183cm",
            "",
            "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884",
            "hcl:#cfa07d byr:1929",
            "",
            "hcl:#ae17e1 iyr:2013",
            "eyr:2024",
            "ecl:brn pid:760753108 byr:1931",
            "hgt:179cm",
            "",
            "hcl:#cfa07d eyr:2025 pid:166559648",
            "iyr:2011 ecl:brn hgt:59in"
    );

    @Test
    public void testParsing() {
        List<Passport> passports = Day04.parseData(sampleData);
        assertEquals(4, passports.size());
    }

    @Test
    public void testValidityPart1() {
        List<Passport> passports = Day04.parseData(sampleData);

        assertTrue(passports.get(0).isValid());
        assertFalse(passports.get(1).isValid());
        assertTrue(passports.get(2).isValid());
        assertFalse(passports.get(3).isValid());

        assertEquals(2, Day04.countValidPassports(passports));
    }
}