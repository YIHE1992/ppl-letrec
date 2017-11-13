package yi.letlangproj.exp;

import yi.letlangproj.Environment;
import yi.letlangproj.Expression;

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
