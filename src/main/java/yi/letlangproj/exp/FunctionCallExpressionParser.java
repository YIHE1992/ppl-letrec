package yi.letlangproj.exp;

import yi.letlangproj.Expression;
import yi.letlangproj.ExpressionParser;
import yi.letlangproj.ParseException;
import yi.letlangproj.Token;

import java.util.LinkedList;
import java.util.List;

import static yi.letlangproj.Parser.expectToken;
import static yi.letlangproj.Parser.parseToExpression;
import static yi.letlangproj.TokenType.*;

public class FunctionCallExpressionParser implements ExpressionParser {
    @Override
    public ParseResult parse(List<Token> tokenList) throws ParseException {
        List<Token> t = tokenList;
        try {
            expectToken(t, LEFT_PARENTHESIS);
            t = t.subList(1, t.size());
        } catch(ParseException e) {
            return null;
        }
        Token functionNameToken = expectToken(t, IDENTIFIER);
        t = t.subList(1, t.size());
        LinkedList<Expression> expressionList = new LinkedList<>();
        try {
            while(true) {
                ParseResult parseResult = parseToExpression(t);
                t = t.subList(parseResult.getTokenLength(), t.size());
                expressionList.add(parseResult.getExpression());
            }
        } catch(ParseException ignored) {
        }
        expectToken(t, RIGHT_PARENTHESIS);
        t = t.subList(1, t.size());
        return new ParseResult(new FunctionCallExpression(functionNameToken.getData(), expressionList.toArray(new Expression[0])),
                               tokenList.size() - t.size());
    }
}
