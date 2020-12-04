package advent.day04;

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
}