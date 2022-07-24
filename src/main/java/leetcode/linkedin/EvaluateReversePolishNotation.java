package leetcode.linkedin;

public class EvaluateReversePolishNotation {

    class IndexWrapper {
        int index;

        public IndexWrapper(int index) {
            this.index = index;
        }
    }

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            throw new IllegalArgumentException();
        }
        return evalRPNHelper(tokens, new IndexWrapper(tokens.length - 1));
    }

    private int evalRPNHelper(String[] tokens, IndexWrapper indexWrapper) {
        String current = tokens[indexWrapper.index];
        indexWrapper.index--;
        if (!isOperator(current)) {
            return Integer.valueOf(current);
        }
        int num2 = evalRPNHelper(tokens, indexWrapper);
        int num1 = evalRPNHelper(tokens, indexWrapper);
        if (current.equals("*")) {
            return num1 * num2;
        }
        if (current.equals("/")) {
            return num1 / num2;
        }
        if (current.equals("+")) {
            return num1 + num2;
        }
        return num1 - num2;
    }

    private boolean isOperator(String token) {
        return token.length() == 1 && ("*".equals(token) || "+".equals(token) || "-".equals(token) || "/".equals(token));
    }

}
