package leetcode.questions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxPassingRatio {

    class Class {
        int numStudents;
        int numPassing;
        double ratio;
        double plusAmazingStudentRatio;
        double plusAmazingStudentIncrease;

        Class(int numStudents, int numPassing) {
            this.numStudents = numStudents;
            this.numPassing = numPassing;
            this.ratio = ((double) this.numPassing) / ((double) this.numStudents);
            this.plusAmazingStudentRatio = ((double) this.numPassing + 1) / ((double) this.numStudents + 1);
            this.plusAmazingStudentIncrease = this.plusAmazingStudentRatio - ratio;
        }

        void addAmazingStudent() {
            this.numStudents++;
            this.numPassing++;
            this.ratio = plusAmazingStudentRatio;
            this.plusAmazingStudentRatio = ((double) this.numPassing + 1) / ((double) this.numStudents + 1);
            this.plusAmazingStudentIncrease = this.plusAmazingStudentRatio - ratio;
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        if (classes == null || classes.length == 0 || extraStudents < 0) {
            throw new IllegalArgumentException();
        }
        PriorityQueue<Class> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.plusAmazingStudentIncrease, a.plusAmazingStudentIncrease));
        for (int i = 0; i < classes.length; i++) {
            int[] current = classes[i];
            maxHeap.add(new Class(current[1], current[0]));
        }
        while (extraStudents > 0) {
            Class lowest = maxHeap.poll();
            lowest.addAmazingStudent();
            maxHeap.add(lowest);
            extraStudents--;
        }
        double sum = 0;
        int size = maxHeap.size();
        while (!maxHeap.isEmpty()) {
            sum += maxHeap.poll().ratio;
        }
        return sum / size;
    }

}
