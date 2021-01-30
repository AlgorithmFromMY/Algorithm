package p1644;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num = new Scanner(System.in).nextInt();
        if(num == 1){
            System.out.println(0);
        }else{
            System.out.println(PrimeCounter.create(num).getCount());
        }
    }
}
