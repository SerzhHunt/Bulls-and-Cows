package bullscows.grader;

import bullscows.gen.imp.HiddenValue;

public class Grader {
    private final HiddenValue hiddenValue;
    private static final int MAX_SIZE_UNIQUE_VALUE = 4;

    public Grader() {
        hiddenValue = new HiddenValue();
    }

    public void getGrade(String answer) {
        String genValue = hiddenValue.generate(MAX_SIZE_UNIQUE_VALUE);
        comparingPreparedWithCurrentNumber(genValue, answer);
    }

    private void comparingPreparedWithCurrentNumber(String hiddenValue, String requestedValue) {
        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < hiddenValue.length(); i++) {
            if (hiddenValue.charAt(i) == requestedValue.charAt(i)) {
                bulls++;
                continue;
            }
            for (int j = 0; j < requestedValue.length(); j++) {
                if (hiddenValue.charAt(i) == requestedValue.charAt(j)) {
                    cows++;
                }
            }
        }
        getComparisonResult(hiddenValue, bulls, cows);
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
}
