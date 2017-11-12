package yi.letlangproj;

/**
 * @author sky91 - feitiandaxia1991@163.com
 */
public enum TokenType {
    INT("-?[0-9]+"),
    LEFT_PARENTHESIS("[(]"),
    RIGHT_PARENTHESIS("[)]"),
    COMMA("[,]"),
    MINUS("[-]"),
    PLUS("[+]"),
    ASSIGN("[=]"),
    IS_ZERO("iszero"),
    IF("if"),
    THEN("then"),
    ELSE("else"),
    LET("let"),
    IN("in"),
    IDENTIFIER("-?[a-z]+"),
    PROC("proc"),
    DOUBLE("double"),
    LET_REC("letrec"),
    WHITE_SPACE("[ \t \f \r \n]+"),;
    public final String pattern;

    TokenType(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
