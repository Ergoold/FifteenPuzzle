package fifteen;

import javax.swing.*;

/**
 * A frame that contains a 15-puzzle.
 */
public class Gui extends JFrame {

    private Gui() {
        setTitle("15 Puzzle");
        setContentPane(new FifteenPane());
        pack();
        setResizable(false);
    }

    public static void main(String[] args) {
        Gui gui = new Gui();
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gui.setVisible(true);
    }
}
