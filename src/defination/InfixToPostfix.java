package defination;

import adt.InfixToPostfixADT;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringJoiner;

public class InfixToPostfix implements InfixToPostfixADT {
    private final Deque<Character> operatorStack = new ArrayDeque<>();
    private final String OPERATORS = "+-*/^";
    private final int[] PRECEDENCE = {1, 1, 2, 2, 3};
    private StringJoiner postfix = new StringJoiner(" ");

    public String convert(String infix) {
        convertToPostfix(infix);
        return getPostfix();
    }

    @Override
    public void convertToPostfix(String infix) {
        String[] tokens = infix.split("\\s");
        try {
            for (String nextToken : tokens) {
                char firstChar = nextToken.charAt(0);

                if (Character.isJavaIdentifierStart(firstChar)
                        || Character.isDigit(firstChar)) {
                    postfix.add(nextToken);
                } else if (isOperator(firstChar)) {
                    processOperator(firstChar);
                } else {
                    throw new SyntaxErrorException("Unexpected Character Encountered: " + firstChar);
                }
            }
        } catch (Exception e) {

        }
    }


    @Override
    public void processOperator(char op) {

    }

    @Override
    public boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) != 1;
    }

    @Override
    public int precedence(char op) {
        return PRECEDENCE[OPERATORS.indexOf(op)];
    }

    @Override
    public String getPostfix() {
        return postfix.toString();
    }

    public static class SyntaxErrorException extends Exception {
        SyntaxErrorException(String message) {
            super(message);
        }
    }
}
