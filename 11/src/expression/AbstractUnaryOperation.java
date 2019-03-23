package expression;

public abstract class AbstractUnaryOperation implements TripleExpression {
    private TripleExpression operand;

    protected AbstractUnaryOperation(TripleExpression x) {
        operand = x;
    }

    protected abstract int doOperation(int x);

    public int evaluate(int x, int y, int z) {
        return doOperation(operand.evaluate(x, y, z));
    }
}
