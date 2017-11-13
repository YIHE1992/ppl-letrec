package yi.letlangproj.exp;

import yi.letlangproj.Environment;
import yi.letlangproj.Expression;

import java.util.HashMap;
import java.util.stream.IntStream;

public class RuntimeClosureExpression implements Expression {
    private final Environment closureEnvironment;
    private final Expression originExpression;
    private final String[] argNames;

    public RuntimeClosureExpression(Environment closureEnvironment, Expression originExpression, String[] argNames) {
        this.closureEnvironment = closureEnvironment;
        this.originExpression = originExpression;
        this.argNames = argNames;
    }

    @Override
    public int evaluate(Environment environment) {
        HashMap<String, Expression> argMap = new HashMap<>();
        IntStream.range(0, argNames.length).forEach(i -> argMap.put(argNames[i], environment.get(String.valueOf(i))));
        return originExpression.evaluate(new Environment(argMap, closureEnvironment));
    }
}
