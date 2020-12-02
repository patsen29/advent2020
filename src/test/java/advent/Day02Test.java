package advent;

import advent.Day02.PasswordVerificationRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Day02Test {
    @Test
    public void testPasswordCheck() {
        assertTrue(Day02.isValidPassword(
                new PasswordVerificationRequest(1, 3, 'a', "abcde")));
        assertFalse(Day02.isValidPassword(
                new PasswordVerificationRequest(1, 3, 'b', "cdefg")));
        assertTrue(Day02.isValidPassword(
                new PasswordVerificationRequest(2, 9, 'c', "ccccccccc")));
    }

    @Test
    public void testPasswordCheckSecondType() {
        assertTrue(Day02.isValidPasswordSecond(
                new PasswordVerificationRequest(1, 3, 'a', "abcde")));
        assertFalse(Day02.isValidPasswordSecond(
                new PasswordVerificationRequest(1, 3, 'b', "cdefg")));
        assertFalse(Day02.isValidPasswordSecond(
                new PasswordVerificationRequest(2, 9, 'c', "ccccccccc")));
    }
}