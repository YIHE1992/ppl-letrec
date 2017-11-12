package yi.letlangproj.exp;

import yi.letlangproj.Environment;
import yi.letlangproj.Expression;

/**
 * @author sky91 - feitiandaxia1991@163.com
 */
public class VariableExpression implements Expression {
    private final String name;

    VariableExpression(String name) {
        this.name = name;
    }

    @Override
    public int evaluate(Environment environment) {
        return 0;
    }

}
