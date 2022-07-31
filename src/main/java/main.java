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
        WordSubsets wordSubsets = new WordSubsets();
        wordSubsets.wordSubsets(
                new String[]{"amazon","apple","facebook","google","leetcode"},
                new String[]{"lo","eo"}
        );
    }

}
