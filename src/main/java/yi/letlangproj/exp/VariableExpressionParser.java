package yi.letlangproj.exp;

import yi.letlangproj.ExpressionParser;
import yi.letlangproj.ParseException;
import yi.letlangproj.Parser;
import yi.letlangproj.Token;

import java.util.List;

import static yi.letlangproj.TokenType.IDENTIFIER;

public class VariableExpressionParser implements ExpressionParser {
    @Override
    public ParseResult parse(List<Token> tokenList) throws ParseException {
        Token token;
        try {
            token = Parser.expectToken(tokenList, IDENTIFIER);
        } catch(ParseException e) {
            return null;
        }
        return new ParseResult(new VariableExpression(token.getData()), 1);
    }
}
