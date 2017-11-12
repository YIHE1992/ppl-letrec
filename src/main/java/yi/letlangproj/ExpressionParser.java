package yi.letlangproj;

import java.util.List;

/**
 * @author sky91 - feitiandaxia1991@163.com
 */
public interface ExpressionParser {
    /**
     * parse token list to expression
     *
     * @return null if tokens does not matched, or a parse result
     * @throws ParseException when grammar is wrong
     */
    ParseResult parse(List<Token> tokenList) throws ParseException;

    class ParseResult {
        private final Expression expression;
        private final int tokenLength;

        public ParseResult(Expression expression, int tokenLength) {
            this.expression = expression;
            this.tokenLength = tokenLength;
        }

        public Expression getExpression() {
            return expression;
        }

        public int getTokenLength() {
            return tokenLength;
        }
    }
}
