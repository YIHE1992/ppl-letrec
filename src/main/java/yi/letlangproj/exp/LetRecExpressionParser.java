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
public class LetRecExpressionParser implements ExpressionParser {
    @Override
    public ParseResult parse(List<Token> tokenList) throws ParseException {
        List<Token> t = tokenList;
        try {
            expectToken(t, LET_REC);
            t = t.subList(1, t.size());
        } catch(ParseException e) {
            return null;
        }
        Token functionNameToken = expectToken(t, IDENTIFIER);
        t = t.subList(1, t.size());
        expectToken(t, LEFT_PARENTHESIS);
        t = t.subList(1, t.size());
        Token argNameToken = expectToken(t, IDENTIFIER);
        t = t.subList(1, t.size());
        expectToken(t, RIGHT_PARENTHESIS);
        t = t.subList(1, t.size());
        expectToken(t, ASSIGN);
        t = t.subList(1, t.size());
        ParseResult functionBodyExpressionParseResult = parseToExpression(t);
        t = t.subList(functionBodyExpressionParseResult.getTokenLength(), t.size());
        expectToken(t, IN);
        t = t.subList(1, t.size());
        ParseResult letValueExpressionParseResult = parseToExpression(t);
        t = t.subList(letValueExpressionParseResult.getTokenLength(), t.size());
        return new ParseResult(new LetRecExpression(functionNameToken.getData(),
                                                    new String[]{argNameToken.getData()},
                                                    functionBodyExpressionParseResult.getExpression(),
                                                    letValueExpressionParseResult.getExpression()), tokenList.size() - t.size());
    }
}
