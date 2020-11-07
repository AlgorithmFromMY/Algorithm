package p14726;

public class CardNumber {
    public String twiceAndReduce(String number) {
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < number.length(); i++){
            builder.append(twiceAndReduceEvenPosition(i, number.charAt(i)));
        }

        return builder.toString();
    }

    private String twiceAndReduceEvenPosition(int index, char c){
        if(index % 2 != 0)
            return String.valueOf(c);

        int value = Integer.valueOf(String.valueOf(c));

        if(value <= 4)
            return twice(value);

        return reduce(twice(value));
    }

    private String twice(int value){
        int twice = value * 2;
        return String.valueOf(twice);
    }

    private String reduce(String value){
        int a = Integer.valueOf(value.substring(0, 1));
        int b = Integer.valueOf(value.substring(1, 2));

        return String.valueOf(a + b);
    }

    public int reduceToSum(String s) {
        int result = 0;

        for(char c : s.toCharArray()){
            result += Integer.valueOf(String.valueOf(c));
        }

        return result;
    }
}
