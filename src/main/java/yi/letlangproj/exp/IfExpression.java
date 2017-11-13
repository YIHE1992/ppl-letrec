package yi.letlangproj.exp;

import yi.letlangproj.Environment;
import yi.letlangproj.Expression;

public class IfExpression implements Expression {
    private final Expression conditionExpression;
    private final Expression trueExpression;
    private final Expression falseExpression;

    public IfExpression(Expression conditionExpression, Expression trueExpression, Expression falseExpression) {
        this.conditionExpression = conditionExpression;
        this.trueExpression = trueExpression;
        this.falseExpression = falseExpression;
    }

    @Override
    public int evaluate(Environment environment) {
        return conditionExpression.evaluate(environment) != 0 ? trueExpression.evaluate(environment) : falseExpression.evaluate(environment);
    }
}
