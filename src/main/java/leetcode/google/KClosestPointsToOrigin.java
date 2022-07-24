package leetcode.google;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    class Point {
        int x;
        int y;
        int distanceFromOrigin;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
            int xDistance = (int) Math.pow(x, 2);
            int yDistance = (int) Math.pow(y, 2);
            this.distanceFromOrigin = xDistance + yDistance;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        if (points == null || points.length == 0 || k < 1) {
            throw new IllegalArgumentException();
        }
        PriorityQueue<Point> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.distanceFromOrigin, a.distanceFromOrigin));
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            maxHeap.add(new Point(point[0], point[1]));
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[][] result = new int[k][];
        int resultIndex = 0;
        while (!maxHeap.isEmpty()) {
            Point point = maxHeap.poll();
            result[resultIndex] = new int[]{point.x, point.y};
            resultIndex++;
        }
        return result;
    }

}
