package yi.letlangproj.exp;

import yi.letlangproj.Environment;
import yi.letlangproj.Expression;

/**
 * @author sky91 - feitiandaxia1991@163.com
 */
public class FunctionDefineExpression implements Expression {
    private final String[] argNames;
    private final Expression functionBody;

    public FunctionDefineExpression(String[] argNames, Expression functionBody) {
        this.argNames = argNames;
        this.functionBody = functionBody;
    }

    @Override
    public int evaluate(Environment environment) {
        return 0;
    }
}
