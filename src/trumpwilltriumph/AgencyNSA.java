package trumpwilltriumph;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * The user is presented with a variety of racial groups that can be spied on. If the user picks to spy on the Mexicans,
 * the user wins. Else, the user loses.
 */
class AgencyNSA {

    private final JFrame frameState = new JFrame(TrumpWillTriumph.GAME_TITLE);
    private final JLabel background = new JLabel(new ImageIcon("Assets/NSA.png"));
    private final JButton mexicans = new JButton(TrumpWillTriumph.RESOURCE.getString("AgencyNSA.mexicans"));
    private final JButton asians = new JButton(TrumpWillTriumph.RESOURCE.getString("AgencyNSA.asians"));
    private final JButton africanAmericans
            = new JButton(TrumpWillTriumph.RESOURCE.getString("AgencyNSA.africanAmericans"));
    private final JButton caucasians = new JButton(TrumpWillTriumph.RESOURCE.getString("AgencyNSA.caucasians"));
    private final JButton africans = new JButton(TrumpWillTriumph.RESOURCE.getString("AgencyNSA.africans"));
    private final JButton europeans = new JButton(TrumpWillTriumph.RESOURCE.getString("AgencyNSA.europeans"));

    void agencyNSA() {
        doExposition();
        configureGUI();
        buttonAction();
    }

    private void doExposition() {
        TrumpWillTriumph.expositionDialog("AgencyNSA.exposition_1", "AgencyNSA.exposition_2");
    }

    private void configureGUI() {
        frameState.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameState.setResizable(false);

        JPanel topButtonPanel = new JPanel();
        JPanel bottomButtonPanel = new JPanel();

        topButtonPanel.add(mexicans);
        topButtonPanel.add(asians);
        topButtonPanel.add(africanAmericans);
        bottomButtonPanel.add(caucasians);
        bottomButtonPanel.add(africans);
        bottomButtonPanel.add(europeans);

        frameState.add(background, BorderLayout.NORTH);
        frameState.add(topButtonPanel, BorderLayout.CENTER);
        frameState.add(bottomButtonPanel, BorderLayout.SOUTH);
        frameState.setSize(353, 367);
        frameState.setLocationRelativeTo(null);
        frameState.setIconImage(TrumpWillTriumph.ICON_TRUMP.getImage());
        frameState.setVisible(true);
    }

    private void buttonAction() {
        mexicans.addActionListener((ActionEvent e) -> winningChoice());
        asians.addActionListener((ActionEvent e) -> losingChoice());
        africanAmericans.addActionListener((ActionEvent e) -> losingChoice());
        caucasians.addActionListener((ActionEvent e) -> losingChoice());
        africans.addActionListener((ActionEvent e) -> losingChoice());
        europeans.addActionListener((ActionEvent e) -> losingChoice());
    }

    private void winningChoice() {
        frameState.setVisible(false);
        TrumpWillTriumph.customDialog("AgencyNSA.winning_1", "AgencyNSA.winning_2");
        TrumpWillTriumph.win();
    }

    private void losingChoice() {
        frameState.setVisible(false);
        TrumpWillTriumph.customDialog("AgencyNSA.losing_1", "AgencyNSA.losing_2", "AgencyNSA.losing_3");
        TrumpWillTriumph.lose();
    }
}
