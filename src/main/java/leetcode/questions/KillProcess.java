package leetcode.questions;

import java.util.*;

public class KillProcess {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        if (pid == null || ppid == null || pid.size() != ppid.size()) {
            throw new IllegalArgumentException();
        }
        Map<Integer, List<Integer>> childrenMap = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            int process = pid.get(i);
            int parentProcess = ppid.get(i);
            List<Integer> children = childrenMap.getOrDefault(parentProcess, new ArrayList<>());
            children.add(process);
            childrenMap.put(parentProcess, children);
        }
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(kill);
        while (!queue.isEmpty()) {
            int killedProcess = queue.poll();
            result.add(killedProcess);
            if (childrenMap.containsKey(killedProcess)) {
                List<Integer> children = childrenMap.get(killedProcess);
                queue.addAll(children);
            }
        }
        return result;
    }

}
