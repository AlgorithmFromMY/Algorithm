package p17478;

import java.util.Scanner;

public class Main {
    private static final String header = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
    private static final String[] body = {"\"재귀함수가 뭔가요?\"", "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
            "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.",
            "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\""};
    private static final String[] lastBody = {"\"재귀함수가 뭔가요?\"", "\"재귀함수는 자기 자신을 호출하는 함수라네\""};
    private static final String footer = "라고 답변하였지.";
    private static final String bodyPrefix = "____";
    private static Scanner scanner = new Scanner(System.in);
    private static int num;

    public static void main(String[] args) {
        inputData();
        solve();
    }

    private static void inputData() {
        num = scanner.nextInt();
    }

    private static void solve() {
        printHeader();
        printMessage("", 0);
    }

    private static void printHeader(){
        System.out.println(header);
    }

    private static void printMessage(String prefix, int level) {
        if(level == num + 1)
            return;

        printBody(prefix, level);
        printMessage(prefix + bodyPrefix, level + 1);
        printFooter(prefix, level);
    }

    private static void printBody(String prefix, int level) {
        if(level == num){
            for(String s : lastBody)
                System.out.println(prefix + s);
        }else{
            for(String s : body)
                System.out.println(prefix + s);
        }
    }

    private static void printFooter(String prefix, int level) {
        System.out.println(prefix + footer);
    }
}
