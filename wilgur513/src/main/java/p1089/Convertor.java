package p1089;

public class Convertor {
    public int convert(String[] number) {
        return convertAllLine(number);
    }

    private int convertAllLine(String[] s){
        int bit = 0;

        for(int i = 0; i < 5; i++){
            bit |= convertLine(s[i]) << 3 * (4 - i);
        }

        return bit;
    }

    private int convertLine(String s){
        int bit = 0;

        for(int i = 0; i < 3; i++){
            bit |= convertCharacter(s.charAt(i), i);
        }

        return bit;
    }

    private int convertCharacter(char ch, int index){
        if(ch == '#')
            return 1 << (2 - index);

        return 0;
    }
}
