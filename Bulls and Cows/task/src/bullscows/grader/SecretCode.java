package bullscows.grader;

import bullscows.gen.imp.HiddenValue;

public class SecretCode {
    private final HiddenValue hiddenValue;

    public SecretCode() {
        hiddenValue = new HiddenValue();
    }

    public void getSecretCode(int length) {
        String genValue = hiddenValue.generate(length);
        if (!genValue.equals("")) {
            System.out.printf("The random secret number is %s.", genValue);
        }
    }
}
