package callofdemocracy;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 * The user must box with Hillary Clinton. To achieve a combo, two jabs must be performed, followed by one hook. If the
 * user hits Hillary Clinton enough times, the user wins and Hillary Clinton dies. Else, the user loses.
 */
class Boxing {

    private final JFrame frameState = new JFrame(CallOfDemocracy.GAME_TITLE);
    private final JLabel background = new JLabel(new ImageIcon("Assets/BoxingTitle.png"));

    private boolean matchStarted;
    private int hillaryDamage, trumpDamage, combo;
    private long startTime;

    void boxing() {
        configureGUI();
        mouseAction();
    }

    private void configureGUI() {
        CallOfDemocracy.hideMap();
        frameState.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameState.setResizable(false);
        frameState.add(background);
        frameState.setSize(353, 275);
        frameState.setLocationRelativeTo(null);
        frameState.setIconImage(CallOfDemocracy.ICON_TRUMP.getImage());
        frameState.setVisible(true);
        startTime = System.nanoTime();
    }

    private void mouseAction() {
        frameState.addMouseListener(new MouseListener() {

            @Override
            public void mousePressed(MouseEvent e) {
                if (matchStarted) {
                    matchInProgress(e);
                } else {
                    startMatch();
                }
            }

            @Override
            public void mouseClicked(MouseEvent me) {
                // Not used.
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                // Not used.
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                // Not used.
            }

            @Override
            public void mouseExited(MouseEvent me) {
                // Not used.
            }
        });
    }

    private void matchInProgress(MouseEvent e) {
        final long totalTime = (System.nanoTime() - startTime) / CallOfDemocracy.NANO_SECONDS_PER_SECOND;
        if (isJab(e) && !isGameOver() && isJabCoolDownOver(totalTime)) {
            resetTimeAndAddDamageTrump(totalTime);
            doJabDamageAndAddToCombo();
        } else if (isHook(e) && !isGameOver() && isHookCoolDownOver(totalTime)) {
            resetTimeAndAddDamageTrump(totalTime);
            doHookDamageAndResetCombo();
        }
        loseIfTrumpIsDead();
        updateHillaryImage();
    }

    private boolean isGameOver() {
        return hillaryDamage == 200;
    }

    private boolean isJab(MouseEvent e) {
        return e.getModifiers() == InputEvent.BUTTON1_MASK;
    }

    private boolean isJabCoolDownOver(long totalTime) {
        return totalTime >= 1;
    }

    private void doJabDamageAndAddToCombo() {
        if (combo == 0 || combo == 1) {
            combo++;
        }
        hillaryDamage += 1;
    }

    private boolean isHook(MouseEvent e) {
        return e.getModifiers() == InputEvent.BUTTON3_MASK;
    }

    private boolean isHookCoolDownOver(long totalTime) {
        return totalTime >= 3;
    }

    private void doHookDamageAndResetCombo() {
        if (combo == 2) {
            hillaryDamage += 10;
            combo = 0;
        }
        hillaryDamage += 3;
    }

    private void resetTimeAndAddDamageTrump(long totalTime) {
        startTime = System.nanoTime();
        trumpDamage += totalTime;
    }

    private void loseIfTrumpIsDead() {
        if (trumpDamage > 50) {
            frameState.setVisible(false);
            CallOfDemocracy.lose();
        }
    }

    private void updateHillaryImage() {
        if (hillaryDamage >= 5 && hillaryDamage < 50) {
            background.setIcon(new ImageIcon("Assets/Hillary" + (hillaryDamage / 5) + ".png"));
        } else if (hillaryDamage >= 50 && hillaryDamage < 200) {
            background.setIcon(new ImageIcon("Assets/Hillary10.png"));
            frameState.setSize(218, 149);
            frameState.setLocationRelativeTo(null);
            hillaryDamage = 200;
        } else if (isGameOver()) {
            frameState.setVisible(false);
            CallOfDemocracy.win();
        }
    }

    private void startMatch() {
        background.setIcon(new ImageIcon("Assets/Hillary0.png"));
        frameState.setSize(213, 375);
        frameState.setLocationRelativeTo(null);
        matchStarted = true;
    }
}
