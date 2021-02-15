package fifteen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A pane containing a 15-puzzle.
 */
public class FifteenPane extends JPanel {

    /**
     * The size of each tile, in pixels.
     */
    private static final int SIZE = 60;

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
        setFocusable(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                Direction direction = switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP -> Direction.UP;
                    case KeyEvent.VK_DOWN -> Direction.DOWN;
                    case KeyEvent.VK_LEFT -> Direction.LEFT;
                    case KeyEvent.VK_RIGHT -> Direction.RIGHT;
                    default -> Direction.NONE;
                };
                board.move(direction);
                repaint();
                showDialogIfSolved();
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int x = e.getX() / SIZE;
                int y = e.getY() / SIZE;
                board.click(x, y);
                repaint();
                showDialogIfSolved();
            }
        });
    }

    public void showDialogIfSolved() {
        if (board.isSolved()) {
            int option = JOptionPane.showConfirmDialog(FifteenPane.this,
                    "You Win! Play Again?", "WinError",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
            if (option == JOptionPane.CANCEL_OPTION) System.exit(0);
            board = new Board();
            repaint();
        }
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
                    g.setColor(board.get(j, i) % 2 == 0 ? EVEN_TILE_COLOR : ODD_TILE_COLOR);
                    g.fillRect(j * SIZE, i * SIZE, SIZE, SIZE);
                    g.setColor(BORDER_COLOR);
                    g.drawRect(j * SIZE, i * SIZE, SIZE, SIZE);
                    g.setColor(NUMBER_COLOR);
                    g.drawString(String.valueOf(board.get(j, i)),
                            j * SIZE + NUMBER_X_MARGIN, i * SIZE + NUMBER_Y_MARGIN);
                }
    }
}
