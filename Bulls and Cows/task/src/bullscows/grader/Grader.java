package bullscows.grader;

import bullscows.gen.imp.HiddenNumber;

import java.util.Arrays;

public class Grader {
    private final HiddenNumber hiddenNumber;

    public Grader() {
        hiddenNumber = new HiddenNumber();
    }

    public void getGrade(String answer) {
        int[] requestedNumber = getNumericArray(answer);
        comparingPreparedWithCurrentNumber(requestedNumber);
    }

    private void comparingPreparedWithCurrentNumber(int[] requestedNumber) {
        int bulls = 0;
        int cows = 0;
        String hidden = hiddenNumber.generate();
        int[] preparedNumber = getNumericArray(hidden);

        for (int i = 0; i < preparedNumber.length; i++) {
            for (int j = 0; j < requestedNumber.length; j++) {
                if (preparedNumber[i] == requestedNumber[i]) {
                    bulls++;
                    break;
                } else if (preparedNumber[i] == requestedNumber[j]) {
                    cows++;
                }
            }
        }
        getComparisonResult(hidden, bulls, cows);
    }

    private void getComparisonResult(String hiddenNumber, int bulls, int cows) {
        if (bulls > 0 && cows == 0) {
            System.out.printf("Grade: %d bull(s). The secret code is %s.", bulls, hiddenNumber);
        } else if (cows > 0 && bulls == 0) {
            System.out.printf("Grade: %d cow(s). The secret code is %s.", cows, hiddenNumber);
        } else if (bulls > 0 && cows > 0) {
            System.out.printf("Grade: %d bull(s) and %d cow(s). The secret code is %s.",
                    bulls, cows, hiddenNumber);
        } else {
            System.out.printf("Grade: None. The secret code is %s.", hiddenNumber);
        }
    }

    private int[] getNumericArray(String word) {
        return Arrays
                .stream(word.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
