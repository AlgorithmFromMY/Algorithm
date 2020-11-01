package p1411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<String, Integer> map;

    public static void main(String[] args) throws IOException {
        inputData();
        solve();
    }

    private static void inputData() throws IOException {
        int n = Integer.valueOf(reader.readLine());
        map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String value = convert(reader.readLine());
            if(map.get(value) == null)
                map.put(value, 0);

            map.put(value, map.get(value) + 1);
        }
    }

    private static String convert(String input) {
        String result = input;

        for(int i = 0; i < input.length(); i++)
            if(Character.isAlphabetic(input.charAt(i)))
                result = result.replaceAll(String.valueOf(input.charAt(i)), String.valueOf(i));

        return result;
    }

    private static void solve() {
        int result = 0;

        for(String key : map.keySet()){
            int value = map.get(key);
            result += value * (value - 1) / 2;
        }

        System.out.println(result);
    }
}
