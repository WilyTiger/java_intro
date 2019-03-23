package expression;

public abstract class AbstractBinaryOperation implements AnyExpression {
    private AnyExpression left, right;

    protected AbstractBinaryOperation(AnyExpression nLeft, AnyExpression nRight) {
        left = nLeft;
        right = nRight;
    }

    abstract protected int doOperation(int left, int right);

    abstract protected double doOperation(double left, double right);

    public int evaluate(int x) {
        return doOperation(left.evaluate(x), right.evaluate(x));
    }

    public int evaluate(int x, int y, int z) {
        return doOperation(left.evaluate(x, y, z), right.evaluate(x, y, z));
    }

    public double evaluate(double x) {
        return doOperation(left.evaluate(x), right.evaluate(x));
    }
}
