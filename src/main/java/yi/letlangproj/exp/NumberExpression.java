package yi.letlangproj.exp;

import yi.letlangproj.Environment;
import yi.letlangproj.Expression;

/**
 * @author sky91 - feitiandaxia1991@163.com
 */
public class NumberExpression implements Expression {
    private final int n;

    NumberExpression(int n) {
        this.n = n;
    }

    @Override
    public int evaluate(Environment environment) {
        return n;
    }
}
