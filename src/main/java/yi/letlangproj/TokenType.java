package yi.letlangproj;

/**
 * @author sky91 - feitiandaxia1991@163.com
 */
public enum TokenType {
    IS_ZERO("iszero"),
    IF("if"),
    THEN("then"),
    ELSE("else"),
    LET_REC("letrec"),
    LET("let"),
    IN("in"),
    PROC("proc"),
    INT("-?[0-9]+"),
    IDENTIFIER("-?[a-z]+"),
    LEFT_PARENTHESIS("[(]"),
    RIGHT_PARENTHESIS("[)]"),
    COMMA("[,]"),
    MINUS("[-]"),
    PLUS("[+]"),
    ASSIGN("[=]"),
    WHITE_SPACE("[ \t \f \r \n]+"),;
    public final String pattern;

    TokenType(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
