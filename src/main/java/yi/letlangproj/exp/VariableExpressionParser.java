package yi.letlangproj.exp;

import yi.letlangproj.ExpressionParser;
import yi.letlangproj.ParseException;
import yi.letlangproj.Parser;
import yi.letlangproj.Token;

import java.util.List;

import static yi.letlangproj.TokenType.IDENTIFIER;

/**
 * @author sky91 - feitiandaxia1991@163.com
 */
public class VariableExpressionParser implements ExpressionParser {
    @Override
    public ParseResult parse(List<Token> tokenList, int start) throws ParseException {
        Token token;
        try {
            token = Parser.expectToken(tokenList, start, IDENTIFIER);
        } catch(ParseException e) {
            return null;
        }
        return new ParseResult(new VariableExpression(token.getData()), 1);
    }
}
