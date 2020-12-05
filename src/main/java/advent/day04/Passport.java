package advent.day04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Passport {
    final String birthYear, issueYear, expirationYear, height, hairColour, eyeColour, passportId, countryId;

    public Passport(String birthYear, String issueYear, String expirationYear, String height, String hairColour,
                    String eyeColour, String passportId, String countryId) {
        this.birthYear = birthYear;
        this.issueYear = issueYear;
        this.expirationYear = expirationYear;
        this.height = height;
        this.hairColour = hairColour;
        this.eyeColour = eyeColour;
        this.passportId = passportId;
        this.countryId = countryId;
    }

    public boolean isValid() {
        return (birthYear != null) && (issueYear != null) && (expirationYear != null) && (height != null) &&
                (hairColour != null) && (eyeColour != null) && (passportId != null);
        // ignoring countryId
    }

    private static final Pattern yearRegex = Pattern.compile("^\\d{4}$");
    private static final Pattern heightRegex = Pattern.compile("^(\\d{2,3})(cm|in)$");
    private static final Pattern hairColourRegex = Pattern.compile("^#[0-9a-f]{6}$");
    private static final Pattern eyeColourRegex = Pattern.compile("^(amb|blu|brn|gry|grn|hzl|oth)$");
    private static final Pattern passportIdRegex = Pattern.compile("^\\d{9}$");
    public boolean isValidExtended() {
        return yearValid(birthYear, 1920, 2002) &&
                yearValid(issueYear, 2010, 2020) &&
                yearValid(expirationYear, 2020, 2030) &&
                heightValid(height) &&
                regexValid(hairColour, hairColourRegex) &&
                regexValid(eyeColour, eyeColourRegex) &&
                regexValid(passportId, passportIdRegex);
    }

    public static boolean yearValid(String value, int min, int max) {
        if (value == null) return false;
        Matcher matcher = yearRegex.matcher(value);
        if (!matcher.find()) return false;
        int year = Integer.parseInt(value);
        return (year >= min) && (year <= max);
    }

    static boolean heightValid(String value) {
        if (value == null) return false;
        Matcher matcher = heightRegex.matcher(value);
        if (!matcher.find()) return false;
        int height = Integer.parseInt(matcher.group(1), 10);
        String unit = matcher.group(2);
        if (unit.equals("cm")) {
            return (height >= 150 && height <= 193);
        } else if (unit.equals("in")) {
            return (height >= 59 && height <= 76);
        }
        return false; // Can't happen?
    }

    static boolean regexValid(String value, Pattern regex) {
        if (value == null) return false;
        Matcher matcher = regex.matcher(value);
        return matcher.find();
    }
}