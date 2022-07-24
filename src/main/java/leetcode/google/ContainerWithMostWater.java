package leetcode.google;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            throw new IllegalArgumentException();
        }
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[right] < height[left]) {
                right--;
            }
            else {
                left++;
            }
        }
        return max;
    }

}
