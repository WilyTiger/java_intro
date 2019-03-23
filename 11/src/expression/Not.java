package expression;

public class Not extends AbstractUnaryOperation {
    public Not(TripleExpression exp) {
        super(exp);
    }

    protected int doOperation(int x) {
        return ~x;
    }
}
