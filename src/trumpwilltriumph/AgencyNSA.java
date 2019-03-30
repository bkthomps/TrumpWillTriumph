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
    private final JButton mexicans = new JButton("Mexicans");
    private final JButton asians = new JButton("Asians");
    private final JButton africanAmericans = new JButton("African-Americans");
    private final JButton caucasians = new JButton("Caucasians");
    private final JButton africans = new JButton("Africans");
    private final JButton europeans = new JButton("Europeans");

    void agencyNSA() {
        doExposition();
        configureGUI();
        buttonAction();
    }

    private void doExposition() {
        TrumpWillTriumph.displayExposition("Mr. Trump, as you might know, Maryland is home of the NSA. So, let's\nspy "
                + "on some people. Please pick which ethnic group to spy on.");
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
        TrumpWillTriumph.customText("No progress was achieved what so ever, but for\nsome reason, people are content on "
                + "your decision.");
        TrumpWillTriumph.win();
    }

    private void losingChoice() {
        frameState.setVisible(false);
        TrumpWillTriumph.customText("No progress was achieved what so ever, and for some reason,\nnot many people care "
                + "that you are infringing on their privacy.\nAs Maryland is a blue state anyways, they have not voted "
                + "for you.");
        TrumpWillTriumph.lose();
    }
}
