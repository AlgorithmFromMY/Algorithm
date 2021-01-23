package p2800;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParenthesisPairFinder {
    private List<ParenthesisPair> list;
    private Stack<Integer> stack;

    public void find(String expression){
        list = new ArrayList<>();
        stack = new Stack<>();

        for(int index = 0; index < expression.length(); index++){
            pushStackOrAddToParenthesisPairList(expression.charAt(index), index);
        }
    }

    public List<ParenthesisPair> getParenthesisPairList(){
        return list;
    }

    private void pushStackOrAddToParenthesisPairList(char ch, int index) {
        if(isOpenParenthesis(ch)){
            pushToStack(index);
        }

        if(isCloseParenthesis(ch)){
            addToParenthesisPairList(index);
        }
    }

    private boolean isOpenParenthesis(char ch){
        return String.valueOf(ch).equals("(");
    }

    private boolean isCloseParenthesis(char ch){
        return String.valueOf(ch).equals(")");
    }

    private void pushToStack(int index){
        stack.push(index);
    }

    private void addToParenthesisPairList(int index){
        list.add(new ParenthesisPair(stack.pop(), index));
    }
}
