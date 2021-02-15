package fifteen;

import java.util.Random;

/**
 * A direction relative to the board.
 */
public enum Direction {

    UP, DOWN, LEFT, RIGHT, NONE;

    private static final Random RANDOM = new Random();

    public static Direction nextDirection() {
        return switch (RANDOM.nextInt(4)) {
            case 0 -> Direction.UP;
            case 1 -> Direction.DOWN;
            case 2 -> Direction.LEFT;
            case 3 -> Direction.RIGHT;
            default -> Direction.NONE;
        };
    }
}
