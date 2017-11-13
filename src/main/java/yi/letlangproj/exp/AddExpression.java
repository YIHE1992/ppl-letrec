package yi.letlangproj.exp;

import yi.letlangproj.Environment;
import yi.letlangproj.Expression;

/**
 * @author sky91 - feitiandaxia1991@163.com
 */
public class AddExpression implements Expression {
    private final Expression e0;
    private final Expression e1;

    public AddExpression(Expression e0, Expression e1) {
        this.e0 = e0;
        this.e1 = e1;
    }

    @Override
    public int evaluate(Environment environment) {
        return e0.evaluate(environment) + e1.evaluate(environment);
    }
}
