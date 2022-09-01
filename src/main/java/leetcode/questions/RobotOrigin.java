package leetcode.questions;

import java.util.HashMap;
import java.util.Map;

public class RobotOrigin {

    Map<Character, int[]> map = new HashMap<>() {{
        put('U', new int[]{-1, 0});
        put('D', new int[]{1, 0});
        put('L', new int[]{0, -1});
        put('R', new int[]{0, 1});
    }};

    public boolean judgeCircle(String moves) {
        if (moves == null) {
            throw new IllegalArgumentException();
        }
        int[] result = new int[]{0, 0};
        for (int i = 0; i < moves.length(); i++) {
            char move = moves.charAt(i);
            int[] directions = map.get(move);
            result[0] += directions[0];
            result[1] += directions[1];
        }
        return result[0] == 0 && result[1] == 0;
    }

}
