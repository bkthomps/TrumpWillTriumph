package trumpwilltriumph;

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

    private final JFrame frameState = new JFrame(TrumpWillTriumph.GAME_TITLE);
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
        switch (TrumpWillTriumph.touringState) {
            case NEUTRAL_NORTH_CAROLINA:
                TrumpWillTriumph.expositionDialog("Skiing.exposition_northCarolina_1",
                        "Skiing.exposition_northCarolina_2", "Skiing.exposition_northCarolina_3",
                        "Skiing.exposition_northCarolina_4");
                break;
            case NEUTRAL_MAINE:
                TrumpWillTriumph.expositionDialog("Skiing.exposition_maine_1", "Skiing.exposition_maine_2",
                        "Skiing.exposition_maine_3", "Skiing.exposition_maine_4");
                break;
            case NEUTRAL_VERMONT:
                TrumpWillTriumph.expositionDialog("Skiing.exposition_vermont_1", "Skiing.exposition_vermont_2",
                        "Skiing.exposition_vermont_3", "Skiing.exposition_vermont_4");
                break;
        }
    }

    private void configureGUI() {
        frameState.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameState.setResizable(false);
        frameState.add(image);
        frameState.setSize(303, 325);
        frameState.setLocationRelativeTo(null);
        frameState.setIconImage(TrumpWillTriumph.ICON_TRUMP.getImage());
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
                            TrumpWillTriumph.lose();
                        }
                    } else {
                        next = true;
                        endTimer = true;
                        frameState.setVisible(false);
                        TrumpWillTriumph.win();
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
                    TrumpWillTriumph.lose();
                }
            }
        }, 0, 2000);
    }
}
