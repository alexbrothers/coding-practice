package leetcode.questions;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KDistanceBinaryTree {

    class KDistanceHelper {
        boolean found;
        int nodesBelow;

        KDistanceHelper(boolean found, int nodesBelow) {
            this.found = found;
            this.nodesBelow = nodesBelow;
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        distanceKHelper(root, target, k, result);
        return result;
    }

    private KDistanceHelper distanceKHelper(TreeNode node, TreeNode target, int k, List<Integer> result) {
        if (node == null) {
            return new KDistanceHelper(false, 0);
        }
        if (node == target) {
            findBelow(node, k, result);
            return new KDistanceHelper(true, 1);
        }
        KDistanceHelper left = distanceKHelper(node.left, target, k, result);
        if (left.found) {
            if (left.nodesBelow > k) {
                return left;
            }
            if (left.nodesBelow == k) {
                result.add(node.val);
            }
            else {
                findBelow(node.right, k - left.nodesBelow - 1, result);
            }
            return new KDistanceHelper(true, left.nodesBelow + 1);
        }
        KDistanceHelper right = distanceKHelper(node.right, target, k, result);
        if (right.found) {
            if (right.nodesBelow > k) {
                return right;
            }
            if (right.nodesBelow == k) {
                result.add(node.val);
            }
            else {
                findBelow(node.left, k - right.nodesBelow - 1, result);
            }
            return new KDistanceHelper(true, right.nodesBelow + 1);
        }
        return new KDistanceHelper(false, 0);
    }

    private void findBelow(TreeNode node, int k, List<Integer> result) {
        if (node == null || k < 0) {
            return;
        }
        if (k == 0) {
            result.add(node.val);
            return;
        }
        findBelow(node.left, k - 1, result);
        findBelow(node.right, k - 1, result);
    }

}
