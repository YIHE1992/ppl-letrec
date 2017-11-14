package yi.letlangproj.exp;

import yi.letlangproj.ExpressionParser;
import yi.letlangproj.ParseException;
import yi.letlangproj.Token;

import java.util.List;

import static yi.letlangproj.Parser.expectToken;
import static yi.letlangproj.Parser.parseToExpression;
import static yi.letlangproj.TokenType.*;

public class IsZeroExpressionParser implements ExpressionParser {
    @Override
    public ParseResult parse(List<Token> tokenList) throws ParseException {
        List<Token> t = tokenList;
        try {
            expectToken(t, IS_ZERO);
            t = t.subList(1, t.size());
        } catch(ParseException e) {
            return null;
        }
        expectToken(t, LEFT_PARENTHESIS);
        t = t.subList(1, t.size());
        ParseResult argExpressionParseResult = parseToExpression(t);
        t = t.subList(argExpressionParseResult.getTokenLength(), t.size());
        expectToken(t, RIGHT_PARENTHESIS);
        t = t.subList(1, t.size());
        return new ParseResult(new IsZeroExpression(argExpressionParseResult.getExpression()), tokenList.size() - t.size());
    }
}
