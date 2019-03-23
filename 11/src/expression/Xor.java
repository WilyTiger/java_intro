package expression;

public class Xor extends AbstractBinaryOperation {
    public Xor(TripleExpression left, TripleExpression right) {
        super(left, right);
    }

    public int doOperation(int x, int y) {
        return x ^ y;
    }
}
