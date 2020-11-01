package p1089;

public class NumberSplitter {
    private final String[] numbers;
    private int index;

    public NumberSplitter(String[] numbers) {
        this.numbers = numbers;
        index = 0;
    }

    public boolean hasNext(){
        return index < numbers[0].length();
    }

    public String[] next() {
        String[] result = splitCurrentNumber();

        index += 4;

        return result;
    }

    private String[] splitCurrentNumber(){
        String[] result = new String[5];

        for(int i = 0; i < 5; i++){
            result[i] = numbers[i].substring(index, index + 3);
        }

        return result;
    }
}
