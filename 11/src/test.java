import expression.TripleExpression;
import expression.parser.ExpressionParser;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        System.out.println("Input your expression");
        Scanner input = new Scanner(System.in);

        String s = input.nextLine();
        System.out.println("Input value of x");
        int x = input.nextInt();
        System.out.println("Input value of y");
        int y = input.nextInt();
        System.out.println("Input value of z");
        int z = input.nextInt();

        TripleExpression exp = new ExpressionParser().parse(s);

        System.out.println("::::::::::::::");
        System.out.print("Result = ");
        System.out.println(exp.evaluate(x, y, z));
    }
}
