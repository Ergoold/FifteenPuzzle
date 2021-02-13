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
        for (int i = 0; i < 80;) if (move(Direction.nextDirection())) i++;
    }

    public int get(int x, int y) {
        return tiles[y][x];
    }

    /**
     * Swaps the tile in {@code direction} relative to the empty tile with the empty tile.
     *
     * @param direction the direction to swap to
     * @return {@code true} if the move was valid, {@code false} otherwise
     */
    public boolean move(Direction direction) {
        int nx = x, ny = y;
        switch (direction) {
            case UP -> ny++;
            case DOWN -> ny--;
            case LEFT -> nx++;
            case RIGHT -> nx--;
        }
        if (nx < 0 || nx >= SIZE || ny < 0 || ny >= SIZE) return false;
        swap(x, y, nx, ny);
        x = nx;
        y = ny;
        return true;
    }

    /**
     * Swap the tile at ({@code x1}, {@code x2}) and ({@code x1}, {@code x2}).
     *
     * @param x1 the x coordinate of the first tile
     * @param y1 the y coordinate of the first tile
     * @param x2 the x coordinate of the second tile
     * @param y2 the y coordinate of the second tile
     */
    public void swap(int x1, int y1, int x2, int y2) {
        int temp = tiles[y1][x1];
        tiles[y1][x1] = tiles[y2][x2];
        tiles[y2][x2] = temp;
    }
}
