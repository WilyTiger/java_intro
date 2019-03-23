package expression.parser;

public class Tokenizer {
    private String exp;
    private int ind;
    private Token curToken;
    private int value;
    private String name;

    public Tokenizer(String expression) {
        exp = expression;
        curToken = Token.BEGIN;
        ind = 0;
    }

    private void skipSpaces() {
        while (ind < exp.length() && Character.isWhitespace(exp.charAt(ind))) {
            ind++;
        }
    }

    private String getNumber() {
        int l = ind;
        while (ind < exp.length() && Character.isDigit(exp.charAt(ind))) {
            ind++;
        }
        ind--;
        return exp.substring(l, ind + 1);
    }

    private String getStr() {
        int l = ind;
        while (ind < exp.length() && Character.isLetter(exp.charAt(ind))) {
            ind++;
        }
        ind--;
        return exp.substring(l, ind + 1);
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public Token getCurToken() {
        return curToken;
    }

    public Token nextToken() {
        skipSpaces();
        if (ind >= exp.length()) {
            curToken = Token.END;
            return curToken;
        }
        char current = exp.charAt(ind);
        switch (current) {
            case '-':
                if (curToken == Token.CONST || curToken == Token.VARIABLE
                        || curToken == Token.CLOSE_BRACE) {
                    curToken = Token.SUB;
                } else {
                    curToken = Token.MINUS;
                }
                break;
            case '+':
                curToken = Token.ADD;
                break;
            case '*':
                curToken = Token.MUL;
                break;
            case '/':
                curToken = Token.DIV;
                break;
            case '(':
                curToken = Token.OPEN_BRACE;
                break;
            case ')':
                curToken = Token.CLOSE_BRACE;
                break;
            case '^':
                curToken = Token.XOR;
                break;
            case '&':
                curToken = Token.AND;
                break;
            case '|':
                curToken = Token.OR;
                break;
            case '~':
                curToken = Token.NOT;
                break;
            default:
                if (Character.isDigit(current)) {
                    value = Integer.parseUnsignedInt(getNumber());
                    curToken = Token.CONST;
                } else if (Character.isLetter(current)) {
                    String s = getStr();
                    if (s.equals("count")) {
                        curToken = Token.COUNT;
                    } else {
                        curToken = Token.VARIABLE;
                        name = s;
                    }
                }
        }
        ind++;
        return curToken;
    }
}
