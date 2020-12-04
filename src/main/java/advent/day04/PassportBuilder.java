package advent.day04;

import java.util.HashMap;
import java.util.Map;

import static advent.day04.PassportFields.*;

public class PassportBuilder {

    private final Map<PassportFields, String> fields = new HashMap<>();

    public void parseRow(String line) {
        String[] pairs = line.split(" ");
        for (String pair : pairs) {
            String[] tokens = pair.split(":");
            setValue(tokens[0], tokens[1]);
        }
    }

    public void setValue(String key, String value) {
        PassportFields field = PassportFields.byKey(key);
        if (field == null) {
            throw new IllegalArgumentException("Could not set field " + key);
        }
        fields.put(field, value);
    }

    public Passport build() {
        return new Passport(
                fields.get(BIRTH_YEAR),
                fields.get(ISSUE_YEAR),
                fields.get(EXPIRATION_YEAR),
                fields.get(HEIGHT),
                fields.get(HAIR_COLOUR),
                fields.get(EYE_COLOUR),
                fields.get(PASSPORT_ID),
                fields.get(COUNTRY_ID)
        );
    }
}
