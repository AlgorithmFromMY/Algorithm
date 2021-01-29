package p2800;

public class ExpressionConvertor {
    public String removePadding(String expression){
        return expression.replace(" ", "");
    }

    public String replaceParenthesisToPadding(String expression, ParenthesisPair pair) {
        return beforeOpenParenthesis(expression, pair) + " " + insideParenthesis(expression, pair) + " " + afterCloseParenthesis(expression, pair);
    }

    private String beforeOpenParenthesis(String expression, ParenthesisPair pair){
        return expression.substring(0, pair.openIndex);
    }

    private String insideParenthesis(String expression, ParenthesisPair pair){
        return expression.substring(pair.openIndex + 1, pair.closeIndex);
    }

    private String afterCloseParenthesis(String expression, ParenthesisPair pair){
        return expression.substring(pair.closeIndex + 1);
    }
}
