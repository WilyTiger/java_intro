package expression;

public class Multiply extends AbstractBinaryOperation {
    public Multiply(AnyExpression left, AnyExpression right) {
        super(left, right);
    }

    protected int doOperation(int left, int right) {
        return left * right;
    }

    protected double doOperation(double left, double right) {
        return left * right;
    }
}
