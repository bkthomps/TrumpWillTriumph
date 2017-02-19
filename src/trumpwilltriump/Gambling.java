package trumpwilltriump;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * The user is presented with randomly generated gambling imagery, if three identical images appear in a row, the user
 * wins. Else, the user loses.
 */
class Gambling {

    private final int[] val = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    private final JFrame frameState = new JFrame(TrumpWillTriump.GAME_TITLE);
    private final JLabel[] background = new JLabel[val.length];

    private int clickCount;

    void gambling() {
        doExposition();
        configureGUI();
        mouseAction();
    }

    private void doExposition() {
        TrumpWillTriump.displayExposition("Mr. Trump, Nevada is the gambling state, so\nnaturally, to win their vote, "
                + "you shall gamble.\nYou will have ten tries to get a matching pair.\nTo try the slot again, click "
                + "on it.");
    }

    private void configureGUI() {
        frameState.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameState.setResizable(false);
        frameState.setLayout(new GridLayout(3, 3));
        for (int counter = 0; counter < background.length; counter++) {
            background[counter] = new JLabel(new ImageIcon("Assets/Slot" + counter + ".png"));
            frameState.add(background[counter]);
        }
        frameState.setSize(423, 445);
        frameState.setLocationRelativeTo(null);
        frameState.setIconImage(TrumpWillTriump.ICON_TRUMP.getImage());
        frameState.setVisible(true);
    }

    private void mouseAction() {
        frameState.addMouseListener(new MouseListener() {

            @Override
            public void mousePressed(MouseEvent e) {
                endGameIfConditionsMet();
                displayImages();
                clickCount++;
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

    private void endGameIfConditionsMet() {
        if (isThreeSameImagesInRow()) {
            frameState.setVisible(false);
            TrumpWillTriump.win();
        } else if (isUserOutOfTries()) {
            frameState.setVisible(false);
            TrumpWillTriump.lose();
        }
    }

    private boolean isThreeSameImagesInRow() {
        return (val[0] == val[1] && val[1] == val[2]) || (val[3] == val[4] && val[4] == val[5])
                || (val[6] == val[7] && val[7] == val[8]) || (val[0] == val[4] && val[4] == val[8])
                || (val[6] == val[4] && val[4] == val[2]) || (val[0] == val[3] && val[3] == val[6])
                || (val[1] == val[4] && val[4] == val[7]) || (val[2] == val[5] && val[5] == val[8]);
    }

    private boolean isUserOutOfTries() {
        return clickCount >= 10;
    }

    private void displayImages() {
        for (int counter = 0; counter < 9; counter++) {
            val[counter] = (int) (Math.random() * 9);
            background[counter].setIcon(new ImageIcon("Assets/Slot" + val[counter] + ".png"));
        }
    }
}
