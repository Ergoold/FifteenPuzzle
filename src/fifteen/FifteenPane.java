package fifteen;

import javax.swing.*;
import java.awt.*;

/**
 * A pane containing a 15-puzzle.
 */
public class FifteenPane extends JPanel {

    /**
     * The size of each tile, in pixels.
     */
    private static final int SIZE = 50;

    /**
     * The color of tiles in even positions.
     */
    private static final Color EVEN_TILE_COLOR = Color.decode("#FCCC9C");

    /**
     * The color of tiles in odd positions.
     */
    private static final Color ODD_TILE_COLOR = Color.decode("#D48C44");

    /**
     * The color of the empty tile.
     */
    private static final Color EMPTY_TILE_COLOR = Color.BLACK;

    /**
     * The color of the borders between tiles.
     */
    private static final Color BORDER_COLOR = Color.BLACK;

    /**
     * The color of the numbers on the tiles.
     */
    public static final Color NUMBER_COLOR = Color.BLACK;

    /**
     * The horizontal margin between the top-left edge of a tile and the bottom-left of that tile's number.
     */
    public static final int NUMBER_X_MARGIN = 2;

    /**
     * The vertical margin between the top-left edge of a tile and the bottom-left of that tile's number.
     */
    public static final int NUMBER_Y_MARGIN = 12;

    /**
     * The 15-puzzle game board displayed on this pane.
     */
    private Board board = new Board();

    public FifteenPane() {
        setPreferredSize(new Dimension(SIZE * Board.SIZE, SIZE * Board.SIZE));
    }

    @Override
    protected void paintComponent(Graphics g) {
        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        for (int i = 0; i < Board.SIZE; i++)     // rows (y)
            for (int j = 0; j < Board.SIZE; j++) // cols (x)
                if (board.get(j, i) == Board.EMPTY) {
                    g.setColor(EMPTY_TILE_COLOR);
                    g.fillRect(j * SIZE, i * SIZE, SIZE, SIZE);
                } else {
                    g.setColor(((j % 2) ^ (i % 2)) == 0 ? EVEN_TILE_COLOR : ODD_TILE_COLOR);
                    g.fillRect(j * SIZE, i * SIZE, SIZE, SIZE);
                    g.setColor(BORDER_COLOR);
                    g.drawRect(j * SIZE, i * SIZE, SIZE, SIZE);
                    g.setColor(NUMBER_COLOR);
                    g.drawString(String.valueOf(board.get(j, i)),
                            j * SIZE + NUMBER_X_MARGIN, i * SIZE + NUMBER_Y_MARGIN);
                }
    }
}
