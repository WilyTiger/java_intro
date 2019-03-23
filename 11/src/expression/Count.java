package expression;

public class Count extends AbstractUnaryOperation {
    public Count(TripleExpression exp) {
        super(exp);
    }

    protected int doOperation(int x) {
        return Integer.bitCount(x);
    }
}
