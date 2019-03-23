package expression.parser;

import expression.*;

public class ExpressionParser implements Parser {
    private Tokenizer tokenizer;

    private TripleExpression unary() {
        tokenizer.nextToken();
        TripleExpression res;
        switch (tokenizer.getCurToken()) {
            case CONST:
                res = new Const(tokenizer.getValue());
                tokenizer.nextToken();
                break;
            case VARIABLE:
                res = new Variable(tokenizer.getName());
                tokenizer.nextToken();
                break;
            case MINUS:
                res = new Minus(unary());
                break;
            case NOT:
                res = new Not(unary());
                break;
            case COUNT:
                res = new Count(unary());
                break;
            case OPEN_BRACE:
                res = or();
                tokenizer.nextToken();
                break;
            default:
                return new Const(0);
        }
        return res;
    }

    private TripleExpression mulAndDiv() {
        TripleExpression res = unary();
        while (true) {
            switch (tokenizer.getCurToken()) {
                case MUL:
                    res = new Multiply(res, unary());
                    break;
                case DIV:
                    res = new Divide(res, unary());
                    break;
                default:
                    return res;
            }
        }
    }

    private TripleExpression addAndSub() {
        TripleExpression res = mulAndDiv();
        while (true) {
            switch (tokenizer.getCurToken()) {
                case ADD:
                    res = new Add(res, mulAndDiv());
                    break;
                case SUB:
                    res = new Subtract(res, mulAndDiv());
                    break;
                default:
                    return res;
            }
        }
    }

    private TripleExpression and() {
        TripleExpression res = addAndSub();
        while (tokenizer.getCurToken() == Token.AND) {
            res = new And(res, addAndSub());
        }
        return res;
    }

    private TripleExpression xor() {
        TripleExpression res = and();
        while (tokenizer.getCurToken() == Token.XOR) {
            res = new Xor(res, and());
        }
        return res;
    }

    private TripleExpression or() {
        TripleExpression res = xor();
        while (tokenizer.getCurToken() == Token.OR) {
            res = new Or(res, xor());
        }
        return res;
    }

    public TripleExpression parse(String exp) {
        tokenizer = new Tokenizer(exp);
        return or();
    }
}
