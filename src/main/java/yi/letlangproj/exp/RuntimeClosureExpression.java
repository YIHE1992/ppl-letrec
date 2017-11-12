package yi.letlangproj.exp;

import yi.letlangproj.Environment;
import yi.letlangproj.Expression;
import yi.letlangproj.HavingArgs;

import java.util.HashMap;

/**
 * @author sky91 - feitiandaxia1991@163.com
 */
public class RuntimeClosureExpression implements Expression, HavingArgs {
    private final Environment closureEnvironment;
    private final Expression originExpression;
    private final String[] argNames;
    private final HashMap<String, Expression> argMap = new HashMap<>();

    public RuntimeClosureExpression(Environment closureEnvironment, Expression originExpression, String[] argNames) {
        this.closureEnvironment = closureEnvironment;
        this.originExpression = originExpression;
        this.argNames = argNames;
    }

    @Override
    public int evaluate(Environment environment) {
        return originExpression.evaluate(new Environment(argMap, closureEnvironment));
    }

    @Override
    public String[] getArgNames() {
        return argNames;
    }

    @Override
    public void setArg(String name, Expression valueExpression) {
        argMap.put(name, valueExpression);
    }
}
