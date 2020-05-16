package defination;

import adt.InfixToPostfixADT;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class InfixToPostfix implements InfixToPostfixADT {
    private final Deque<Character> operatorStack = new ArrayDeque<>();
    private final String OPERATORS = "+-*/^()";
    private final int[] PRECEDENCE = {1, 1, 2, 2, 3};
    private StringJoiner postfix = new StringJoiner(" ");

    public String convert(String infix) throws SyntaxErrorException {
        convertToPostfix(infix);
        return getPostfix();
    }

    @Override
    public void convertToPostfix(String infix) throws SyntaxErrorException {
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
            while (!operatorStack.isEmpty()) {
                char op = operatorStack.pop();
                postfix.add(Character.toString(op));
            }
        } catch (NoSuchElementException e) {
            throw new SyntaxErrorException
                    ("Syntax Error: The stack is empty");
        }
    }


    @Override
    public void processOperator(char op) {
        if (operatorStack.isEmpty()) {
            operatorStack.push(op);
        } else {

            char topOp = operatorStack.peek();
            if (precedence(op) > precedence(topOp)) {
                operatorStack.push(op);
            } else {

                while (!operatorStack.isEmpty() && precedence(op) <=
                        precedence(topOp)) {
                    operatorStack.pop();
                    postfix.add(Character.toString(topOp));
                    if (!operatorStack.isEmpty()) {

                        topOp = operatorStack.peek();
                    }
                }

                operatorStack.push(op);
            }
        }
    }

    @Override
    public boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) != -1;
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
