package leetcode.google;

import java.util.*;

public class AndroidLockScreen {

    class Move {
        int destination;
        Integer check;

        Move(int destination, Integer check) {
            this.destination = destination;
            this.check = check;
        }
    }

    public Map<Integer, List<Move>> createMoveMap() {
        Map<Integer, List<Move>> map = new HashMap<>();
        map.put(
                1,
                List.of(
                        new Move(2, null),
                        new Move(3, 2),
                        new Move(4, null),
                        new Move(7, 4),
                        new Move(5, null),
                        new Move(9, 5),
                        new Move(6, null),
                        new Move(8, null)
                )
        );
        map.put(
                2,
                List.of(
                        new Move(1, null),
                        new Move(3, null),
                        new Move(4, null),
                        new Move(5, null),
                        new Move(6, null),
                        new Move(7, null),
                        new Move(8, 5),
                        new Move(9, null)
                )
        );
        map.put(
                3,
                List.of(
                        new Move(1, 2),
                        new Move(2, null),
                        new Move(4, null),
                        new Move(5, null),
                        new Move(6, null),
                        new Move(7, 5),
                        new Move(8, null),
                        new Move(9, 6)
                )
        );
        map.put(
                4,
                List.of(
                        new Move(1, null),
                        new Move(2, null),
                        new Move(3, null),
                        new Move(5, null),
                        new Move(6, 5),
                        new Move(7, null),
                        new Move(8, null),
                        new Move(9, null)
                )
        );
        map.put(
                5,
                List.of(
                        new Move(1, null),
                        new Move(2, null),
                        new Move(3, null),
                        new Move(4, null),
                        new Move(6, null),
                        new Move(7, null),
                        new Move(8, null),
                        new Move(9, null)
                )
        );
        map.put(
                6,
                List.of(
                        new Move(1, null),
                        new Move(2, null),
                        new Move(3, null),
                        new Move(4, 5),
                        new Move(5, null),
                        new Move(7, null),
                        new Move(8, null),
                        new Move(9, null)
                )
        );
        map.put(
                7,
                List.of(
                        new Move(1, 4),
                        new Move(2, null),
                        new Move(3, 5),
                        new Move(4, null),
                        new Move(5, null),
                        new Move(6, null),
                        new Move(8, null),
                        new Move(9, 8)
                )
        );
        map.put(
                8,
                List.of(
                        new Move(1, null),
                        new Move(2, 5),
                        new Move(3, null),
                        new Move(4, null),
                        new Move(5, null),
                        new Move(6, null),
                        new Move(7, null),
                        new Move(9, null)
                )
        );
        map.put(
                9,
                List.of(
                        new Move(1, 5),
                        new Move(2, null),
                        new Move(3, 6),
                        new Move(4, null),
                        new Move(5, null),
                        new Move(6, null),
                        new Move(7, 8),
                        new Move(8, null)
                )
        );
        return map;
    }

    public int numberOfPatterns(int m, int n) {
        Map<Integer, List<Move>> moveMap = createMoveMap();
        int result = 0;
        for (int i = 1; i < 10; i++) {
            result += numberOfPatternsHelper(i, 1, m, n, new HashSet<>(), moveMap);
        }
        return result;
    }

    private int numberOfPatternsHelper(int current, int keys, int m, int n, Set<Integer> visited, Map<Integer, List<Move>> movesMap) {
        if (keys == n) {
            return 1;
        }
        visited.add(current);
        int count = 0;
        if (keys >= m) {
            count++;
        }
        List<Move> moves = movesMap.get(current);
        for (int i = 0; i < moves.size(); i++) {
            Move candidate = moves.get(i);
            if (!visited.contains(candidate.destination) && (candidate.check == null || visited.contains(candidate.check))) {
                count += numberOfPatternsHelper(candidate.destination, keys + 1, m, n, visited, movesMap);
            }
        }
        visited.remove(current);
        return count;
    }

}
