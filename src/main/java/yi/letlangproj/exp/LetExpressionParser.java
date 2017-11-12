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
public class LetExpressionParser implements ExpressionParser {
    @Override
    public ParseResult parse(List<Token> tokenList, final int start) throws ParseException {
        int len = 0;
        try {
            expectToken(tokenList, start + len++, LET);
        } catch(ParseException e) {
            return null;
        }
        Token varNameToken = expectToken(tokenList, start + len++, IDENTIFIER);
        expectToken(tokenList, start + len++, ASSIGN);
        ParseResult varValueExpressionParseResult = parseToExpression(tokenList, start + len);
        len += varValueExpressionParseResult.getTokenLength();
        expectToken(tokenList, start + len++, IN);
        ParseResult letValueExpressionParseResult = parseToExpression(tokenList, start + len);
        len += varValueExpressionParseResult.getTokenLength();
        return new ParseResult(new LetExpression(varNameToken.getData(),
                                                 varValueExpressionParseResult.getExpression(),
                                                 letValueExpressionParseResult.getExpression()), len);
    }
}
