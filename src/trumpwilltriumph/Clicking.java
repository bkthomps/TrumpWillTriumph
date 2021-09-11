package trumpwilltriumph;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 * The user must click on an image under a certain amount of times to win. If the user takes too long, the user loses.
 */
class Clicking {

    private final JFrame frameState = new JFrame(TrumpWillTriumph.GAME_TITLE);

    private static final int AMOUNT_OF_CLICKS_NEEDED = 30;
    private static final int TIME_GIVEN_IN_SECONDS = 10;

    void clicking() {
        doExposition();
        configureGUI();
        mouseClickAction();
    }

    private void doExposition() {
        switch (TrumpWillTriumph.touringState) {
            case NEUTRAL_HAWAII:
                TrumpWillTriumph.expositionDialog("Clicking.exposition_hawaii_1", "Clicking.exposition_hawaii_2",
                        "Clicking.exposition_hawaii_3");
                break;
            case NEUTRAL_WYOMING:
                TrumpWillTriumph.expositionDialog("Clicking.exposition_wyoming_1", "Clicking.exposition_wyoming_2",
                        "Clicking.exposition_wyoming_3");
                break;
            case NEUTRAL_KANSAS:
                TrumpWillTriumph.expositionDialog("Clicking.exposition_kansas_1", "Clicking.exposition_kansas_2",
                        "Clicking.exposition_kansas_3");
                break;
        }
    }

    private void configureGUI() {
        JLabel background = null;
        frameState.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameState.setResizable(false);
        switch (TrumpWillTriumph.touringState) {
            case NEUTRAL_HAWAII:
                background = new JLabel(new ImageIcon("Assets/Coconut.png"));
                frameState.setSize(228, 250);
                break;
            case NEUTRAL_WYOMING:
                background = new JLabel(new ImageIcon("Assets/Chicken.png"));
                frameState.setSize(185, 139);
                break;
            case NEUTRAL_KANSAS:
                background = new JLabel(new ImageIcon("Assets/Cow.png"));
                frameState.setSize(223, 109);
                break;
        }
        frameState.add(background);
        frameState.setLocationRelativeTo(null);
        frameState.setIconImage(TrumpWillTriumph.ICON_TRUMP.getImage());
        frameState.setVisible(true);
    }

    private void mouseClickAction() {
        final long startTime = System.nanoTime();
        frameState.addMouseListener(new MouseListener() {
            int clickCount;

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getModifiers() == InputEvent.BUTTON1_MASK) {
                    clickCount++;
                    if (clickCount == AMOUNT_OF_CLICKS_NEEDED) {
                        final long totalTime =
                                (System.nanoTime() - startTime) / TrumpWillTriumph.NANO_SECONDS_PER_SECOND;
                        frameState.setVisible(false);
                        if (totalTime <= TIME_GIVEN_IN_SECONDS) {
                            TrumpWillTriumph.win();
                        } else {
                            TrumpWillTriumph.lose();
                        }
                    }
                }
            }

            @Override
            public void mouseClicked(MouseEvent me) {
                // Nothing happens.
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                // Nothing happens.
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                // Nothing happens.
            }

            @Override
            public void mouseExited(MouseEvent me) {
                // Nothing happens.
            }
        });
    }
}
