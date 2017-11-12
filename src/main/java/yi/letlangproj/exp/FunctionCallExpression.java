package yi.letlangproj.exp;

import yi.letlangproj.Environment;
import yi.letlangproj.Expression;
import yi.letlangproj.HavingArgs;

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
        Expression closureExpression = environment.get(functionName);
        if(closureExpression instanceof HavingArgs) {
            HavingArgs havingArgs = (HavingArgs) closureExpression;
            String[] argNames = havingArgs.getArgNames();
            for(int i = 0; i < argNames.length; i++) {
                havingArgs.setArg(argNames[i], new NumberExpression(args[i].evaluate(environment)));
            }
        }
        return closureExpression.evaluate(environment);
    }
}
