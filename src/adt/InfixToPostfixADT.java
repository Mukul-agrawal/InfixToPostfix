package adt;

import defination.InfixToPostfix;

public interface InfixToPostfixADT {
    void convertToPostfix(String infix) throws InfixToPostfix.SyntaxErrorException;

    void processOperator(char op);

    boolean isOperator(char ch);

    int precedence(char op);

    String getPostfix();
}
