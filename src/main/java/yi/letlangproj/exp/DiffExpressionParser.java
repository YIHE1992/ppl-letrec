package yi.letlangproj.exp;

import yi.letlangproj.ExpressionParser;
import yi.letlangproj.ParseException;
import yi.letlangproj.Token;

import java.util.List;

import static yi.letlangproj.Parser.expectToken;
import static yi.letlangproj.Parser.parseToExpression;
import static yi.letlangproj.TokenType.*;

/**
 * @author sky91 - feitiandaxia1991@163.com
 */
public class DiffExpressionParser implements ExpressionParser {
    @Override
    public ParseResult parse(List<Token> tokenList, final int start) throws ParseException {
        int len = 0;
        try {
            expectToken(tokenList, start + len++, MINUS);
            expectToken(tokenList, start + len++, LEFT_PARENTHESIS);
        } catch(ParseException e) {
            return null;
        }
        ParseResult expression0ParseResult = parseToExpression(tokenList, start + len);
        len += expression0ParseResult.getTokenLength();
        expectToken(tokenList, start + len++, COMMA);
        ParseResult expression1ParseResult = parseToExpression(tokenList, start + len);
        len += expression1ParseResult.getTokenLength();
        expectToken(tokenList, start + len++, RIGHT_PARENTHESIS);
        return new ParseResult(new DiffExpression(expression0ParseResult.getExpression(), expression1ParseResult.getExpression()), len);
    }
}
