package yi.letlangproj.exp;

import yi.letlangproj.Expression;

/**
 * @author sky91 - feitiandaxia1991@163.com
 */
public class LetRecExpression extends LetExpression {
    public LetRecExpression(String varName, String[] argNames, Expression functionBody, Expression letValueExpression) {
        super(varName, argNames, functionBody, letValueExpression);
    }
}
