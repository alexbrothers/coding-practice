package leetcode.google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinCostToHireKWorkers {

    class Worker {
        int minimumWage;
        int quality;
        double ratio;

        Worker(int minimumWage, int quality) {
            this.minimumWage = minimumWage;
            this.quality = quality;
            this.ratio = Double.valueOf(minimumWage) / Double.valueOf(quality);
        }
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        if (quality == null || wage == null || k <= 0) {
            throw new IllegalArgumentException();
        }
        Worker[] workers = new Worker[quality.length];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Worker(wage[i], quality[i]);
        }
        Arrays.sort(workers, Comparator.comparingDouble(worker -> worker.ratio));
        int qualitySum = 0;
        double minCost = Integer.MAX_VALUE;
        PriorityQueue<Integer> qualities = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int i = 0; i < workers.length; i++) {
            Worker worker = workers[i];
            qualities.add(worker.quality);
            qualitySum += worker.quality;
            if (qualities.size() > k) {
                qualitySum -= qualities.poll();
            }
            if (qualities.size() == k) {
                minCost = Math.min(minCost, qualitySum * worker.ratio);
            }
        }
        return minCost;
    }

}
