package yi.letlangproj.exp;

import yi.letlangproj.Environment;
import yi.letlangproj.Expression;

/**
 * @author sky91 - feitiandaxia1991@163.com
 */
public class IsZeroExpression implements Expression {
    private final Expression expression;

    public IsZeroExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public int evaluate(Environment environment) {
        return expression.evaluate(environment) == 0 ? 1 : 0;
    }
}
