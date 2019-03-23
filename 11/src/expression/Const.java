package expression;

public class Const implements AnyExpression {
    private final double value;

    public Const(int x) {
        value = x;
    }

    public Const(double x) {
        value = x;
    }

    public int evaluate(int x) {
        return (int) value;
    }

    public int evaluate(int x, int y, int z) {
        return (int) value;
    }

    public double evaluate(double x) {
        return value;
    }
}
