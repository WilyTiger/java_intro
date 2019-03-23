package expression;

public class Divide extends AbstractBinaryOperation {
    public Divide(AnyExpression left, AnyExpression right) {
        super(left, right);
    }

    protected int doOperation(int left, int right) {
        return left / right;
    }

    protected double doOperation(double left, double right) {
        return left / right;
    }
}
