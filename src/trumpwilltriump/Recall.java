package trumpwilltriump;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.WindowConstants;

/**
 * The user must successfully determine the number combination. If the user does so, the user wins. If the user fails to
 * do so, the user loses.
 */
class Recall {

    private final JFrame frameState = new JFrame("TWT");
    private final JLabel correct = new JLabel("Correct");
    private final JLabel incorrect = new JLabel("Incorrect");
    private final JLabel tries = new JLabel("Tries Left: 10");
    private final JButton button = new JButton("Check");
    private final JSlider[] slider = new JSlider[AMOUNT_OF_SLIDERS];

    private static final int AMOUNT_OF_SLIDERS = 4;

    private final int recallArray[] = new int[AMOUNT_OF_SLIDERS];
    private int recallTries = 10;

    void recall() {
        doExposition();
        setSliderValues();
        configureGUI();
        doActionListener();
    }

    private void doExposition() {
        final String exposition = "Mr. Trump, to test your skill, play a logic game. There will be\nfour numbers that "
                + "are randomly generated, but you are not\ntold the numbers. Use the sliders to guess the numbers.\n"
                + "To help you, you will be told how many correct and how many\nincorrect numbers you have selected.";
        TrumpWillTriump.displayExposition(exposition);
    }

    private void setSliderValues() {
        for (int counter = 0; counter < recallArray.length; counter++) {
            recallArray[counter] = (int) (Math.random() * 4) + 1;
        }
    }

    private void configureGUI() {
        frameState.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameState.setResizable(false);

        for (int counter = 0; counter < slider.length; counter++) {
            slider[counter] = new JSlider(JSlider.HORIZONTAL, 1, 4, 1);
            slider[counter].setPaintLabels(true);
            slider[counter].setMajorTickSpacing(1);
            slider[counter].setPreferredSize(new Dimension(150, 40));
        }

        frameState.setLayout(new GridLayout(8, 1));
        for (JSlider aSlider : slider) {
            frameState.add(aSlider);
        }
        frameState.add(correct);
        frameState.add(incorrect);
        frameState.add(tries);
        frameState.add(button);

        frameState.pack();
        frameState.setLocationRelativeTo(null);
        frameState.setIconImage(TrumpWillTriump.ICON_TRUMP.getImage());
        frameState.setVisible(true);
    }

    private void doActionListener() {
        button.addActionListener((ActionEvent e) -> {
            int good = 0, bad = 0;
            recallTries--;
            for (int counter = 0; counter < recallArray.length; counter++) {
                if (slider[counter].getValue() == recallArray[counter]) {
                    good++;
                } else {
                    bad++;
                }
            }
            progressToNextRoundOrEnd(good, bad);
        });
    }

    private void progressToNextRoundOrEnd(int good, int bad) {
        if (good != 4 && recallTries >= 0) {
            correct.setText("Correct: " + good);
            incorrect.setText("Incorrect: " + bad);
            tries.setText("Tries Left: " + recallTries);
        } else if (good == 4 && recallTries >= -1) {
            frameState.setVisible(false);
            TrumpWillTriump.win();
        } else {
            frameState.setVisible(false);
            TrumpWillTriump.lose();
        }
    }
}
