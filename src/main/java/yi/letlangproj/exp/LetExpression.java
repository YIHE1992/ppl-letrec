package yi.letlangproj.exp;

import yi.letlangproj.Environment;
import yi.letlangproj.Expression;

import java.util.HashMap;

/**
 * @author sky91 - feitiandaxia1991@163.com
 */
public class LetExpression implements Expression {
    private final String varName;
    private final String[] argNames;
    private final Expression functionBody;
    private final Expression letValueExpression;

    public LetExpression(String varName, String[] argNames, Expression functionBody, Expression letValueExpression) {
        this.varName = varName;
        this.argNames = argNames;
        this.functionBody = functionBody;
        this.letValueExpression = letValueExpression;
    }

    @Override
    public int evaluate(Environment environment) {
        HashMap<String, Expression> envMap = new HashMap<>();
        Environment newEnvironment = new Environment(envMap, environment);
        envMap.put(varName, new RuntimeClosureExpression(newEnvironment, functionBody, argNames));
        return letValueExpression.evaluate(newEnvironment);
    }
}
