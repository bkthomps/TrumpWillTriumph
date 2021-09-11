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
 * The user is presented with a sequence of arrows, which then must be repeated using the keypad once the sequence is
 * over. If the user successfully repeats the pattern, the user wins. Else, the user loses.
 */
class Memory {

    private final JFrame frameState = new JFrame(TrumpWillTriumph.GAME_TITLE);
    private final JLabel image = new JLabel(new ImageIcon("Assets/MemoryGo.png"));

    private boolean done, endTimer;
    private int memoryLevel, memorySequence, memoryCounter, memoryCompletion;
    private final int[] memoryArray = new int[5];

    void memory() {
        doExposition();
        configureGUI();
        doKeyListener();
        onTimer();
    }

    private void doExposition() {
        TrumpWillTriumph.expositionDialog("Memory.exposition_1", "Memory.exposition_2");
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

    private void doKeyListener() {
        frameState.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (done) {
                    if (e.getKeyCode() == memoryArray[memorySequence]) {
                        if (memorySequence != 4) {
                            if (memorySequence == memoryLevel + 1) {
                                memorySequence = 0;
                                memoryCounter = 0;
                                memoryCompletion++;
                            } else {
                                memorySequence++;
                            }
                        } else {
                            endTimer = true;
                            frameState.setVisible(false);
                            TrumpWillTriumph.win();
                        }
                    } else {
                        endTimer = true;
                        frameState.setVisible(false);
                        TrumpWillTriumph.lose();
                    }
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // Not needed.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Not needed.
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
                if (memoryLevel == memoryCompletion && (memoryLevel == 0 || memoryLevel == 1 || memoryLevel == 2)) {
                    if (memoryCounter < memoryLevel + 3) {
                        done = false;
                        if (memoryCounter != 0) {
                            do {
                                memoryArray[memoryCounter] = (int) (Math.random() * 4) + 37;
                            } while (memoryArray[memoryCounter] == memoryArray[memoryCounter - 1]);
                        } else {
                            memoryArray[memoryCounter] = (int) (Math.random() * 4) + 37;
                        }
                        switch (memoryArray[memoryCounter]) {
                            case 37:
                                image.setIcon(new ImageIcon("Assets/MemoryLeft.png"));
                                break;
                            case 38:
                                image.setIcon(new ImageIcon("Assets/MemoryUp.png"));
                                break;
                            case 39:
                                image.setIcon(new ImageIcon("Assets/MemoryRight.png"));
                                break;
                            case 40:
                                image.setIcon(new ImageIcon("Assets/MemoryDown.png"));
                                break;
                        }
                        memoryCounter++;
                    } else if (memoryCounter == memoryLevel + 3) {
                        image.setIcon(new ImageIcon("Assets/MemoryGo.png"));
                        memoryLevel++;
                        done = true;
                    }
                }
            }
        }, 0, 1000);
    }
}
