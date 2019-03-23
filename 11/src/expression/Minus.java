package expression;

public class Minus extends AbstractUnaryOperation {
    public Minus(TripleExpression exp) {
        super(exp);
    }

    protected int doOperation(int x) {
        return -x;
    }
}
