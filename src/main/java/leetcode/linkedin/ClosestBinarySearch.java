package leetcode.linkedin;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ClosestBinarySearch {

    class FoundWrapper {
        boolean found = false;
    }

    class TreeNodeDistance {
        TreeNode node;
        double distance;

        public TreeNodeDistance(TreeNode node, double distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<TreeNodeDistance> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.distance, a.distance));
        closestKValuesHelperScan(root, target, maxHeap, k);
        List<Integer> result = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll().node.val);
        }
        return result;
    }

    private void closestKValuesHelperScan(TreeNode node, double target, PriorityQueue<TreeNodeDistance> maxHeap, int k) {
        if (node == null) {
            return;
        }
        TreeNodeDistance nodeDistance = new TreeNodeDistance(node, Math.abs(target - node.val));
        if (maxHeap.size() < k) {
            maxHeap.add(nodeDistance);
        }
        else {
            if (nodeDistance.distance < maxHeap.peek().distance) {
                maxHeap.poll();
                maxHeap.add(nodeDistance);
            }
        }
        closestKValuesHelperScan(node.left, target, maxHeap, k);
        closestKValuesHelperScan(node.right, target, maxHeap, k);
    }

//    private void closestKValuesHelper(TreeNode root, double target, int min, int max, int k, PriorityQueue<TreeNodeDistance> maxHeap, FoundWrapper foundWrapper) {
//        if (root == null) {
//            return;
//        }
//        if (foundWrapper.found) {
//            if (target < root.val) {
//                closestKValuesHelper(root.left, target, min, root.val, k, maxHeap, foundWrapper);
//                if (maxHeap.size() < k) {
//                    maxHeap.add(new TreeNodeDistance(root, Math.abs(target - root.val)));
//                }
//
//            }
//        }
//        if (root.val == target || target < min || target >= max) {
//            foundWrapper.found = true;
//            maxHeap.add(new TreeNodeDistance(root, Math.abs(target - root.val)));
//        }
//        else if (target < root.val) {
//            clo
//        }
//        else if (ro)
//    }

}
