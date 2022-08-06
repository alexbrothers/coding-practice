package leetcode.google;

import java.util.HashSet;
import java.util.Set;

public class RobotRoomCleaner {

    public interface Robot {
         // Returns true if the cell in front is open and robot moves into the cell.
         // Returns false if the cell in front is blocked and robot stays in the current cell.
         public boolean move();

         // Robot will stay in the same cell after calling turnLeft/turnRight.
         // Each turn will be 90 degrees.
         public void turnLeft();
         public void turnRight();

         // Clean the current cell.
         public void clean();
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public void cleanRoom(Robot robot) {
        cleanRoomHelper(robot, 0, 0, Direction.UP, new HashSet<>());
    }

    private Direction cleanRoomHelper(Robot robot, int horizontalMoves, int verticalMoves, Direction direction, Set<String> visited) {
        Direction oppositeDirection = getOppositeDirection(direction);
        Set<Direction> visitedDirections = new HashSet<>();
        visited.add(generateKey(horizontalMoves, verticalMoves));
        robot.clean();
        while (visitedDirections.size() < 4) {
            if (!visitedDirections.contains(direction)) {
                visitedDirections.add(direction);
                if (!visited.contains(generateKey(updateHorizontalMoves(horizontalMoves, direction), updateVerticalMoves(verticalMoves, direction))) && robot.move()) {
                    direction = cleanRoomHelper(robot, updateHorizontalMoves(horizontalMoves, direction), updateVerticalMoves(verticalMoves, direction), direction, visited);
                }
            }
            robot.turnLeft();
            direction = updateDirection(direction);
        }
        while (direction != oppositeDirection) {
            robot.turnLeft();
            direction = updateDirection(direction);
        }
        robot.move();
        return direction;
    }

    private String generateKey(int horizontalMoves, int verticalMoves) {
        return horizontalMoves + "|" + verticalMoves;
    }

    private Direction getOppositeDirection(Direction direction) {
        if (direction == Direction.LEFT) {
            return Direction.RIGHT;
        }
        if (direction == Direction.RIGHT) {
            return Direction.LEFT;
        }
        if (direction == Direction.UP) {
            return Direction.DOWN;
        }
        return Direction.UP;
    }

    private int updateHorizontalMoves(int horizontalMoves, Direction direction) {
        if (direction == Direction.UP || direction == Direction.DOWN) {
            return horizontalMoves;
        }
        if (direction == Direction.LEFT) {
            return horizontalMoves - 1;
        }
        else {
            return horizontalMoves + 1;
        }
    }

    private int updateVerticalMoves(int verticalMoves, Direction direction) {
        if (direction == Direction.LEFT || direction == Direction.RIGHT) {
            return verticalMoves;
        }
        if (direction == Direction.UP) {
            return verticalMoves - 1;
        }
        else {
            return verticalMoves + 1;
        }
    }

    private Direction updateDirection(Direction direction) {
        if (direction == Direction.UP) {
            return Direction.LEFT;
        }
        if (direction == Direction.LEFT) {
            return Direction.DOWN;
        }
        if (direction == Direction.DOWN) {
            return Direction.RIGHT;
        }
        return Direction.UP;
    }

}
