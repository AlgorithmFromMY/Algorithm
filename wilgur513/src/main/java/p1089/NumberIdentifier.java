package p1089;

import java.util.ArrayList;
import java.util.List;

public class NumberIdentifier {
    private int[] numbers = {0b111_101_101_101_111, 0b001_001_001_001_001, 0b111_001_111_100_111,
                             0b111_001_111_001_111, 0b101_101_111_001_001, 0b111_100_111_001_111,
                             0b111_100_111_101_111, 0b111_001_001_001_001, 0b111_101_111_101_111,
                             0b111_101_111_001_111};

    public List<Integer> identify(int bit) {
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < numbers.length; i++){
            if(canMakeThatNumber(numbers[i], bit))
                result.add(i);
        }

        return result;
    }

    private boolean canMakeThatNumber(int number, int input) {
        return (number | input) == number;
    }
}
