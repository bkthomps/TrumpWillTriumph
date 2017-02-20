package trumpwilltriump;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * The user is presented with an image that changes frames on each click. If the user clicks a certain amount of times
 * fast enough, the user wins. Else, the user loses.
 */
class AnimatedClicking {

    private final JFrame frameState = new JFrame(TrumpWillTriump.GAME_TITLE);
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
        String exposition = "ERROR";
        switch (TrumpWillTriump.touringState) {
            case NEUTRAL_CALIFORNIA:
                exposition = "Mr. Trump, California loves surfing, so to win their vote, just left\nclick on the surf "
                        + "board as fast as you can to clean it! If you do\nit fast enough, they surely will see us "
                        + "eye to eye!";
                startingImage = "Assets/Surfboard1.png";
                guiWidth = 303;
                guiHeight = 114;
                break;
            case NEUTRAL_IDAHO:
                exposition = "Mr. Trump, Idaho is the potato state, to win\ntheir vote, just left click and chop the "
                        + "potatoes!";
                startingImage = "Assets/Potato1.png";
                guiWidth = 353;
                guiHeight = 226;
                break;
            case NEUTRAL_KENTUCKY:
                exposition = "Mr. Trump, Kentucky is the chicken state, to win\ntheir vote, just left click and cook "
                        + "the chicken!";
                startingImage = "Assets/Chicken1.png";
                guiWidth = 371;
                guiHeight = 365;
                break;
            case NEUTRAL_WISCONSIN:
                exposition = "Mr. Trump, Wisconsin loves making cheese, to win\ntheir vote, just left click and churn "
                        + "the cheese!";
                startingImage = "Assets/Churn1.png";
                guiWidth = 222;
                guiHeight = 346;
                break;
        }
        TrumpWillTriump.displayExposition(exposition);
    }

    private void configureGUI() {
        frameState.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameState.setResizable(false);
        background = new JLabel(new ImageIcon(startingImage));
        frameState.add(background);
        frameState.setSize(guiWidth, guiHeight);
        frameState.setLocationRelativeTo(null);
        frameState.setIconImage(TrumpWillTriump.ICON_TRUMP.getImage());
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
        switch (TrumpWillTriump.touringState) {
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
        final int NANOSECONDS_PER_SECOND = 1000000000;
        final long totalTime = (System.nanoTime() - startTime) / NANOSECONDS_PER_SECOND;
        if (totalTime < inputValueInSeconds) {
            TrumpWillTriump.win();
        } else {
            TrumpWillTriump.lose();
        }
    }
}
