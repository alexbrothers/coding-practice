import amazon.*;
import amazon.Package;
import leetcode.common.ListNode;
import leetcode.common.TreeNode;
import leetcode.linkedin.*;
import leetcode.questions.*;
import practice.questions.AngledBrackets;

import java.util.List;

public class main {
    public static void main(String[] args) {
        LargestMagicSquare largestMagicSquare = new LargestMagicSquare();
        largestMagicSquare.largestMagicSquare(new int[][]{
                new int[]{5, 1, 3, 1},
                new int[]{9, 3, 3, 1},
                new int[]{1, 3, 3, 8}
        });
    }

}
