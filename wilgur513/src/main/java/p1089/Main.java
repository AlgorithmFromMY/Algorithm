package p1089;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static String[] numbers;
    private static NumberSplitter splitter;
    private static Convertor convertor;
    private static NumberIdentifier identifier;
    private static List<Integer>[] lists;

    public static void main(String[] args) throws IOException {
        inputData();
        init();
        solve();
    }

    private static void inputData() throws IOException {
        n = Integer.valueOf(reader.readLine());
        numbers = new String[5];

        for(int i = 0; i < 5; i++)
            numbers[i] = reader.readLine();
    }

    private static void init() {
        splitter = new NumberSplitter(numbers);
        convertor = new Convertor();
        identifier = new NumberIdentifier();
        lists = makeNumberLists();
    }

    private static List[] makeNumberLists(){
        List<Integer>[] list = new List[n];
        int index = 0;

        while(splitter.hasNext()){
            int bit = convertor.convert(splitter.next());
            list[index++] = identifier.identify(bit);
        }

        return list;
    }

    private static void solve() {
        if(hasEmptyList())
            System.out.println(-1);
        else
            System.out.println(average());
    }

    public static boolean hasEmptyList(){
        for(List list : lists){
            if(list.isEmpty())
                return true;
        }

        return false;
    }

    private static double average() {
        long count = count();
        return sum(count) / count;
    }

    private static double sum(long count){
        double sum = 0.0;

        for(int i = 0; i < lists.length; i++){
            for(int v : lists[i])
                sum += (count / lists[i].size()) * (v * Math.pow(10, lists.length - i - 1));
        }

        return sum;
    }

    private static long count(){
        long count = 1;

        for(int i = 0; i < lists.length; i++)
            count *= lists[i].size();

        return count;
    }
}
