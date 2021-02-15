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
            case 0 -> UP;
            case 1 -> DOWN;
            case 2 -> LEFT;
            case 3 -> RIGHT;
            default -> NONE;
        };
    }
}
