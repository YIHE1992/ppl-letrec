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
public class FunctionDefineExpressionParser implements ExpressionParser {
    @Override
    public ParseResult parse(List<Token> tokenList) throws ParseException {
        List<Token> t = tokenList;
        try {
            expectToken(t, PROC);
            t = t.subList(1, t.size());
        } catch(ParseException e) {
            return null;
        }
        expectToken(t, LEFT_PARENTHESIS);
        t = t.subList(1, t.size());
        LinkedList<String> argNameList = new LinkedList<>();
        try {
            argNameList.add(expectToken(t, IDENTIFIER).getData());
            t = t.subList(1, t.size());
            while(true) {
                expectToken(t, COMMA);
                t = t.subList(1, t.size());
                argNameList.add(expectToken(t, IDENTIFIER).getData());
                t = t.subList(1, t.size());
            }
        } catch(ParseException ignored) {
        }
        expectToken(t, RIGHT_PARENTHESIS);
        t = t.subList(1, t.size());
        ParseResult functionBodyParseResult = parseToExpression(t);
        t = t.subList(functionBodyParseResult.getTokenLength(), t.size());
        return new ParseResult(new FunctionDefineExpression(argNameList.toArray(new String[0]), functionBodyParseResult.getExpression()),
                               tokenList.size() - t.size());
    }
}
