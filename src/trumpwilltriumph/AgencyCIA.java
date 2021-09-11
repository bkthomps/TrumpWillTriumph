package trumpwilltriumph;

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

    private final JFrame frameState = new JFrame(TrumpWillTriumph.GAME_TITLE);
    private final JLabel background = new JLabel(new ImageIcon("Assets/CIA.png"));
    private final JLabel healthLeft = new JLabel(TrumpWillTriumph.RESOURCE.getString("AgencyCIA.healthLeft")
            + " 100" + TrumpWillTriumph.RESOURCE.getString("AgencyCIA.percentSign"));
    private final JButton breakArms = new JButton(TrumpWillTriumph.RESOURCE.getString("AgencyCIA.breakArms"));
    private final JButton breakLegs = new JButton(TrumpWillTriumph.RESOURCE.getString("AgencyCIA.breakLegs"));
    private final JButton electrocute = new JButton(TrumpWillTriumph.RESOURCE.getString("AgencyCIA.electrocute"));
    private final JButton pullToothOut = new JButton(TrumpWillTriumph.RESOURCE.getString("AgencyCIA.extractTooth"));
    private final JButton waterBoard = new JButton(TrumpWillTriumph.RESOURCE.getString("AgencyCIA.waterboard"));
    private final JButton stop = new JButton(TrumpWillTriumph.RESOURCE.getString("AgencyCIA.stop"));

    private int damage;

    void agencyCIA() {
        doExposition();
        configureGUI();
        buttonAction();
    }

    private void doExposition() {
        TrumpWillTriumph.expositionDialog("AgencyCIA.exposition_1", "AgencyCIA.exposition_2");
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
        frameState.setIconImage(TrumpWillTriumph.ICON_TRUMP.getImage());
        frameState.setVisible(true);
    }

    private void damageInmate() {
        damage++;
        if (damage < 10) {
            healthLeft.setText(TrumpWillTriumph.RESOURCE.getString("AgencyCIA.healthLeft") + " " + 10 * (10 - damage)
                    + TrumpWillTriumph.RESOURCE.getString("AgencyCIA.percentSign"));
        } else {
            healthLeft.setText(TrumpWillTriumph.RESOURCE.getString("AgencyCIA.inmateDied"));
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
            TrumpWillTriumph.customDialog("AgencyCIA.inmateWontTalk");
            TrumpWillTriumph.lose();
        } else if (damage >= 10) {
            TrumpWillTriumph.customDialog("AgencyCIA.killedInmate");
            TrumpWillTriumph.lose();
        } else {
            TrumpWillTriumph.customDialog("AgencyCIA.wonVirginia");
            TrumpWillTriumph.win();
        }
    }
}
