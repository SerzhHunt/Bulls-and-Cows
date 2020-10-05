package bullscows.grader;

public class Grader {
    public void getGrade(String hiddenValue, String requestedValue) {
        comparingPreparedWithCurrentNumber(hiddenValue, requestedValue);
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
        getComparisonResult(bulls, cows);
    }


    private void getComparisonResult(int bulls, int cows) {
        if (bulls == 4) {
            System.out.printf("Grade: %d bulls\n" +
                    "Congratulations! You guessed the secret code.",bulls);
        } else if (bulls > 0 && cows == 0) {
            System.out.printf("Grade: %d bull(s).\n", bulls);
        } else if (cows > 0 && bulls == 0) {
            System.out.printf("Grade: %d cow(s).\n", cows);
        } else if (bulls > 0 && cows > 0) {
            System.out.printf("Grade: %d bull(s) and %d cow(s).\n", bulls, cows);
        } else {
            System.out.println("Grade: None.");
        }
    }
}
