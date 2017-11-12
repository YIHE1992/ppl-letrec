package yi.letlangproj;

import java.util.Objects;

public class Environment {
    private final String name;
    private final Expression expression;
    private final Environment[] parentEnvironments;

    public Environment(String name, Expression expression, Environment... parentEnvironments) {
        this.name = name;
        this.expression = expression;
        this.parentEnvironments = parentEnvironments;
    }

    public Expression get(String name) {
        if(Objects.equals(name, this.name)) {
            return expression;
        }
        if(parentEnvironments != null) {
            for(Environment parentEnvironment : parentEnvironments) {
                Expression expression = parentEnvironment.get(name);
                if(expression != null) {
                    return expression;
                }
            }
        }
        return null;
    }
}
