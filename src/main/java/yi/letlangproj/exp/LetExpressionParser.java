package yi.letlangproj.exp;

import yi.letlangproj.ExpressionParser;
import yi.letlangproj.ParseException;
import yi.letlangproj.Token;

import java.util.LinkedList;
import java.util.List;

import static yi.letlangproj.Parser.expectToken;
import static yi.letlangproj.Parser.parseToExpression;
import static yi.letlangproj.TokenType.*;

/**
 * @author sky91 - feitiandaxia1991@163.com
 */
public class LetExpressionParser implements ExpressionParser {
    @Override
    public ParseResult parse(List<Token> tokenList) throws ParseException {
        List<Token> t = tokenList;
        try {
            expectToken(t, LET);
            t = t.subList(1, t.size());
        } catch(ParseException e) {
            return null;
        }
        Token varNameToken = expectToken(t, IDENTIFIER);
        t = t.subList(1, t.size());
        expectToken(t, ASSIGN);
        t = t.subList(1, t.size());
        LinkedList<String> argNameList = new LinkedList<>();
        try {
            List<Token> tFunction = t;
            expectToken(tFunction, PROC);
            tFunction = tFunction.subList(1, tFunction.size());
            expectToken(tFunction, LEFT_PARENTHESIS);
            tFunction = tFunction.subList(1, tFunction.size());
            try {
                argNameList.add(expectToken(tFunction, IDENTIFIER).getData());
                tFunction = tFunction.subList(1, tFunction.size());
                while(true) {
                    expectToken(tFunction, COMMA);
                    tFunction = tFunction.subList(1, tFunction.size());
                    argNameList.add(expectToken(tFunction, IDENTIFIER).getData());
                    tFunction = tFunction.subList(1, tFunction.size());
                }
            } catch(ParseException ignored) {
            }
            expectToken(tFunction, RIGHT_PARENTHESIS);
            t = tFunction.subList(1, tFunction.size());
        } catch(ParseException e) {
        }
        ParseResult functionBodyExpressionParseResult = parseToExpression(t);
        t = t.subList(functionBodyExpressionParseResult.getTokenLength(), t.size());
        expectToken(t, IN);
        t = t.subList(1, t.size());
        ParseResult letValueExpressionParseResult = parseToExpression(t);
        t = t.subList(letValueExpressionParseResult.getTokenLength(), t.size());
        return new ParseResult(new LetExpression(varNameToken.getData(),
                                                 argNameList.toArray(new String[0]),
                                                 functionBodyExpressionParseResult.getExpression(),
                                                 letValueExpressionParseResult.getExpression()), tokenList.size() - t.size());
    }
}
