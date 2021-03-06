package yi.letlangproj.exp;

import yi.letlangproj.Environment;
import yi.letlangproj.Expression;

import java.util.HashMap;
import java.util.stream.IntStream;

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
        HashMap<String, Expression> argMap = new HashMap<>();
        IntStream.range(0, args.length).forEach(i -> argMap.put(String.valueOf(i), new NumberExpression(args[i].evaluate(environment))));
        return closureExpression.evaluate(new Environment(argMap));
    }
}
