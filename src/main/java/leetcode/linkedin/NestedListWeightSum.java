package leetcode.linkedin;

import leetcode.common.NestedInteger;

import java.util.List;

public class NestedListWeightSum {

    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null) {
            throw new IllegalArgumentException();
        }
        int sum = 0;
        for (int i = 0; i < nestedList.size(); i++) {
            sum += getSum(nestedList.get(i), 1);
        }
        return sum;
    }

    private int getSum(NestedInteger nestedInteger, int depth) {
        if (nestedInteger.isInteger()) {
            return nestedInteger.getInteger() * depth;
        }
        int sum = 0;
        List<NestedInteger> list = nestedInteger.getList();
        for (int i = 0; i < list.size(); i++) {
            sum += getSum(list.get(i), depth + 1);
        }
        return sum;
    }

}
