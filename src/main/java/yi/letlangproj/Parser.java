package yi.letlangproj;

import yi.letlangproj.ExpressionParser.ParseResult;
import yi.letlangproj.exp.*;

import java.util.List;

/**
 * @author sky91 - feitiandaxia1991@163.com
 */
public class Parser {
    private static final ExpressionParser[] registeredExpressionParser = {new DiffExpressionParser(),
                                                                          new LetExpressionParser(),
                                                                          new FunctionDefineExpressionParser(),
                                                                          new FunctionCallExpressionParser(),
                                                                          new NumberExpressionParser(),
                                                                          new VariableExpressionParser(),};

    public static ParseResult parseToExpression(List<Token> tokenList, int start) throws ParseException {
        for(ExpressionParser parser : registeredExpressionParser) {
            ParseResult expression = parser.parse(tokenList, start);
            if(expression != null) {
                return expression;
            }
        }
        throw new ParseException("cannot parse to any expression");
    }

    public static Token expectToken(List<Token> tokenList, final int start, TokenType tokenType) throws ParseException {
        Token token = tokenList.get(start);
        if(token.getType() != tokenType) {
            throw new ParseException("token type [" + tokenType + "] expected but found [" + token + "]");
        }
        return token;
    }
}
