package callofdemocracy;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 * If the user successfully shoots the target animal, the user wins. Else, the user loses.
 */
class Shooting {

    private final JFrame frameState = new JFrame(CallOfDemocracy.GAME_TITLE);

    private long startTime;

    void shooting() {
        doExposition();
        configureGUI();
        createCursorImage();
        mouseActions();
        userLosesIfTakingTooLong();
    }

    private void doExposition() {
        String exposition = "ERROR";
        switch (CallOfDemocracy.touringState) {
            case NEUTRAL_ALASKA:
                exposition = "Mr. Trump, a bear has just appeared!\nShoot it quickly in the head so that it does not "
                        + "run away.\nThis will surely bring us good media coverage in Alaska.";
                break;
            case NEUTRAL_TEXAS:
                exposition = "Mr. Trump, a mountain lion has just appeared!\nShoot it quickly in the head so that it "
                        + "does not run away.\nThis will surely bring us good media coverage in Texas.";
                break;
            case NEUTRAL_FLORIDA:
                exposition = "Mr. Trump, an alligator has just appeared!\nShoot it quickly in the head or body so that "
                        + "it does not run away.\nThis will surely bring us good media coverage in Florida.";
                break;
        }
        CallOfDemocracy.displayExposition(exposition);
    }

    private void configureGUI() {
        frameState.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameState.setResizable(false);
        JLabel background = null;
        switch (CallOfDemocracy.touringState) {
            case NEUTRAL_ALASKA:
                background = new JLabel(new ImageIcon("Assets/Bear.png"));
                frameState.setSize(320, 240);
                break;
            case NEUTRAL_TEXAS:
                background = new JLabel(new ImageIcon("Assets/MountainLion.png"));
                frameState.setSize(323, 265);
                break;
            case NEUTRAL_FLORIDA:
                background = new JLabel(new ImageIcon("Assets/Alligator.png"));
                frameState.setSize(356, 225);
                break;
        }
        frameState.add(background);
        frameState.setLocationRelativeTo(null);
        frameState.setIconImage(CallOfDemocracy.ICON_TRUMP.getImage());
        frameState.setVisible(true);
    }

    private void createCursorImage() {
        final ImageIcon image = new ImageIcon("Assets/GunCursor.png");
        frameState.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(image.getImage(), new Point(0, 0), ""));
    }

    private void mouseActions() {
        startTime = System.nanoTime();
        frameState.addMouseListener(new MouseListener() {

            @Override
            public void mousePressed(MouseEvent e) {
                frameState.setVisible(false);
                if (isHit(e)) {
                    CallOfDemocracy.customText("Congratulations! You killed it!");
                    CallOfDemocracy.win();
                } else {
                    CallOfDemocracy.customText("Mr. Trump, you missed!");
                    CallOfDemocracy.lose();
                }
            }

            @Override
            public void mouseClicked(MouseEvent me) {
                // Does nothing.
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                // Does nothing.
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                // Does nothing.
            }

            @Override
            public void mouseExited(MouseEvent me) {
                // Does nothing.
            }
        });
    }

    private boolean isHit(MouseEvent e) {
        boolean inBounds = false;
        switch (CallOfDemocracy.touringState) {
            case NEUTRAL_ALASKA:
                inBounds = e.getX() > 118 & e.getX() < 138 && e.getY() > 145 && e.getY() < 175;
                break;
            case NEUTRAL_TEXAS:
                inBounds = e.getX() > 185 & e.getX() < 215 && e.getY() > 75 && e.getY() < 105;
                break;
            case NEUTRAL_FLORIDA:
                inBounds = e.getX() > 133 & e.getX() < 182 && e.getY() > 85 && e.getY() < 105;
                break;
        }
        return inBounds;
    }

    private void userLosesIfTakingTooLong() {
        frameState.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseMoved(MouseEvent me) {
                final long totalTime = (System.nanoTime() - startTime) / CallOfDemocracy.NANO_SECONDS_PER_SECOND;
                if (totalTime > 5) {
                    frameState.setVisible(false);
                    CallOfDemocracy.customText("Mr. Trump, you took too long, as such it got startled!");
                    CallOfDemocracy.lose();
                }
            }

            @Override
            public void mouseDragged(MouseEvent me) {
                // Does nothing.
            }
        });
    }
}
