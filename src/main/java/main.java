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
        //[['X','X','X','X'],['X','O','O','X'],['X','X','O','X'],['X','O','X','X']]
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        surroundedRegions.solve(new char[][]{
                new char[]{'X','X','X','X'},
                new char[]{'X','O','O','X'},
                new char[]{'X','X','O','X'},
                new char[]{'X','O','X','X'},
        });
    }

}
