package callofdemocracy;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 * The user must successfully type in the correct keys. If the user does so, the user wins. Else, the user loses.
 */
class Skiing {

    private final JFrame frameState = new JFrame(CallOfDemocracy.GAME_TITLE);
    private final JLabel image = new JLabel(new ImageIcon("Assets/SkiingRed.png"));

    private boolean done, endTimer, next = true;
    private int skiingCompletion, skiingColor;

    void skiing() {
        doExposition();
        configureGUI();
        onKeyboard();
        onTimer();
    }

    private void doExposition() {
        String exposition = "ERROR";
        switch (CallOfDemocracy.touringState) {
            case NEUTRAL_NORTH_CAROLINA:
                exposition = "Mr. Trump, North Carolina loves water skiing; therefore,\nsuch is what you should do to "
                        + "gain their vote. Type the left\nkey when red is shown and right when blue is shown.\nYou "
                        + "will need to immediately use your keyboard!";
                break;
            case NEUTRAL_MAINE:
                exposition = "Mr. Trump, Maine loves tubing; therefore, such is what\nyou should do to gain their "
                        + "vote. Type the left key\nwhen red is shown and right when blue is shown.\nYou will need to "
                        + "immediately use your keyboard!";
                break;
            case NEUTRAL_VERMONT:
                exposition = "Mr. Trump, Vermont loves downhill skiing; therefore,\nsuch is what you should do to "
                        + "gain their vote. Type the left\nkey when red is shown and right when blue is shown.\nYou "
                        + "will need to immediately use your keyboard!";
                break;
        }
        CallOfDemocracy.displayExposition(exposition);
    }

    private void configureGUI() {
        frameState.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameState.setResizable(false);
        frameState.add(image);
        frameState.setSize(303, 325);
        frameState.setLocationRelativeTo(null);
        frameState.setIconImage(CallOfDemocracy.ICON_TRUMP.getImage());
        frameState.setVisible(true);
    }

    private void onKeyboard() {
        frameState.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (done) {
                    if (skiingCompletion < 10) {
                        if (e.getKeyCode() == skiingColor) {
                            skiingCompletion += 1;
                            done = false;
                            next = true;
                            if (Math.random() * 3 < 1) {
                                image.setIcon(new ImageIcon("Assets/SkiingSuper.png"));
                            } else if (Math.random() * 3 < 1) {
                                image.setIcon(new ImageIcon("Assets/SkiingGreat.png"));
                            } else {
                                image.setIcon(new ImageIcon("Assets/SkiingGood.png"));
                            }
                        } else {
                            next = true;
                            endTimer = true;
                            frameState.setVisible(false);
                            CallOfDemocracy.lose();
                        }
                    } else {
                        next = true;
                        endTimer = true;
                        frameState.setVisible(false);
                        CallOfDemocracy.win();
                    }
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // Not used.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Not used.
            }
        });
    }

    private void onTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (endTimer) {
                    timer.cancel();
                    endTimer = false;
                }
                if (next) {
                    done = true;
                    next = false;
                    skiingColor = ((int) (Math.random() + 0.5)) * 2 + 37;
                    if (skiingColor == 37) {
                        image.setIcon(new ImageIcon("Assets/SkiingRed.png"));
                    } else {
                        image.setIcon(new ImageIcon("Assets/SkiingBlue.png"));
                    }
                } else {
                    timer.cancel();
                    endTimer = false;
                    frameState.setVisible(false);
                    CallOfDemocracy.lose();
                }
            }
        }, 0, 2000);
    }
}
