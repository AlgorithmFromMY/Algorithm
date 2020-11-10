package p14726;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static CardNumber number = new CardNumber();

    public static void main(String[] args) {
        int testCase = scanner.nextInt();

        for(int i = 0; i < testCase; i++)
            runSingleTestCase();
    }

    private static void runSingleTestCase() {
        String card = scanner.next();
        int sum = number.reduceToSum(number.twiceAndReduce(card));

        System.out.println((sum % 10) == 0 ? "T" : "F");
    }
}
