package bullscows.gen.imp;

import bullscows.gen.Generator;

import java.security.SecureRandom;
import java.util.Arrays;

public class HiddenValue implements Generator {
    private static final SecureRandom random = new SecureRandom();
    private static final String SYMBOLS_TO_GENERATE = "0123456789abcdefghijklmnopqrstuvwxyz";

    @Override
    public String generate(int lengthValue, int rangeValue) {
        StringBuilder result = new StringBuilder();
        result.append(getGeneratedValue(lengthValue, rangeValue));

        getIdeaOfHiddenValue(result.toString(), rangeValue);
        return result.toString();
    }

    private String getGeneratedValue(int lengthValue, int rangeValue) {
        StringBuilder uniqueValue = new StringBuilder();
        while (lengthValue > 0) {
            String randomValue = genUniqueValue(rangeValue);

            if (!checkUniqueValue(uniqueValue.toString(), randomValue)) {
                uniqueValue.append(randomValue);
                lengthValue--;
            }
        }
        return uniqueValue.toString();
    }

    private String genUniqueValue(int rangeValue) {
        String rangeToGenerate = SYMBOLS_TO_GENERATE.substring(0, rangeValue);
        return String.valueOf(
                rangeToGenerate.charAt(
                        random.nextInt(rangeToGenerate.length())));
    }

    private Boolean checkUniqueValue(String generatedValue, String randomValue) {
        return Arrays.
                stream(generatedValue.split(""))
                .anyMatch(value -> value.equals(String.valueOf(randomValue)));
    }

    private void getIdeaOfHiddenValue(String generatedValue, int rangeValue) {
        StringBuilder lengthValue = new StringBuilder();
        lengthValue.append("*".repeat(generatedValue.length()));

        if (rangeValue < 10) {
            System.out.printf("The secret is prepared: %s (0-%d).",
                    lengthValue.toString(), rangeValue);
        } else {
            System.out.printf("The secret is prepared: %s (0-9,a-%s).",
                    lengthValue.toString(), SYMBOLS_TO_GENERATE.charAt(rangeValue - 1));
        }
    }
}
