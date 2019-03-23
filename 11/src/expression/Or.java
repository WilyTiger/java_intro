package expression;

public class Or extends AbstractBinaryOperation {
    public Or(TripleExpression left, TripleExpression right) {
        super(left, right);
    }

    public int doOperation(int left, int right) {
        return left | right;
    }

}
