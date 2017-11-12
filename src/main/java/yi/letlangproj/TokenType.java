package yi.letlangproj;

/**
 * @author sky91 - feitiandaxia1991@163.com
 */
public enum TokenType {
    LEFT_PARENTHESIS("[(]"),
    RIGHT_PARENTHESIS("[)]"),
    COMMA("[,]"),
    MINUS("[-]"),
    PLUS("[+]"),
    ASSIGN("[=]"),
    INT("-?[0-9]+"),
    IS_ZERO("iszero"),
    IF("if"),
    THEN("then"),
    ELSE("else"),
    LET("let"),
    IN("in"),
    PROC("proc"),
    DOUBLE("double"),
    LET_REC("letrec"),
    IDENTIFIER("-?[a-z]+"),
    WHITE_SPACE("[ \t \f \r \n]+"),;
    public final String pattern;

    TokenType(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
