package yi.letlangproj.exp;

import yi.letlangproj.Environment;
import yi.letlangproj.Expression;

public class VariableExpression implements Expression {
    private final String name;

    VariableExpression(String name) {
        this.name = name;
    }

    @Override
    public int evaluate(Environment environment) {
        return environment.get(name).evaluate(environment);
    }
}
