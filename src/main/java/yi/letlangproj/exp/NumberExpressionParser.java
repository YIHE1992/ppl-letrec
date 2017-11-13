package yi.letlangproj.exp;

import yi.letlangproj.ExpressionParser;
import yi.letlangproj.ParseException;
import yi.letlangproj.Token;

import java.util.List;

import static yi.letlangproj.Parser.expectToken;
import static yi.letlangproj.TokenType.INT;

public class NumberExpressionParser implements ExpressionParser {
    @Override
    public ParseResult parse(List<Token> tokenList) throws ParseException {
        Token token;
        try {
            token = expectToken(tokenList, INT);
        } catch(ParseException e) {
            return null;
        }
        return new ParseResult(new NumberExpression(Integer.parseInt(token.getData())), 1);
    }
}
