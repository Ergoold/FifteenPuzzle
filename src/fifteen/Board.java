package fifteen;

/**
 * A 15-puzzle board.
 */
public class Board {

    /**
     * The size (width and height) of a board.
     */
    public static final int SIZE = 4;

    /**
     * The number of the empty tile.
     */
    public static final int EMPTY = SIZE * SIZE;

    /**
     * All of the tiles on the board.
     * <p>
     * Each tile is a number between {@code 1} and {@code EMPTY}. There is exactly one tile with each number.
     */
    private final int[][] tiles = new int[SIZE][SIZE];

    /**
     * The x coordinate of the empty tile.
     */
    private int x;

    /**
     * The y coordinate of the empty tile.
     */
    private int y;

    /**
     * Constructs a new board.
     */
    public Board() {
        for (int i = 0; i < SIZE; i++)     // rows (y)
            for (int j = 0; j < SIZE; j++) // cols (x)
                tiles[i][j] = i * SIZE + j + 1;
        x = SIZE - 1;
        y = SIZE - 1;
    }

    public int get(int x, int y) {
        return tiles[y][x];
    }
}
