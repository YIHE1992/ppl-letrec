package yi.letlangproj;

/**
 * @author sky91 - feitiandaxia1991@163.com
 */
public interface HavingArgs {
    String[] getArgNames();

    void setArg(String name, Expression valueExpression);
}
