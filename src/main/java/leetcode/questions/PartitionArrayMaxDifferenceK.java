package leetcode.questions;

public class PartitionArrayMaxDifferenceK {

    public int partitionArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        countSort(nums);
        int partitions = 1;
        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - start > k) {
                partitions++;
                start = nums[i];
            }
        }
        return partitions;
    }

    private void countSort(int[] nums) {
        int[] counts = new int[100001];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]]++;
        }
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i] > 0) {
                nums[index] = i;
                index++;
                counts[i]--;
            }
        }
    }

}
