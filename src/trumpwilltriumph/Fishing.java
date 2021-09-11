package trumpwilltriumph;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 * The user must cast a rod, and afterwards pulling the rod back in. If the rod is out for long enough, the user wins.
 * Else, the user loses.
 */
class Fishing {

    private final JFrame frameState = new JFrame(TrumpWillTriumph.GAME_TITLE);

    void fishing() {
        doExposition();
        configureGUI();
        configureCursorImage();
        doMouseActions();
    }

    private void doExposition() {
        switch (TrumpWillTriumph.touringState) {
            case NEUTRAL_MINNESOTA:
                TrumpWillTriumph.expositionDialog("Fishing.exposition_minnesota_1", "Fishing.exposition_minnesota_2",
                        "Fishing.exposition_minnesota_3", "Fishing.exposition_minnesota_4");
                break;
            case NEUTRAL_DELAWARE:
                TrumpWillTriumph.expositionDialog("Fishing.exposition_delaware_1", "Fishing.exposition_delaware_2",
                        "Fishing.exposition_delaware_3", "Fishing.exposition_delaware_4");
                break;
        }
    }

    private void configureGUI() {
        JLabel background;
        frameState.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameState.setResizable(false);

        if (TrumpWillTriumph.touringState == StateStatus.NEUTRAL_MINNESOTA) {
            background = new JLabel(new ImageIcon("Assets/IceFishing.png"));
            frameState.setSize(353, 258);
        } else {
            background = new JLabel(new ImageIcon("Assets/Fishing.png"));
            frameState.setSize(353, 287);
        }
        frameState.add(background);
        frameState.setLocationRelativeTo(null);
        frameState.setIconImage(TrumpWillTriumph.ICON_TRUMP.getImage());
        frameState.setVisible(true);
    }

    private void configureCursorImage() {
        final ImageIcon image = new ImageIcon("Assets/FishingCursor.png");
        frameState.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(image.getImage(), new Point(0, 0), ""));
    }

    private void doMouseActions() {
        frameState.addMouseListener(new MouseListener() {

            long startTime;

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getModifiers() == InputEvent.BUTTON1_MASK) {
                    startTime = System.nanoTime();
                } else if (e.getModifiers() == InputEvent.BUTTON3_MASK) {
                    final long totalTime = (System.nanoTime() - startTime) / TrumpWillTriumph.NANO_SECONDS_PER_SECOND;
                    int fish = (int) (Math.random() * 30 / totalTime);
                    frameState.setVisible(false);
                    if (fish == 0) {
                        TrumpWillTriumph.customDialog("Fishing.winning");
                        TrumpWillTriumph.win();
                    } else {
                        TrumpWillTriumph.customDialog("Fishing.losing");
                        TrumpWillTriumph.lose();
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
