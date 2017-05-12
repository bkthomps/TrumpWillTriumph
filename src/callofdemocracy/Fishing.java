package callofdemocracy;

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

    private final JFrame frameState = new JFrame(CallOfDemocracy.GAME_TITLE);

    void fishing() {
        doExposition();
        configureGUI();
        configureCursorImage();
        doMouseActions();
    }

    private void doExposition() {
        String exposition = "ERROR";
        switch (CallOfDemocracy.touringState) {
            case NEUTRAL_MINNESOTA:
                exposition = "Mr. Trump, ice fishing would greatly improve your success in\nMinnesota. Left click to "
                        + "throw your line out, right click to bring\nit back in. You only get one cast. The longer "
                        + "your line is\nout, the higher chance you have of catching something.";
                break;
            case NEUTRAL_DELAWARE:
                exposition = "Mr. Trump, fishing would greatly improve your success in\nDelaware. Left click to throw "
                        + "your line out, right click to bring\nit back in. You only get one cast. The longer your "
                        + "line is\nout, the higher chance you have of catching something.";
                break;
        }
        CallOfDemocracy.displayExposition(exposition);
    }

    private void configureGUI() {
        JLabel background;
        frameState.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameState.setResizable(false);

        if (CallOfDemocracy.touringState == StateStatus.NEUTRAL_MINNESOTA) {
            background = new JLabel(new ImageIcon("Assets/IceFishing.png"));
            frameState.setSize(353, 258);
        } else {
            background = new JLabel(new ImageIcon("Assets/Fishing.png"));
            frameState.setSize(353, 287);
        }
        frameState.add(background);
        frameState.setLocationRelativeTo(null);
        frameState.setIconImage(CallOfDemocracy.ICON_TRUMP.getImage());
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
                    final long NANOSECONDS_PER_SECOND = 1000000000;
                    final long totalTime = (System.nanoTime() - startTime) / NANOSECONDS_PER_SECOND;
                    int fish = (int) (Math.random() * 30 / totalTime);
                    frameState.setVisible(false);
                    if (fish == 0) {
                        CallOfDemocracy.customText("Mr. Trump, you caught a fish!");
                        CallOfDemocracy.win();
                    } else {
                        CallOfDemocracy.customText("Mr. Trump, you didn't catch anything...");
                        CallOfDemocracy.lose();
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
