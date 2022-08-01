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
        NumArray numArray = new NumArray(new int[]{0, 9, 5, 7, 3});
        numArray.sumRange(4, 4);
        numArray.sumRange(2, 4);
        numArray.sumRange(3, 3);
        numArray.update(4, 5);
        numArray.update(1, 7);
        numArray.update(0, 8);
        numArray.sumRange(1, 2);
        numArray.update(1, 9);
        numArray.sumRange(4, 4);
        numArray.update(3, 4);
    }

}
