package leetcode.google;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(new StringBuilder(), 0, 0, n, result);
        return result;
    }

    private void generate(StringBuilder current, int open, int closed, int n, List<String> result) {
        if (open == n && closed == n) {
            result.add(current.toString());
            return;
        }
        if (open < n) {
            current.append('(');
            generate(current, open + 1, closed, n, result);
            current.deleteCharAt(current.length() - 1);
        }
        if (closed < open) {
            current.append(')');
            generate(current, open, closed + 1, n, result);
            current.deleteCharAt(current.length() - 1);
        }
    }

}
