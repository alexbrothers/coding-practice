package leetcode.google;

import java.util.*;

public class FindCourseOrder {

    class Course {
        int prerequisites;
        List<Course> nextCourses = new ArrayList<>();
        int courseNumber;

        Course(int courseNumber) {
            this.courseNumber = courseNumber;
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Course> courses = new ArrayList<>();
        Queue<Course> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        Set<Integer> coursesTaken = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            courses.add(new Course(i));
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int[] current = prerequisites[i];
            Course next = courses.get(current[0]);
            next.prerequisites++;
            courses.get(current[1]).nextCourses.add(next);
        }
        for (int i = 0; i < courses.size(); i++) {
            Course current = courses.get(i);
            if (current.prerequisites == 0) {
                queue.add(current);
            }
        }
        while (!queue.isEmpty()) {
            Course current = queue.poll();
            result.add(current.courseNumber);
            coursesTaken.add(current.courseNumber);
            for (int i = 0; i < current.nextCourses.size(); i++) {
                Course next = current.nextCourses.get(i);
                next.prerequisites--;
                if (next.prerequisites == 0 && !coursesTaken.contains(next.courseNumber)) {
                    queue.add(next);
                }
            }
        }
        if (result.size() == numCourses) {
            int[] answer = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                answer[i] = result.get(i);
            }
            return answer;
        }
        return new int[]{};
    }

}
