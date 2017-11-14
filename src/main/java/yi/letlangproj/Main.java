package yi.letlangproj;

import yi.letlangproj.ExpressionParser.ParseResult;

import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        String s = "let x = 200 in let f = proc (z) -(z, x) in let x = 100 in let g = proc (z) -(z, x) in - ((f 1), (g 1))";
//        String s = "letrec double(x) = if iszero (x) then 0 else +((double -(x,1)),2) in (double 6)";
        List<Token> tokenList = new Scanner().scanToTokenList(s);
        for (int i = 0; i < tokenList.size(); i++)
            System.out.println(tokenList.get(i));
        ParseResult parseResult = Parser.parseToExpression(tokenList);
        Expression expression = parseResult.getExpression();
        System.out.println(expression.evaluate(new Environment(new HashMap<>())));
    }
}
