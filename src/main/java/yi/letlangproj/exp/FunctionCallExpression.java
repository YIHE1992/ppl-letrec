package yi.letlangproj.exp;

import yi.letlangproj.Environment;
import yi.letlangproj.Expression;

/**
 * @author sky91 - feitiandaxia1991@163.com
 */
public class FunctionCallExpression implements Expression {
    private final String functionName;
    private final Expression[] args;

    public FunctionCallExpression(String functionName, Expression[] args) {
        this.functionName = functionName;
        this.args = args;
    }

    @Override
    public int evaluate(Environment environment) {
        return 0;
    }
}
