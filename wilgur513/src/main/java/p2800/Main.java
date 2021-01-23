package p2800;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String expression = new Scanner(System.in).next();
        RemovedExpressionsFinder finder = new RemovedExpressionsFinder();
        for(String value : finder.getExpressionList(expression))
            System.out.println(value);
    }
}
