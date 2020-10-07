package bullscows.game.check;

public class Input {
    private static final int MAX_SIZE_UNIQUE_VALUE = 36;

    public int checkMaximumNumbersOfPossibleSymbols(int lengthValue) {
        if (lengthValue > MAX_SIZE_UNIQUE_VALUE) {
            throw new IllegalArgumentException("Error: " +
                    "maximum number of possible symbols in the code is 36 (0-9, a-z).");
        } else if (lengthValue <= 0) {
            throw new IllegalArgumentException("Error: length can not zero!");
        }
        return lengthValue;
    }

    public void checkLengthAndNumberOfUniqueChar(int lengthValue, int rangeValue) {
        if (lengthValue > rangeValue) {
            throw new IllegalArgumentException("Error: it's not possible to generate a code with a length of " +
                    lengthValue + " with " + rangeValue + " unique symbols.");
        }
    }

    public int checkForValidNumbers(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error: " + number + " isn't a valid number.");
        }
    }
}
