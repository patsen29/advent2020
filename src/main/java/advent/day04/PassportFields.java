package advent.day04;

import java.util.Arrays;

enum PassportFields {
    BIRTH_YEAR("byr"),
    ISSUE_YEAR("iyr"),
    EXPIRATION_YEAR("eyr"),
    HEIGHT("hgt"),
    HAIR_COLOUR("hcl"),
    EYE_COLOUR("ecl"),
    PASSPORT_ID("pid"),
    COUNTRY_ID("cid");

    String key;

    PassportFields(String key) {
        this.key = key;
    }

    static PassportFields byKey(String key) {
        return Arrays.stream(PassportFields.values())
                .filter(field -> field.key.equals(key))
                .findFirst()
                .orElse(null);
    }
}
