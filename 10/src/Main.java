import expression.*;

public class Main {
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double result = new Add(
                new Subtract(
                        new Multiply(new Variable("x"), new Variable("x")),
                        new Multiply(new Variable("x"), new Const(2))),
                new Const(1)).evaluate(x);
        System.out.println(result);
    }
}
