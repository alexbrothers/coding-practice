import amazon.AmazonLocker;
import amazon.Locker;
import amazon.NoLockerFoundException;
import amazon.Package;
import leetcode.common.ListNode;
import leetcode.common.TreeNode;
import leetcode.google.*;
import leetcode.linkedin.*;
import leetcode.questions.*;

import java.util.List;

public class main {
    public static void main(String[] args) throws NoLockerFoundException {
        NumArray numArray = new NumArray(new int[]{1, 3, 5});
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(1, 2));
    }

}
