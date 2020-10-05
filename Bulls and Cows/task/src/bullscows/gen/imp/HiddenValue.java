package bullscows.gen.imp;

import bullscows.gen.Generateable;

import java.util.Arrays;
import java.util.Random;

public class HiddenValue implements Generateable {
    private final Random random = new Random();
    private final StringBuilder uniqueValue = new StringBuilder();
    private static final int MAX_SIZE_UNIQUE_VALUE = 10;
    private static final int RANGE_GENERATED_NUMBER = 10;

    @Override
    public String generate(int length) {
        if (length > MAX_SIZE_UNIQUE_VALUE) {
            System.out.println("Error: can't generate a secret number with a " +
                    "length of 11 because there aren't enough unique digits.");
            return "";
        }

        while (length > 0) {
            int randomValue = genUniqueValue();
            if (!checkUniqueValue(uniqueValue.toString(), randomValue)) {
                uniqueValue.append(randomValue);
                length--;
            }
        }
        return uniqueValue.toString();
    }

    private int genUniqueValue() {
        return random.nextInt(RANGE_GENERATED_NUMBER);
    }

    private Boolean checkUniqueValue(String value, int randomNumber) {
        return Arrays.stream(value.split(""))
                .anyMatch(s -> s.equals(String.valueOf(randomNumber)));
    }
}
