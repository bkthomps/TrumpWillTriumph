package callofdemocracy;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * The user is presented with a variety of techniques to torture an inmate. The user can quit at any time. If an inmate
 * dies or does not get tortured enough, the user loses. Else, the user wins.
 */
class AgencyCIA {

    private final JFrame frameState = new JFrame(CallOfDemocracy.GAME_TITLE);
    private final JLabel background = new JLabel(new ImageIcon("Assets/CIA.png"));
    private final JLabel healthLeft = new JLabel("Health Left: 100%");
    private final JButton breakArms = new JButton("Break Arms");
    private final JButton breakLegs = new JButton("Break Legs");
    private final JButton electrocute = new JButton("Electrocute");
    private final JButton pullToothOut = new JButton("Pull Tooth Out");
    private final JButton waterBoard = new JButton("WaterBoard");
    private final JButton stop = new JButton("Stop");

    private int damage;

    void agencyCIA() {
        doExposition();
        configureGUI();
        buttonAction();
    }

    private void doExposition() {
        CallOfDemocracy.displayExposition("Mr. Trump, Virginia is the home of the CIA,\nso naturally, we will "
                + "torture someone.");
    }

    private void configureGUI() {
        frameState.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameState.setResizable(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(breakArms);
        buttonPanel.add(breakLegs);
        buttonPanel.add(electrocute);
        buttonPanel.add(pullToothOut);
        buttonPanel.add(waterBoard);
        buttonPanel.add(stop);
        buttonPanel.setLayout(new GridLayout(2, 3));

        frameState.add(background, BorderLayout.NORTH);
        frameState.add(healthLeft, BorderLayout.CENTER);
        frameState.add(buttonPanel, BorderLayout.SOUTH);
        frameState.pack();
        frameState.setLocationRelativeTo(null);
        frameState.setIconImage(CallOfDemocracy.ICON_TRUMP.getImage());
        frameState.setVisible(true);
    }

    private void damageInmate() {
        damage++;
        if (damage < 10) {
            healthLeft.setText("Health Left: " + 10 * (10 - damage) + "%");
        } else {
            healthLeft.setText("Inmate Is Dead");
        }
    }

    private void buttonAction() {
        breakArms.addActionListener((ActionEvent e) -> damageInmate());
        breakLegs.addActionListener((ActionEvent e) -> damageInmate());
        electrocute.addActionListener((ActionEvent e) -> damageInmate());
        pullToothOut.addActionListener((ActionEvent e) -> damageInmate());
        waterBoard.addActionListener((ActionEvent e) -> damageInmate());
        stop.addActionListener((ActionEvent e) -> endGame());
    }

    private void endGame() {
        frameState.setVisible(false);
        if (damage < 5) {
            CallOfDemocracy.customText("Mr. Trump, you didn't damage the inmate enough, the inmate won't talk.");
            CallOfDemocracy.lose();
        } else if (damage >= 10) {
            CallOfDemocracy.customText("Mr. Trump, you killed the inmate!");
            CallOfDemocracy.lose();
        } else {
            CallOfDemocracy.customText("Mr. Trump, great job, we will make sure you win Virginia!");
            CallOfDemocracy.win();
        }
    }
}
