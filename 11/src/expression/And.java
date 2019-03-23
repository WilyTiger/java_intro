package expression;

public class And extends AbstractBinaryOperation {
    public And(TripleExpression left, TripleExpression right) {
        super(left, right);
    }

    public int doOperation(int x, int y) {
        return x & y;
    }
}
