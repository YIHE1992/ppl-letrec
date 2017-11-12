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

/**
 * @author sky91 - feitiandaxia1991@163.com
 */
public class FunctionCallExpressionParser implements ExpressionParser {
    @Override
    public ParseResult parse(List<Token> tokenList, int start) throws ParseException {
        int len = 0;
        try {
            expectToken(tokenList, start + len++, LEFT_PARENTHESIS);
        } catch(ParseException e) {
            return null;
        }
        Token functionNameToken = expectToken(tokenList, start + len++, IDENTIFIER);
        LinkedList<Expression> expressionList = new LinkedList<>();
        try {
            while(true) {
                ParseResult parseResult = parseToExpression(tokenList, start + len);
                len += parseResult.getTokenLength();
                expressionList.add(parseResult.getExpression());
            }
        } catch(ParseException ignored) {
        }
        expectToken(tokenList, start + len++, RIGHT_PARENTHESIS);
        return new ParseResult(new FunctionCallExpression(functionNameToken.getData(), expressionList.toArray(new Expression[0])), len);
    }
}
