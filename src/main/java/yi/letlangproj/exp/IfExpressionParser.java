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
public class IfExpressionParser implements ExpressionParser {
    @Override
    public ParseResult parse(List<Token> tokenList) throws ParseException {
        List<Token> t = tokenList;
        try {
            expectToken(t, IF);
            t = t.subList(1, t.size());
        } catch(ParseException e) {
            return null;
        }
        ParseResult conditionExpressionParseResult = parseToExpression(t);
        t = t.subList(conditionExpressionParseResult.getTokenLength(), t.size());
        expectToken(t, THEN);
        t = t.subList(1, t.size());
        ParseResult trueExpressionParseResult = parseToExpression(t);
        t = t.subList(trueExpressionParseResult.getTokenLength(), t.size());
        expectToken(t, ELSE);
        t = t.subList(1, t.size());
        ParseResult falseExpressionParseResult = parseToExpression(t);
        t = t.subList(falseExpressionParseResult.getTokenLength(), t.size());
        return new ParseResult(new IfExpression(conditionExpressionParseResult.getExpression(),
                                                trueExpressionParseResult.getExpression(),
                                                falseExpressionParseResult.getExpression()), tokenList.size() - t.size());
    }
}
