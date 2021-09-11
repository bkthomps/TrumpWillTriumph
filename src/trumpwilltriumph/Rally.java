package trumpwilltriumph;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 * The user must pick the best speech options to deliver at the Trump rally. If the user does so, the user wins. Else,
 * the user loses.
 */
class Rally {

    private final JFrame frameState = new JFrame(TrumpWillTriumph.GAME_TITLE);
    private final JLabel background = new JLabel(new ImageIcon("Assets/IowaBackground.png"));
    private final JButton optionOne = new JButton(TrumpWillTriumph.RESOURCE.getString("Rally.question_1_1"));
    private final JButton optionTwo = new JButton(TrumpWillTriumph.RESOURCE.getString("Rally.question_1_2"));

    private int score, rallyStatus;

    void rally() {
        configureGUI();
        userClicksButtonOne();
        userClicksButtonTwo();
    }

    private void configureGUI() {
        TrumpWillTriumph.hideMap();
        frameState.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameState.setResizable(false);
        frameState.add(background, BorderLayout.NORTH);
        frameState.add(optionOne, BorderLayout.CENTER);
        frameState.add(optionTwo, BorderLayout.SOUTH);
        frameState.setSize(348, 310);
        frameState.setLocationRelativeTo(null);
        frameState.setIconImage(TrumpWillTriumph.ICON_TRUMP.getImage());
        frameState.setVisible(true);
    }

    private void userClicksButtonOne() {
        optionOne.addActionListener((ActionEvent e) -> buttonPress(1));
    }

    private void userClicksButtonTwo() {
        optionTwo.addActionListener((ActionEvent e) -> buttonPress(2));
    }

    private void buttonPress(int buttonNumber) {
        switch (rallyStatus) {
            case 0:
                score = (buttonNumber == 1) ? (score - 1) : (score + 1);
                optionOne.setText(TrumpWillTriumph.RESOURCE.getString("Rally.question_2_1"));
                optionTwo.setText(TrumpWillTriumph.RESOURCE.getString("Rally.question_2_2"));
                break;
            case 1:
                score = (buttonNumber == 1) ? (score - 1) : (score + 1);
                optionOne.setText(TrumpWillTriumph.RESOURCE.getString("Rally.question_3_1"));
                optionTwo.setText(TrumpWillTriumph.RESOURCE.getString("Rally.question_3_2"));
                break;
            case 2:
                score = (buttonNumber == 1) ? (score + 1) : (score + 2);
                optionOne.setText(TrumpWillTriumph.RESOURCE.getString("Rally.question_4_1"));
                optionTwo.setText(TrumpWillTriumph.RESOURCE.getString("Rally.question_4_2"));
                break;
            case 3:
                score = (buttonNumber == 1) ? (score + 1) : (score - 2);
                optionOne.setText(TrumpWillTriumph.RESOURCE.getString("Rally.question_5_1"));
                optionTwo.setText(TrumpWillTriumph.RESOURCE.getString("Rally.question_5_2"));
                break;
            case 4:
                score = (buttonNumber == 1) ? (score + 1) : (score - 1);
                frameState.setVisible(false);
                if (score >= 5) {
                    TrumpWillTriumph.win();
                } else {
                    TrumpWillTriumph.lose();
                }
                break;
        }
        rallyStatus++;
    }
}
