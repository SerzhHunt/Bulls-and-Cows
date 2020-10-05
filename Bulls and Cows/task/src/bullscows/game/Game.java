package bullscows.game;

import bullscows.gen.imp.HiddenValue;
import bullscows.grader.Grader;

import java.util.Scanner;

public class Game {
    private final HiddenValue hiddenValue;
    private final Grader grader;
    private static final Scanner scanner = new Scanner(System.in);

    public Game() {
        hiddenValue = new HiddenValue();
        grader = new Grader();
    }

    public void gamePlay() {
        System.out.println("Please, enter the secret code's length:");
        String genValue = hiddenValue.generate(Integer.parseInt(scanner.nextLine()));
        System.out.println("Okay, let's start a game!");
        int attempt = 1;
        while (true) {
            System.out.printf("Turn %d:\n", attempt);
            String answer = scanner.nextLine();
            if (genValue.equals(answer)) {
                grader.getGrade(genValue, answer);
                break;
            } else {
                grader.getGrade(genValue, answer);
                attempt++;
            }
        }
    }
}
