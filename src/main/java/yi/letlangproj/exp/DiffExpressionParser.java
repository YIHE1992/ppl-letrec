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
    public ParseResult parse(List<Token> tokenList) throws ParseException {
        List<Token> t = tokenList;
        try {
            expectToken(t, MINUS);
            t = t.subList(1, t.size());
            expectToken(t, LEFT_PARENTHESIS);
            t = t.subList(1, t.size());
        } catch(ParseException e) {
            return null;
        }
        ParseResult expression0ParseResult = parseToExpression(t);
        t = t.subList(expression0ParseResult.getTokenLength(), t.size());
        expectToken(t, COMMA);
        t = t.subList(1, t.size());
        ParseResult expression1ParseResult = parseToExpression(t);
        t = t.subList(expression1ParseResult.getTokenLength(), t.size());
        expectToken(t, RIGHT_PARENTHESIS);
        t = t.subList(1, t.size());
        return new ParseResult(new DiffExpression(expression0ParseResult.getExpression(), expression1ParseResult.getExpression()),
                               tokenList.size() - t.size());
    }
}
