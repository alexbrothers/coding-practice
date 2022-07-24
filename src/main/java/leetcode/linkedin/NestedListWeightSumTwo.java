package leetcode.linkedin;

import leetcode.common.NestedInteger;

import java.util.List;

public class NestedListWeightSumTwo {

    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null) {
            throw new IllegalArgumentException();
        }
        int maxDepth = findMaxDepth(nestedList, 1);
        return depthSumInverse(nestedList, 1, maxDepth);
    }

    private int findMaxDepth(List<NestedInteger> nested, int depth) {
        int maxDepth = depth;
        for (int i = 0; i < nested.size(); i++) {
            NestedInteger current = nested.get(i);
            if (!current.isInteger() && !current.getList().isEmpty()) {
                maxDepth = Math.max(maxDepth, findMaxDepth(current.getList(), depth + 1));
            }
        }
        return maxDepth;
    }

    private int depthSumInverse(List<NestedInteger> nested, int depth, int maxDepth) {
        int sum = 0;
        for (int i = 0; i < nested.size(); i++) {
            NestedInteger current = nested.get(i);
            if (!current.isInteger()) {
                sum += depthSumInverse(current.getList(), depth + 1, maxDepth);
            }
            else {
                sum += current.getInteger() * (maxDepth - depth + 1);
            }
        }
        return sum;
    }

}
