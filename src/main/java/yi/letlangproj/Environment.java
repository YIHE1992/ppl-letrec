package yi.letlangproj;

import java.util.Map;

public class Environment {
    private final Map<String, Expression> map;
    private final Environment[] parentEnvironments;

    public Environment(Map<String, Expression> map, Environment... parentEnvironments) {
        this.map = map;
        this.parentEnvironments = parentEnvironments;
    }

    public Expression get(String name) {
        Expression expression = map.get(name);
        if(expression != null) {
            return expression;
        }
        if(parentEnvironments != null) {
            for(Environment parentEnvironment : parentEnvironments) {
                expression = parentEnvironment.get(name);
                if(expression != null) {
                    return expression;
                }
            }
        }
        return null;
    }
}
