package bullscows;

import bullscows.grader.SecretCode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SecretCode secretCode = new SecretCode();
        secretCode.getSecretCode(scanner.nextInt());
    }
}
