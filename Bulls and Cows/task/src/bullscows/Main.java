package bullscows;

import bullscows.grader.Grader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Grader grader = new Grader();
        Scanner scanner = new Scanner(System.in);
        grader.getGrade(scanner.nextLine());
    }
}
