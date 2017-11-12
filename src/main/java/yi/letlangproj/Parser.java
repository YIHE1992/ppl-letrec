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

    public static ParseResult parseToExpression(List<Token> tokenList) throws ParseException {
        for(ExpressionParser parser : registeredExpressionParser) {
            ParseResult expression = parser.parse(tokenList);
            if(expression != null) {
                return expression;
            }
        }
        throw new ParseException("cannot parse to any expression");
    }

    public static Token expectToken(List<Token> tokenList, TokenType tokenType) throws ParseException {
        Token token = tokenList.get(0);
        if(token.getType() != tokenType) {
            throw new ParseException("token type [" + tokenType + "] expected but found [" + token + "]");
        }
        return token;
    }
}
