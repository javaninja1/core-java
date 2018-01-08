package com.myjava.logic;

public class Eval {
    int pos = -1, ch;
    String expression;

    public Eval(String expression1) {
        expression = expression1;
    }

    void nextChar() {
        ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
    }

    boolean eat(int charToEat) {
        while (ch == ' ')
            nextChar();
        if (ch == charToEat) {
            nextChar();
            return true;
        }
        return false;
    }

    double parse() {
        nextChar();
        double x = parseExpression();
        if (pos < expression.length())
            throw new RuntimeException("Unexpected: " + (char) ch);
        return x;
    }

    double parseExpression() {
        double x = parseTerm();
        for (;;) {
            if (eat('+'))
                x += parseTerm(); // addition
            else if (eat('-'))
                x -= parseTerm(); // subtraction
            else
                return x;
        }
    }

    double parseTerm() {
        double x = parseFactor();
        for (;;) {
            if (eat('*'))
                x *= parseFactor(); // multiplication
            else if (eat('/'))
                x /= parseFactor(); // division
            else
                return x;
        }
    }

    double parseFactor() {
        if (eat('+'))
            return parseFactor(); // unary plus
        if (eat('-'))
            return -parseFactor(); // unary minus

        double x;
        int startPos = this.pos;
        if (eat('(')) { // parentheses
            x = parseExpression();
            eat(')');
        } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
            while ((ch >= '0' && ch <= '9') || ch == '.')
                nextChar();
            x = Double.parseDouble(expression.substring(startPos, this.pos));
        } else {
            throw new RuntimeException("Unexpected: " + (char) ch);
        }

        if (eat('^'))
            x = Math.pow(x, parseFactor()); // exponentiation

        return x;
    }

    public static void main(String args[]) {

        String expression = "4 + 2 * 2 ";
        Eval eval = new Eval(expression);
        System.out.println(expression + " = " + eval.parse());

        expression = "(4 + 2) * 2 ";
        Eval eval2 = new Eval(expression);
        System.out.println(expression + " = " + eval2.parse());

        expression = "(4 + 2)/2 * 2^2 ";
        Eval eval3 = new Eval(expression);
        System.out.println(expression + " = " + eval3.parse());
        
        
    }
    
}
