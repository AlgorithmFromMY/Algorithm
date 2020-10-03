package p11478;

import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static HashSet<String> set;
    private static String s;

    public static void main(String[] args) {
        initializeData();
        solve();
    }

    private static void initializeData() {
        s = scanner.next();
        set = new HashSet<>();
    }

    private static void solve() {
        for(int start = 0; start < s.length(); start++)
            for(int end = start + 1; end <= s.length(); end++){
                set.add(s.substring(start, end));
            }

        System.out.println(set.size());
    }
}
