package trumpwilltriumph;

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
        switch (TrumpWillTriumph.touringState) {
            case NEUTRAL_MONTANA:
                TrumpWillTriumph.expositionDialog("Racing.exposition_montana_1", "Racing.exposition_montana_2");
                break;
            case NEUTRAL_MISSISSIPPI:
                TrumpWillTriumph.expositionDialog("Racing.exposition_mississippi_1", "Racing.exposition_mississippi_2");
                break;
            case NEUTRAL_INDIANA:
                TrumpWillTriumph.expositionDialog("Racing.exposition_indiana_1", "Racing.exposition_indiana_2");
                break;
            case NEUTRAL_ALABAMA:
                TrumpWillTriumph.expositionDialog("Racing.exposition_alabama_1", "Racing.exposition_alabama_2");
                break;
        }
    }

    private void configureGUI() {
        JFrame frameState = new JFrame(TrumpWillTriumph.GAME_TITLE);
        frameState.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameState.setResizable(false);

        JLabel info = new JLabel(TrumpWillTriumph.RESOURCE.getString("Racing.header"));
        JButton horse87 = new JButton(TrumpWillTriumph.RESOURCE.getString("Racing.horse_87"));
        JButton horse17 = new JButton(TrumpWillTriumph.RESOURCE.getString("Racing.horse_17"));
        JButton horse65 = new JButton(TrumpWillTriumph.RESOURCE.getString("Racing.horse_65"));
        JButton horse37 = new JButton(TrumpWillTriumph.RESOURCE.getString("Racing.horse_37"));
        JButton boat12 = new JButton(TrumpWillTriumph.RESOURCE.getString("Racing.boat_12"));
        JButton boat16 = new JButton(TrumpWillTriumph.RESOURCE.getString("Racing.boat_16"));
        JButton boat56 = new JButton(TrumpWillTriumph.RESOURCE.getString("Racing.boat_56"));
        JButton boat37 = new JButton(TrumpWillTriumph.RESOURCE.getString("Racing.boat_37"));
        JButton car71 = new JButton(TrumpWillTriumph.RESOURCE.getString("Racing.car_71"));
        JButton car87 = new JButton(TrumpWillTriumph.RESOURCE.getString("Racing.car_87"));
        JButton car12 = new JButton(TrumpWillTriumph.RESOURCE.getString("Racing.car_12"));
        JButton car36 = new JButton(TrumpWillTriumph.RESOURCE.getString("Racing.car_36"));
        JButton car45 = new JButton(TrumpWillTriumph.RESOURCE.getString("Racing.car_45"));
        JButton car11 = new JButton(TrumpWillTriumph.RESOURCE.getString("Racing.car_11"));
        JButton car23 = new JButton(TrumpWillTriumph.RESOURCE.getString("Racing.car_23"));
        JButton car73 = new JButton(TrumpWillTriumph.RESOURCE.getString("Racing.car_73"));

        JPanel buttonPanel1 = new JPanel();
        JPanel buttonPanel2 = new JPanel();
        switch (TrumpWillTriumph.touringState) {
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
        frameState.setIconImage(TrumpWillTriumph.ICON_TRUMP.getImage());
        frameState.setVisible(true);

        horse87.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if ((int) (Math.random() * 8.33) == 0) {
                TrumpWillTriumph.win();
            } else {
                TrumpWillTriumph.lose();
            }
        });
        horse17.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if ((int) (Math.random() * 11.11) == 0) {
                TrumpWillTriumph.win();
            } else {
                TrumpWillTriumph.lose();
            }
        });
        horse65.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if ((int) (Math.random() * 14.29) == 0) {
                TrumpWillTriumph.win();
            } else {
                TrumpWillTriumph.lose();
            }
        });
        horse37.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if ((int) (Math.random() * 1.39) == 0) {
                TrumpWillTriumph.win();
            } else {
                TrumpWillTriumph.lose();
            }
        });
        boat12.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if ((int) (Math.random() * 1.56) == 0) {
                TrumpWillTriumph.win();
            } else {
                TrumpWillTriumph.lose();
            }
        });
        boat16.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if ((int) (Math.random() * 33.33) == 0) {
                TrumpWillTriumph.win();
            } else {
                TrumpWillTriumph.lose();
            }
        });
        boat56.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if ((int) (Math.random() * 4.35) == 0) {
                TrumpWillTriumph.win();
            } else {
                TrumpWillTriumph.lose();
            }
        });
        boat37.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if ((int) (Math.random() * 10) == 0) {
                TrumpWillTriumph.win();
            } else {
                TrumpWillTriumph.lose();
            }
        });
        car45.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if ((int) (Math.random() * 5.56) == 0) {
                TrumpWillTriumph.win();
            } else {
                TrumpWillTriumph.lose();
            }
        });
        car11.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if ((int) (Math.random() * 7.14) == 0) {
                TrumpWillTriumph.win();
            } else {
                TrumpWillTriumph.lose();
            }
        });
        car23.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if ((int) (Math.random() * 1.61) == 0) {
                TrumpWillTriumph.win();
            } else {
                TrumpWillTriumph.lose();
            }
        });
        car73.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if ((int) (Math.random() * 16.67) == 0) {
                TrumpWillTriumph.win();
            } else {
                TrumpWillTriumph.lose();
            }
        });
        car71.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if ((int) (Math.random() * 4.76) == 0) {
                TrumpWillTriumph.win();
            } else {
                TrumpWillTriumph.lose();
            }
        });
        car87.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if ((int) (Math.random() * 1.79) == 0) {
                TrumpWillTriumph.win();
            } else {
                TrumpWillTriumph.lose();
            }
        });
        car12.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if ((int) (Math.random() * 12.5) == 0) {
                TrumpWillTriumph.win();
            } else {
                TrumpWillTriumph.lose();
            }
        });
        car36.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if ((int) (Math.random() * 6.67) == 0) {
                TrumpWillTriumph.win();
            } else {
                TrumpWillTriumph.lose();
            }
        });
    }
}
