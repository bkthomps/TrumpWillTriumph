package trumpwilltriumph;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 * The user is presented with an image that changes frames on each click. If the user clicks a certain amount of times
 * fast enough, the user wins. Else, the user loses.
 */
class AnimatedClicking {

    private final JFrame frameState = new JFrame(TrumpWillTriumph.GAME_TITLE);
    private JLabel background;

    private int guiWidth, guiHeight, clickCount;
    private long startTime;
    private String startingImage;

    void animatedClicking() {
        doExposition();
        configureGUI();
        animate();
    }

    private void doExposition() {
        switch (TrumpWillTriumph.touringState) {
            case NEUTRAL_CALIFORNIA:
                startingImage = "Assets/Surfboard1.png";
                guiWidth = 303;
                guiHeight = 114;
                TrumpWillTriumph.expositionDialog("AnimatedClicking.exposition_california_1",
                        "AnimatedClicking.exposition_california_2", "AnimatedClicking.exposition_california_3");
                break;
            case NEUTRAL_IDAHO:
                startingImage = "Assets/Potato1.png";
                guiWidth = 353;
                guiHeight = 226;
                TrumpWillTriumph.expositionDialog("AnimatedClicking.exposition_idaho_1",
                        "AnimatedClicking.exposition_idaho_2");
                break;
            case NEUTRAL_KENTUCKY:
                startingImage = "Assets/Chicken1.png";
                guiWidth = 371;
                guiHeight = 365;
                TrumpWillTriumph.expositionDialog("AnimatedClicking.exposition_kentucky_1",
                        "AnimatedClicking.exposition_kentucky_2");
                break;
            case NEUTRAL_WISCONSIN:
                startingImage = "Assets/Churn1.png";
                guiWidth = 222;
                guiHeight = 346;
                TrumpWillTriumph.expositionDialog("AnimatedClicking.exposition_wisconsin_1",
                        "AnimatedClicking.exposition_wisconsin_2");
                break;
        }
    }

    private void configureGUI() {
        frameState.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameState.setResizable(false);
        background = new JLabel(new ImageIcon(startingImage));
        frameState.add(background);
        frameState.setSize(guiWidth, guiHeight);
        frameState.setLocationRelativeTo(null);
        frameState.setIconImage(TrumpWillTriumph.ICON_TRUMP.getImage());
        frameState.setVisible(true);
        startTime = System.nanoTime();
    }

    private void animate() {
        frameState.addMouseListener(new MouseListener() {

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getModifiers() == InputEvent.BUTTON1_MASK) {
                    dispatchAnimation();
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

    private void dispatchAnimation() {
        switch (TrumpWillTriumph.touringState) {
            case NEUTRAL_CALIFORNIA:
                californiaAnimate();
                break;
            case NEUTRAL_IDAHO:
                idahoAnimate();
                break;
            case NEUTRAL_KENTUCKY:
                kentuckyAnimate();
                break;
            case NEUTRAL_WISCONSIN:
                wisconsinAnimate();
                break;
        }
    }

    private void californiaAnimate() {
        incrementClickCountIfLessThanInputValue(41);
        if (clickCount != 41) {
            background.setIcon(new ImageIcon("Assets/Surfboard" + (clickCount / 10 + 1) + ".png"));
        } else {
            endGameAndWinIfTotalTimeIsLessThanInputValueInSeconds(10);
        }
    }

    private void idahoAnimate() {
        incrementClickCountIfLessThanInputValue(49);
        if (clickCount > 0 && clickCount <= 48) {
            background.setIcon(new ImageIcon("Assets/Potato" + (clickCount % 16 + 1) + ".png"));
        } else {
            endGameAndWinIfTotalTimeIsLessThanInputValueInSeconds(12);
        }
    }

    private void kentuckyAnimate() {
        incrementClickCountIfLessThanInputValue(35);
        if (clickCount != 35) {
            background.setIcon(new ImageIcon("Assets/Chicken" + clickCount + ".png"));
        } else {
            endGameAndWinIfTotalTimeIsLessThanInputValueInSeconds(11);
        }
    }

    private void wisconsinAnimate() {
        incrementClickCountIfLessThanInputValue(62);
        if (clickCount > 0 && clickCount <= 60) {
            background.setIcon(new ImageIcon("Assets/Churn" + (clickCount % 30 + 1) + ".png"));
        } else {
            endGameAndWinIfTotalTimeIsLessThanInputValueInSeconds(15);
        }
    }

    private void incrementClickCountIfLessThanInputValue(int inputValue) {
        if (clickCount < inputValue) {
            clickCount++;
        }
    }

    private void endGameAndWinIfTotalTimeIsLessThanInputValueInSeconds(int inputValueInSeconds) {
        frameState.setVisible(false);
        final long totalTime = (System.nanoTime() - startTime) / TrumpWillTriumph.NANO_SECONDS_PER_SECOND;
        if (totalTime < inputValueInSeconds) {
            TrumpWillTriumph.win();
        } else {
            TrumpWillTriumph.lose();
        }
    }
}
