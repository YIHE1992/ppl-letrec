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
    public ParseResult parse(List<Token> tokenList, int start) throws ParseException {
        int len = 0;
        try {
            expectToken(tokenList, start + len++, PROC);
        } catch(ParseException e) {
            return null;
        }
        expectToken(tokenList, start + len++, LEFT_PARENTHESIS);
        LinkedList<String> argNameList = new LinkedList<>();
        try {
            argNameList.add(expectToken(tokenList, start + len, IDENTIFIER).getData());
            len++;
            while(true) {
                expectToken(tokenList, start + len, COMMA);
                len++;
                argNameList.add(expectToken(tokenList, start + len, IDENTIFIER).getData());
                len++;
            }
        } catch(ParseException ignored) {
        }
        expectToken(tokenList, start + len++, RIGHT_PARENTHESIS);
        ParseResult functionBodyParseResult = parseToExpression(tokenList, start + len);
        len += functionBodyParseResult.getTokenLength();
        return new ParseResult(new FunctionDefineExpression(argNameList.toArray(new String[0]), functionBodyParseResult.getExpression()), len);
    }
}
