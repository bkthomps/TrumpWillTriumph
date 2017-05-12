package callofdemocracy;

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

    private final JFrame frameState = new JFrame(CallOfDemocracy.GAME_TITLE);
    private final JLabel background = new JLabel(new ImageIcon("Assets/IowaBackground.png"));
    private final JButton optionOne = new JButton("How stupid are the people of Iowa");
    private final JButton optionTwo = new JButton("I love the people of Iowa");

    private int score, rallyStatus;

    void rally() {
        configureGUI();
        userClicksButtonOne();
        userClicksButtonTwo();
    }

    private void configureGUI() {
        CallOfDemocracy.hideMap();
        frameState.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameState.setResizable(false);
        frameState.add(background, BorderLayout.NORTH);
        frameState.add(optionOne, BorderLayout.CENTER);
        frameState.add(optionTwo, BorderLayout.SOUTH);
        frameState.setSize(348, 310);
        frameState.setLocationRelativeTo(null);
        frameState.setIconImage(CallOfDemocracy.ICON_TRUMP.getImage());
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
                optionOne.setText("How stupid are the American people");
                optionTwo.setText("I love America");
                break;
            case 1:
                score = (buttonNumber == 1) ? (score - 1) : (score + 1);
                optionOne.setText("I will build a wall");
                optionTwo.setText("I will make America great again");
                break;
            case 2:
                score = (buttonNumber == 1) ? (score + 1) : (score + 2);
                optionOne.setText("Hillary Clinton was the worst secretary of state");
                optionTwo.setText("Hillary Clinton is a great person");
                break;
            case 3:
                score = (buttonNumber == 1) ? (score + 1) : (score - 2);
                optionOne.setText("Mexican are bringing drugs and crime");
                optionTwo.setText("Some Mexicans are good people");
                break;
            case 4:
                score = (buttonNumber == 1) ? (score + 1) : (score - 1);
                frameState.setVisible(false);
                if (score >= 5) {
                    CallOfDemocracy.win();
                } else {
                    CallOfDemocracy.lose();
                }
                break;
        }
        rallyStatus++;
    }
}
