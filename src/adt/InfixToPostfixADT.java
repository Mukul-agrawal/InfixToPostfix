package adt;

public interface InfixToPostfixADT {
    void convertToPostfix(String infix);

    void processOperator(char op);

    boolean isOperator(char ch);

    int precedence(char op);

    String getPostfix();
}
