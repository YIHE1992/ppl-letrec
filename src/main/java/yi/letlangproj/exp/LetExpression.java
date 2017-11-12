package yi.letlangproj.exp;

import yi.letlangproj.Environment;
import yi.letlangproj.Expression;

/**
 * @author sky91 - feitiandaxia1991@163.com
 */
public class LetExpression implements Expression {
    private final String varName;
    private final Expression varValueExpression;
    private final Expression letValueExpression;

    LetExpression(String varName, Expression varValueExpression, Expression letValueExpression) {
        this.varName = varName;
        this.varValueExpression = varValueExpression;
        this.letValueExpression = letValueExpression;
    }

    @Override
    public int evaluate(Environment environment) {
        return 0;
    }
}
