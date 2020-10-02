package bullscows.gen.imp;

import bullscows.gen.Generateable;

import java.util.concurrent.ThreadLocalRandom;

public class HiddenNumber implements Generateable {
    private static final short MIN_RANGE_RANDOM_NUMBER = 1000;
    private static final short MAX_RANGE_RANDOM_NUMBER = 10000;

    @Override
    public String generate() {
        return String.valueOf(ThreadLocalRandom
                .current()
                .nextInt(MIN_RANGE_RANDOM_NUMBER, MAX_RANGE_RANDOM_NUMBER));
    }
}
