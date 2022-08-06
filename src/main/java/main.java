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
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        medianOfTwoSortedArrays.findMedianSortedArrays(new int[]{1, 4, 5}, new int[]{2, 3, 6, 7});
    }

}
