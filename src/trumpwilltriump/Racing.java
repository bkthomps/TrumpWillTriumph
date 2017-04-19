package trumpwilltriump;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * The user must use logic to determine which choice to bet on. If the user picked the best option, and is lucky, the
 * user wins. Else the user loses.
 */
class Racing {

    void racing() {
        doExposition();
        configureGUI();
    }

    private void doExposition() {
        String exposition = "ERROR";
        switch (TrumpWillTriump.touringState) {
            case NEUTRAL_MONTANA:
                exposition = "Mr. Trump, Montana loves horse racing, so to win their vote,\nbet on a horse. This will "
                        + "be during a four horse race.";
                break;
            case NEUTRAL_MISSISSIPPI:
                exposition = "Mr. Trump, Mississippi loves boat racing, so to win their vote,\nbet on a boat. This "
                        + "will be during a four boat race.";
                break;
            case NEUTRAL_INDIANA:
                exposition = "Mr. Trump, Indiana loves Formula 1, so to win their vote,\nbet on a car. This will be "
                        + "during a four car race.";
                break;
            case NEUTRAL_ALABAMA:
                exposition = "Mr. Trump, Alabama loves Nascar, so to win their vote,\nbet on a car. This will be "
                        + "during a four car race.";
                break;
        }
        TrumpWillTriump.displayExposition(exposition);
    }

    private void configureGUI() {
        JFrame frameState = new JFrame(TrumpWillTriump.GAME_TITLE);
        frameState.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameState.setResizable(false);

        JLabel info = new JLabel("Select What To Bet On - Success Chance");
        JButton horse87 = new JButton("Horse 87 - 12%");
        JButton horse17 = new JButton("Horse 17 - 9%");
        JButton horse65 = new JButton("Horse 65 - 7%");
        JButton horse37 = new JButton("Horse 37 - 72%");
        JButton boat12 = new JButton("Boat 12 - 64%");
        JButton boat16 = new JButton("Boat 16 - 3%");
        JButton boat56 = new JButton("Boat 56 - 23%");
        JButton boat37 = new JButton("Boat 37 - 10%");
        JButton car71 = new JButton("Car 71 - 21%");
        JButton car87 = new JButton("Car 87 - 56%");
        JButton car12 = new JButton("Car 12 - 8%");
        JButton car36 = new JButton("Car 36 - 15%");
        JButton car45 = new JButton("Car 45 - 18%");
        JButton car11 = new JButton("Car 11 - 14%");
        JButton car23 = new JButton("Car 23 - 62%");
        JButton car73 = new JButton("Car 73 - 6%");

        JPanel buttonPanel1 = new JPanel();
        JPanel buttonPanel2 = new JPanel();
        switch (TrumpWillTriump.touringState) {
            case NEUTRAL_MONTANA:
                buttonPanel1.add(horse87);
                buttonPanel1.add(horse17);
                buttonPanel2.add(horse65);
                buttonPanel2.add(horse37);
                break;
            case NEUTRAL_MISSISSIPPI:
                buttonPanel1.add(boat12);
                buttonPanel1.add(boat16);
                buttonPanel2.add(boat56);
                buttonPanel2.add(boat37);
                break;
            case NEUTRAL_INDIANA:
                buttonPanel1.add(car45);
                buttonPanel1.add(car11);
                buttonPanel2.add(car23);
                buttonPanel2.add(car73);
                break;
            case NEUTRAL_ALABAMA:
                buttonPanel1.add(car71);
                buttonPanel1.add(car87);
                buttonPanel2.add(car12);
                buttonPanel2.add(car36);
                break;
        }

        frameState.add(info, BorderLayout.NORTH);
        frameState.add(buttonPanel1, BorderLayout.CENTER);
        frameState.add(buttonPanel2, BorderLayout.SOUTH);
        frameState.pack();
        frameState.setLocationRelativeTo(null);
        frameState.setIconImage(TrumpWillTriump.ICON_TRUMP.getImage());
        frameState.setVisible(true);

        horse87.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if ((int) (Math.random() * 8.33) == 0) {
                TrumpWillTriump.win();
            } else {
                TrumpWillTriump.lose();
            }
        });
        horse17.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if ((int) (Math.random() * 11.11) == 0) {
                TrumpWillTriump.win();
            } else {
                TrumpWillTriump.lose();
            }
        });
        horse65.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if ((int) (Math.random() * 14.29) == 0) {
                TrumpWillTriump.win();
            } else {
                TrumpWillTriump.lose();
            }
        });
        horse37.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if ((int) (Math.random() * 1.39) == 0) {
                TrumpWillTriump.win();
            } else {
                TrumpWillTriump.lose();
            }
        });
        boat12.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if ((int) (Math.random() * 1.56) == 0) {
                TrumpWillTriump.win();
            } else {
                TrumpWillTriump.lose();
            }
        });
        boat16.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if ((int) (Math.random() * 33.33) == 0) {
                TrumpWillTriump.win();
            } else {
                TrumpWillTriump.lose();
            }
        });
        boat56.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if ((int) (Math.random() * 4.35) == 0) {
                TrumpWillTriump.win();
            } else {
                TrumpWillTriump.lose();
            }
        });
        boat37.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if ((int) (Math.random() * 10) == 0) {
                TrumpWillTriump.win();
            } else {
                TrumpWillTriump.lose();
            }
        });
        car45.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if ((int) (Math.random() * 5.56) == 0) {
                TrumpWillTriump.win();
            } else {
                TrumpWillTriump.lose();
            }
        });
        car11.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if ((int) (Math.random() * 7.14) == 0) {
                TrumpWillTriump.win();
            } else {
                TrumpWillTriump.lose();
            }
        });
        car23.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if ((int) (Math.random() * 1.61) == 0) {
                TrumpWillTriump.win();
            } else {
                TrumpWillTriump.lose();
            }
        });
        car73.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if ((int) (Math.random() * 16.67) == 0) {
                TrumpWillTriump.win();
            } else {
                TrumpWillTriump.lose();
            }
        });
        car71.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if ((int) (Math.random() * 4.76) == 0) {
                TrumpWillTriump.win();
            } else {
                TrumpWillTriump.lose();
            }
        });
        car87.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if ((int) (Math.random() * 1.79) == 0) {
                TrumpWillTriump.win();
            } else {
                TrumpWillTriump.lose();
            }
        });
        car12.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if ((int) (Math.random() * 12.5) == 0) {
                TrumpWillTriump.win();
            } else {
                TrumpWillTriump.lose();
            }
        });
        car36.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if ((int) (Math.random() * 6.67) == 0) {
                TrumpWillTriump.win();
            } else {
                TrumpWillTriump.lose();
            }
        });
    }
}
