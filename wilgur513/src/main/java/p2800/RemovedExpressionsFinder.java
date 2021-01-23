package p2800;

import java.util.*;

public class RemovedExpressionsFinder {
    private ParenthesisPairFinder finder;
    private ExpressionConvertor convertor;

    public RemovedExpressionsFinder() {
        this.finder = new ParenthesisPairFinder();
        this.convertor = new ExpressionConvertor();
    }

    public List<String> getExpressionList(String expression) {
        finder.find(expression);
        return sort(excludeItSelfAndRemoveDuplication(findExpressionList(0, expression), expression));
    }

    private ArrayList<String> findExpressionList(int pairIndex, String expression) {
        return isLastParenthesisPair(pairIndex) ? onlyOneExpression(expression) : findExpressionRecursively(pairIndex, expression);
    }

    private boolean isLastParenthesisPair(int index){
        return index == finder.getParenthesisPairList().size();
    }

    private ArrayList<String> onlyOneExpression(String expression){
        return new ArrayList<>(Arrays.asList(convertor.removePadding(expression)));
    }

    private ArrayList<String> findExpressionRecursively(int pairIndex, String expression){
        ArrayList<String> result = new ArrayList<>();
        result.addAll(findExpressionList(pairIndex + 1, expression));
        result.addAll(findExpressionList(pairIndex + 1,
                convertor.replaceParenthesisToPadding(expression, finder.getParenthesisPairList().get(pairIndex))));

        return result;
    }

    private List<String> excludeItSelfAndRemoveDuplication(ArrayList<String> list, String expression){
        list.remove(expression);
        return new ArrayList<>(new HashSet<>(list));
    }

    private List<String> sort(List<String> list) {
        Collections.sort(list);
        return list;
    }
}
