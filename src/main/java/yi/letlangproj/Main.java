package yi.letlangproj;

import yi.letlangproj.ExpressionParser.ParseResult;

import java.util.HashMap;
import java.util.List;

/**
 * @author sky91 - feitiandaxia1991@163.com
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        String s = "let x = 200 in let f = proc (z) -(z, x) in let x = 100 in let g = proc (z) -(z, x) in - ((f 1), (g 1))";
        List<Token> tokenList = new Scanner().scanToTokenList(s);
        ParseResult parseResult = Parser.parseToExpression(tokenList);
        Expression expression = parseResult.getExpression();
        System.out.println(expression.evaluate(new Environment(new HashMap<>())));
    }
}
