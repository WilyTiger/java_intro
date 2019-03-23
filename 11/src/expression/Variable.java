package expression;

public class Variable implements AnyExpression {
    private final String name;

    public Variable(String newName) {
        name = newName;
    }

    public int evaluate(int x) {
        return x;
    }

    public int evaluate(int x, int y, int z) {
        switch (name) {
            case "x":
                return x;
            case "y":
                return y;
            case "z":
                return z;
        }
        return 0;
    }

    public double evaluate(double x) {
        return x;
    }
}
