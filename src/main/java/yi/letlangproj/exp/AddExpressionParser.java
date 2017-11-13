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
public class AddExpressionParser implements ExpressionParser {
    @Override
    public ParseResult parse(List<Token> tokenList) throws ParseException {
        List<Token> t = tokenList;
        try {
            expectToken(t, PLUS);
            t = t.subList(1, t.size());
        } catch(ParseException e) {
            return null;
        }
        expectToken(t, LEFT_PARENTHESIS);
        t = t.subList(1, t.size());
        ParseResult expression0ParseResult = parseToExpression(t);
        t = t.subList(expression0ParseResult.getTokenLength(), t.size());
        expectToken(t, COMMA);
        t = t.subList(1, t.size());
        ParseResult expression1ParseResult = parseToExpression(t);
        t = t.subList(expression1ParseResult.getTokenLength(), t.size());
        expectToken(t, RIGHT_PARENTHESIS);
        t = t.subList(1, t.size());
        return new ParseResult(new AddExpression(expression0ParseResult.getExpression(), expression1ParseResult.getExpression()),
                               tokenList.size() - t.size());
    }
}
