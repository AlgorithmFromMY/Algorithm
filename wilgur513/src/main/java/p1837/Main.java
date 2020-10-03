package p1837;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String p = scanner.next();
        int k = scanner.nextInt();

        Password password = new Password(p, k);

        if(password.isSafe())
            System.out.println("GOOD");
        else
            System.out.println("BAD " + password.getUnsafeNumber());
    }
}
