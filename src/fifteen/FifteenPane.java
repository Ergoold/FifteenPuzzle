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
     * The 15-puzzle game board displayed on this pane.
     */
    private Board board = new Board();

    public FifteenPane() {
        setPreferredSize(new Dimension(SIZE * Board.SIZE, SIZE * Board.SIZE));
    }

    @Override
    protected void paintComponent(Graphics g) {
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
                }
    }
}
