package callofdemocracy;

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

    private final JFrame frameState = new JFrame(CallOfDemocracy.GAME_TITLE);

    private static final int AMOUNT_OF_CLICKS_NEEDED = 30;
    private static final int TIME_GIVEN_IN_SECONDS = 10;

    void clicking() {
        doExposition();
        configureGUI();
        mouseClickAction();
    }

    private void doExposition() {
        String exposition = "ERROR";
        switch (CallOfDemocracy.touringState) {
            case NEUTRAL_HAWAII:
                exposition = "Mr. Trump, Hawaii is a tropical state, so\nto win it, you must break open a coconut\nby "
                        + "repeatedly left clicking on it.";
                break;
            case NEUTRAL_WYOMING:
                exposition = "Mr. Trump, Wyoming is a farming state, so\nto win it, you must collect a "
                        + "chicken's\neggs. To do so, repeatedly left click on it.";
                break;
            case NEUTRAL_KANSAS:
                exposition = "Mr. Trump, Kansas is a farming state,\nso to win it, you must milk a cow.\nTo do so, "
                        + "repeatedly left click on it.";
                break;
        }
        CallOfDemocracy.displayExposition(exposition);
    }

    private void configureGUI() {
        JLabel background = null;
        frameState.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameState.setResizable(false);
        switch (CallOfDemocracy.touringState) {
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
        frameState.setIconImage(CallOfDemocracy.ICON_TRUMP.getImage());
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
                        final int NANO_SECONDS_PER_SECOND = 1000000000;
                        final long totalTime = (System.nanoTime() - startTime) / NANO_SECONDS_PER_SECOND;
                        frameState.setVisible(false);
                        if (totalTime <= TIME_GIVEN_IN_SECONDS) {
                            CallOfDemocracy.win();
                        } else {
                            CallOfDemocracy.lose();
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
