package trumpwilltriumph;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * The user must answer five questions in each of the four categories. If the user gets enough points, the user wins.
 * Else, the user loses. Each question that the user answers is picked from a pool of five possible questions, meaning
 * that if the user plays the game multiple times, most of the questions will be different on each play through.
 */
class Jeopardy {

    private final JFrame mainFrame = new JFrame(TrumpWillTriumph.GAME_TITLE);
    private final JPanel pointCategory100 = new JPanel();
    private final JPanel pointCategory200 = new JPanel();
    private final JPanel pointCategory300 = new JPanel();
    private final JPanel pointCategory400 = new JPanel();
    private final JPanel pointCategory500 = new JPanel();
    private final JLabel responseScore = new JLabel(TrumpWillTriumph.RESOURCE.getString("Jeopardy.score")
            + " 0 " + TrumpWillTriumph.RESOURCE.getString("Jeopardy.points"), JLabel.CENTER);
    private final JLabel responseAnswer = new JLabel("", JLabel.CENTER);

    private int score, click;

    void jeopardyPrepareGUI() {
        TrumpWillTriumph.expositionDialog("Jeopardy.exposition_1", "Jeopardy.exposition_2");

        mainFrame.setSize(300, 400);
        mainFrame.setLayout(new GridLayout(9, 1));
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setIconImage(TrumpWillTriumph.ICON_TRUMP.getImage());
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);

        final JLabel headerLabel = new JLabel(TrumpWillTriumph.RESOURCE.getString("Jeopardy.title"), JLabel.CENTER);
        final JLabel subHeaderLabel = new JLabel(TrumpWillTriumph.RESOURCE.getString("Jeopardy.header"), JLabel.CENTER);

        pointCategory100.setLayout(new FlowLayout());
        pointCategory200.setLayout(new FlowLayout());
        pointCategory300.setLayout(new FlowLayout());
        pointCategory400.setLayout(new FlowLayout());
        pointCategory500.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(subHeaderLabel);
        mainFrame.add(pointCategory100);
        mainFrame.add(pointCategory200);
        mainFrame.add(pointCategory300);
        mainFrame.add(pointCategory400);
        mainFrame.add(pointCategory500);
        mainFrame.add(responseScore);
        mainFrame.add(responseAnswer);

        settingButtons();
    }

    private void settingButtons() {
        JButton science100 = new JButton("100");
        JButton science200 = new JButton("200");
        JButton science300 = new JButton("300");
        JButton science400 = new JButton("400");
        JButton science500 = new JButton("500");
        JButton math100 = new JButton("100");
        JButton math200 = new JButton("200");
        JButton math300 = new JButton("300");
        JButton math400 = new JButton("400");
        JButton math500 = new JButton("500");
        JButton history100 = new JButton("100");
        JButton history200 = new JButton("200");
        JButton history300 = new JButton("300");
        JButton history400 = new JButton("400");
        JButton history500 = new JButton("500");
        JButton games100 = new JButton("100");
        JButton games200 = new JButton("200");
        JButton games300 = new JButton("300");
        JButton games400 = new JButton("400");
        JButton games500 = new JButton("500");
        JButton[] blank = new JButton[20];
        for (int blankCounter = 0; blankCounter < blank.length; blankCounter++) {
            blank[blankCounter] = new JButton("       ");
            blank[blankCounter].setVisible(false);
        }

        final int width = 5 * (int) science100.getPreferredSize().getWidth();
        mainFrame.setSize(width, 400);

        science100.addActionListener((ActionEvent e) -> {
            science100.setVisible(false);
            blank[0].setVisible(true);
            question("science", 100);
            caseWin();
        });

        science200.addActionListener((ActionEvent e) -> {
            science200.setVisible(false);
            blank[1].setVisible(true);
            question("science", 200);
            caseWin();
        });

        science300.addActionListener((ActionEvent e) -> {
            science300.setVisible(false);
            blank[2].setVisible(true);
            question("science", 300);
            caseWin();
        });

        science400.addActionListener((ActionEvent e) -> {
            science400.setVisible(false);
            blank[3].setVisible(true);
            question("science", 400);
            caseWin();
        });

        science500.addActionListener((ActionEvent e) -> {
            science500.setVisible(false);
            blank[4].setVisible(true);
            question("science", 500);
            caseWin();
        });

        math100.addActionListener((ActionEvent e) -> {
            math100.setVisible(false);
            blank[5].setVisible(true);
            question("math", 100);
            caseWin();
        });

        math200.addActionListener((ActionEvent e) -> {
            math200.setVisible(false);
            blank[6].setVisible(true);
            question("math", 200);
            caseWin();
        });

        math300.addActionListener((ActionEvent e) -> {
            math300.setVisible(false);
            blank[7].setVisible(true);
            question("math", 300);
            caseWin();
        });

        math400.addActionListener((ActionEvent e) -> {
            math400.setVisible(false);
            blank[8].setVisible(true);
            question("math", 400);
            caseWin();
        });

        math500.addActionListener((ActionEvent e) -> {
            math500.setVisible(false);
            blank[9].setVisible(true);
            question("math", 500);
            caseWin();
        });

        history100.addActionListener((ActionEvent e) -> {
            history100.setVisible(false);
            blank[10].setVisible(true);
            question("history", 100);
            caseWin();
        });

        history200.addActionListener((ActionEvent e) -> {
            history200.setVisible(false);
            blank[11].setVisible(true);
            question("history", 200);
            caseWin();
        });

        history300.addActionListener((ActionEvent e) -> {
            history300.setVisible(false);
            blank[12].setVisible(true);
            question("history", 300);
            caseWin();
        });

        history400.addActionListener((ActionEvent e) -> {
            history400.setVisible(false);
            blank[13].setVisible(true);
            question("history", 400);
            caseWin();
        });

        history500.addActionListener((ActionEvent e) -> {
            history500.setVisible(false);
            blank[14].setVisible(true);
            question("history", 500);
            caseWin();
        });

        games100.addActionListener((ActionEvent e) -> {
            games100.setVisible(false);
            blank[15].setVisible(true);
            question("games", 100);
            caseWin();
        });

        games200.addActionListener((ActionEvent e) -> {
            games200.setVisible(false);
            blank[16].setVisible(true);
            question("games", 200);
            caseWin();
        });

        games300.addActionListener((ActionEvent e) -> {
            games300.setVisible(false);
            blank[17].setVisible(true);
            question("games", 300);
            caseWin();
        });

        games400.addActionListener((ActionEvent e) -> {
            games400.setVisible(false);
            blank[18].setVisible(true);
            question("games", 400);
            caseWin();
        });

        games500.addActionListener((ActionEvent e) -> {
            games500.setVisible(false);
            blank[19].setVisible(true);
            question("games", 500);
            caseWin();
        });

        pointCategory100.add(science100);
        pointCategory100.add(blank[0]);
        pointCategory100.add(math100);
        pointCategory100.add(blank[5]);
        pointCategory100.add(history100);
        pointCategory100.add(blank[10]);
        pointCategory100.add(games100);
        pointCategory100.add(blank[15]);
        pointCategory200.add(science200);
        pointCategory200.add(blank[1]);
        pointCategory200.add(math200);
        pointCategory200.add(blank[6]);
        pointCategory200.add(history200);
        pointCategory200.add(blank[11]);
        pointCategory200.add(games200);
        pointCategory200.add(blank[16]);
        pointCategory300.add(science300);
        pointCategory300.add(blank[2]);
        pointCategory300.add(math300);
        pointCategory300.add(blank[7]);
        pointCategory300.add(history300);
        pointCategory300.add(blank[12]);
        pointCategory300.add(games300);
        pointCategory300.add(blank[17]);
        pointCategory400.add(science400);
        pointCategory400.add(blank[3]);
        pointCategory400.add(math400);
        pointCategory400.add(blank[8]);
        pointCategory400.add(history400);
        pointCategory400.add(blank[13]);
        pointCategory400.add(games400);
        pointCategory400.add(blank[18]);
        pointCategory500.add(science500);
        pointCategory500.add(blank[4]);
        pointCategory500.add(math500);
        pointCategory500.add(blank[9]);
        pointCategory500.add(history500);
        pointCategory500.add(blank[14]);
        pointCategory500.add(games500);
        pointCategory500.add(blank[19]);

        mainFrame.setVisible(true);
    }

    private void caseWin() {
        if (click == 20) {
            mainFrame.setVisible(false);
            if (score >= 1000) {
                TrumpWillTriumph.win();
            } else {
                TrumpWillTriumph.lose();
            }
        }
    }

    private void question(String category, int points) {
        final String prefix = "Jeopardy.";
        final int num = randomNumber();
        operateUserInput(prefix + category + "_" + points + "_question_" + num,
                prefix + category + "_" + points + "_regex_" + num,
                prefix + category + "_" + points + "_answer_" + num, points);
    }

    private int randomNumber() {
        final int ret = (int) (Math.random() * 5) + 1;
        if (ret < 1 || ret > 5) {
            System.err.println(TrumpWillTriumph.RESOURCE.getString("Jeopardy.error_number"));
            return 1;
        }
        return ret;
    }

    private void operateUserInput(String question, String answer, String sampleAnswer, int scoreAdd) {
        question = TrumpWillTriumph.RESOURCE.getString(question);
        answer = TrumpWillTriumph.RESOURCE.getString(answer);
        sampleAnswer = TrumpWillTriumph.RESOURCE.getString(sampleAnswer);
        String userAnswer = JOptionPane.showInputDialog(null, question, TrumpWillTriumph.GAME_TITLE,
                JOptionPane.PLAIN_MESSAGE);
        if (userAnswer == null) {
            userAnswer = "";
        }
        if (click < 20) {
            click++;
        }
        userAnswer = userAnswer.toLowerCase();
        userAnswer = userAnswer.replaceAll("[ .,;:!?]", "");
        if (userAnswer.matches(answer)) {
            score += scoreAdd;
            responseScore.setText(TrumpWillTriumph.RESOURCE.getString("Jeopardy.score") + " " + score + " "
                    + TrumpWillTriumph.RESOURCE.getString("Jeopardy.points"));
            responseAnswer.setText(TrumpWillTriumph.RESOURCE.getString("Jeopardy.correct") + " +" + scoreAdd + " "
                    + TrumpWillTriumph.RESOURCE.getString("Jeopardy.points"));
        } else {
            responseAnswer.setText(TrumpWillTriumph.RESOURCE.getString("Jeopardy.incorrect") + " " + sampleAnswer);
        }
    }
}
