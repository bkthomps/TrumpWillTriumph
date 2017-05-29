package callofdemocracy;

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

    private final JFrame mainFrame = new JFrame(CallOfDemocracy.GAME_TITLE);
    private final JPanel pointCategory100 = new JPanel();
    private final JPanel pointCategory200 = new JPanel();
    private final JPanel pointCategory300 = new JPanel();
    private final JPanel pointCategory400 = new JPanel();
    private final JPanel pointCategory500 = new JPanel();
    private final JLabel responseScore = new JLabel("Total score: 0 points", JLabel.CENTER);
    private final JLabel responseAnswer = new JLabel("", JLabel.CENTER);

    private int score, click;

    void jeopardyPrepareGUI() {
        final String exposition = "Mr. Trump, we have a Jeopardy game prepared for you to test you.\nYou need at least "
                + "1000 points to win the state.";
        CallOfDemocracy.displayExposition(exposition);

        mainFrame.setSize(300, 400);
        mainFrame.setLayout(new GridLayout(9, 1));
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setIconImage(CallOfDemocracy.ICON_TRUMP.getImage());
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);

        final JLabel headerLabel = new JLabel("Jeopardy", JLabel.CENTER);
        final JLabel subHeaderLabel = new JLabel("Science       Math       History       Games", JLabel.CENTER);

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
        JButton blank[] = new JButton[20];
        for (int blankCounter = 0; blankCounter < blank.length; blankCounter++) {
            blank[blankCounter] = new JButton("       ");
            blank[blankCounter].setVisible(false);
        }

        final int width = 5 * (int) science100.getPreferredSize().getWidth();
        mainFrame.setSize(width, 400);

        science100.addActionListener((ActionEvent e) -> {
            science100.setVisible(false);
            blank[0].setVisible(true);
            science100();
            caseWin();
        });

        science200.addActionListener((ActionEvent e) -> {
            science200.setVisible(false);
            blank[1].setVisible(true);
            science200();
            caseWin();
        });

        science300.addActionListener((ActionEvent e) -> {
            science300.setVisible(false);
            blank[2].setVisible(true);
            science300();
            caseWin();
        });

        science400.addActionListener((ActionEvent e) -> {
            science400.setVisible(false);
            blank[3].setVisible(true);
            science400();
            caseWin();
        });

        science500.addActionListener((ActionEvent e) -> {
            science500.setVisible(false);
            blank[4].setVisible(true);
            science500();
            caseWin();
        });

        math100.addActionListener((ActionEvent e) -> {
            math100.setVisible(false);
            blank[5].setVisible(true);
            math100();
            caseWin();
        });

        math200.addActionListener((ActionEvent e) -> {
            math200.setVisible(false);
            blank[6].setVisible(true);
            math200();
            caseWin();
        });

        math300.addActionListener((ActionEvent e) -> {
            math300.setVisible(false);
            blank[7].setVisible(true);
            math300();
            caseWin();
        });

        math400.addActionListener((ActionEvent e) -> {
            math400.setVisible(false);
            blank[8].setVisible(true);
            math400();
            caseWin();
        });

        math500.addActionListener((ActionEvent e) -> {
            math500.setVisible(false);
            blank[9].setVisible(true);
            math500();
            caseWin();
        });

        history100.addActionListener((ActionEvent e) -> {
            history100.setVisible(false);
            blank[10].setVisible(true);
            history100();
            caseWin();
        });

        history200.addActionListener((ActionEvent e) -> {
            history200.setVisible(false);
            blank[11].setVisible(true);
            history200();
            caseWin();
        });

        history300.addActionListener((ActionEvent e) -> {
            history300.setVisible(false);
            blank[12].setVisible(true);
            history300();
            caseWin();
        });

        history400.addActionListener((ActionEvent e) -> {
            history400.setVisible(false);
            blank[13].setVisible(true);
            history400();
            caseWin();
        });

        history500.addActionListener((ActionEvent e) -> {
            history500.setVisible(false);
            blank[14].setVisible(true);
            history500();
            caseWin();
        });

        games100.addActionListener((ActionEvent e) -> {
            games100.setVisible(false);
            blank[15].setVisible(true);
            games100();
            caseWin();
        });

        games200.addActionListener((ActionEvent e) -> {
            games200.setVisible(false);
            blank[16].setVisible(true);
            games200();
            caseWin();
        });

        games300.addActionListener((ActionEvent e) -> {
            games300.setVisible(false);
            blank[17].setVisible(true);
            games300();
            caseWin();
        });

        games400.addActionListener((ActionEvent e) -> {
            games400.setVisible(false);
            blank[18].setVisible(true);
            games400();
            caseWin();
        });

        games500.addActionListener((ActionEvent e) -> {
            games500.setVisible(false);
            blank[19].setVisible(true);
            games500();
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
                CallOfDemocracy.win();
            } else {
                CallOfDemocracy.lose();
            }
        }
    }

    private void science100() {
        switch (randomNumber()) {
            case 1:
                operateUserInput("The powerhouse of the cell is?", "(the)?mitochondri(a|on)", "The Mitochondrion", 100);
                break;
            case 2:
                operateUserInput("The controller of the cell is?", "(the)?nucleus", "The Nucleus", 100);
                break;
            case 3:
                operateUserInput("The outer part of the animal cell is?", "(the)?(cellular|cell|plasma)?membrane",
                        "The Cellular Membrane", 100);
                break;
            case 4:
                operateUserInput("The outer part of the plant cell is?", "(the)?(cell|cellular)?wall", "The Cell Wall",
                        100);
                break;
            case 5:
                operateUserInput("Information carrying substances with double helix structure is called?",
                        "(dna|deoxyribosenucleicacid)", "Deoxyribose Nucleic Acid", 100);
                break;
        }
    }

    private void science200() {
        switch (randomNumber()) {
            case 1:
                operateUserInput("Who is the father of the theory of evolution?", "(charlesdarwin|charles|darwin)",
                        "Charles Darwin", 200);
                break;
            case 2:
                operateUserInput("Who is the father of the theory of relativity?", "(alberteinstein|albert|einstein)",
                        "Albert Einstein", 200);
                break;
            case 3:
                operateUserInput("Who is the person in which the fundamental particle associated with mass was named "
                        + "after?", "(peterhiggs|peter|higgs)", "Peter Higgs", 200);
                break;
            case 4:
                operateUserInput("What is the name of the person that hypothesized three laws of motion?",
                        "(sir)?(isaacnewton|isaac|newton)", "Sir Isaac Newton", 200);
                break;
            case 5:
                operateUserInput("Who patented the light bulb?", "(thomasedison|thomas|edison)", "Thomas Edison", 200);
                break;
        }
    }

    private void science300() {
        switch (randomNumber()) {
            case 1:
                operateUserInput("A unit of magnitude and direction is a?", "(a)?vector", "Vector", 300);
                break;
            case 2:
                operateUserInput("A unit of magnitude is a?", "(a)?scalar", "Scalar", 300);
                break;
            case 3:
                operateUserInput("The SI unit of force is measured in?", "(n|(newton(s)?))", "Newtons", 300);
                break;
            case 4:
                operateUserInput("A newton metre is a?", "(j|((a)?joule))", "Joule", 300);
                break;
            case 5:
                operateUserInput("The SI base unit of mass is the?", "(kg|(kilogram(s)?))", "Kilogram", 300);
                break;
        }
    }

    private void science400() {
        switch (randomNumber()) {
            case 1:
                operateUserInput("The current model of the atom is the?", "(the)?quantum(model)?", "The Quantum Model",
                        400);
                break;
            case 2:
                operateUserInput("What is the family name of group 18 on the periodic table?", "noblegas((s)?es)?",
                        "Noble Gasses", 400);
                break;
            case 3:
                operateUserInput("What is the family name of group 17 on the periodic table?", "halogen(s)?",
                        "Halogens", 400);
                break;
            case 4:
                operateUserInput("What is the family name of group 2 on the periodic table?", "alkalineearthmetal(s)?",
                        "Alkaline Earth Metals", 400);
                break;
            case 5:
                operateUserInput("What is the family name of group 1 on the periodic table?", "alkalimetal(s)?",
                        "Alkali Metals", 400);
                break;
        }
    }

    private void science500() {
        switch (randomNumber()) {
            case 1:
                operateUserInput("How much more energy does a Calorie have compared to a calorie as a ratio?",
                        "(1000|((a|one)?thousand))", "1000", 500);
                break;
            case 2:
                operateUserInput("As an integer value, how many joules are there per kilocalorie?",
                        "(4184|4180|4190|4200)", "4184", 500);
                break;
            case 3:
                operateUserInput("What colour has the most energy on the standard visible light spectrum?", "violet",
                        "Violet", 500);
                break;
            case 4:
                operateUserInput("What type of wave is a sound wave?", "(a)?mechanical(wave)?", "A Mechanical Wave",
                        500);
                break;
            case 5:
                operateUserInput("To no decimal places, how many light-years are in 100 parsecs?", "(326|330|320|300)",
                        "326", 500);
                break;
        }
    }

    private void math100() {
        switch (randomNumber()) {
            case 1:
                operateUserInput("What is (5 + 12 - 2 * 9) / (1 / 2)", "\\-2", "-2", 100);
                break;
            case 2:
                operateUserInput("What is (7 + 3 - 3 * 4) / (1 / 3)", "\\-6", "-6", 100);
                break;
            case 3:
                operateUserInput("What is (9 + 12 - 2 * 13) * (4 / 5)", "\\-4", "-4", 100);
                break;
            case 4:
                operateUserInput("What is (9 + 12 - 2 * 13) * (8 / 5)", "\\-8", "-8", 100);
                break;
            case 5:
                operateUserInput("What is (9 + 13 - 2 * 7) / (4 / 5)", "(\\+)?10", "10", 100);
                break;
        }
    }

    private void math200() {
        switch (randomNumber()) {
            case 1:
                operateUserInput("A number divided by zero is known as?", "undefined(form)?", "Undefined", 200);
                break;
            case 2:
                operateUserInput("As n approaches infinity, what does 1/n equal?", "(0|zero|nothing|null|nil|nada|zip)",
                        "0", 200);
                break;
            case 3:
                operateUserInput("Assuming it exists, as n approaches zero, what does 1/n equal?", "infinit(e|y)",
                        "Infinity", 200);
                break;
            case 4:
                operateUserInput("0.999... (infinite amount of 9's) is the same as what integer value?", "(1|one)", "1",
                        200);
                break;
            case 5:
                operateUserInput("1 - 0.999... (infinite amount of 9's) is the same as what integer value?",
                        "(0|zero|nothing|null|nil|nada|zip)", "0", 200);
                break;
        }
    }

    private void math300() {
        switch (randomNumber()) {
            case 1:
                operateUserInput("Division is the _______ of multiplication.", "inverse", "Inverse", 300);
                break;
            case 2:
                operateUserInput("sin^(-1)x is the _______ of sin x.", "inverse", "Inverse", 300);
                break;
            case 3:
                operateUserInput("Find x: 2x + 5 = x - 5", "(x\\=)?\\-10", "-10", 300);
                break;
            case 4:
                operateUserInput("Find x: 4x + 20 = 3x - 10", "(x\\=)?\\-30", "-30", 300);
                break;
            case 5:
                operateUserInput("Find x: 6x + 10 = 9x - 5", "(x\\=)?(\\+)?5", "5", 300);
                break;
        }
    }

    private void math400() {
        switch (randomNumber()) {
            case 1:
                operateUserInput("When using limits, zero divided by zero is known as?", "(the)?indeterminate(form)?",
                        "Indeterminate Form", 400);
                break;
            case 2:
                operateUserInput("The irrational number e is known as?", "euler(')?(s)?(number)?", "Euler's Number",
                        400);
                break;
            case 3:
                operateUserInput("To no decimal places, 100e is?", "272", "272", 400);
                break;
            case 4:
                operateUserInput("The square root of -1 is?", "(i|j)", "i", 400);
                break;
            case 5:
                operateUserInput("The square root of -9 is?", "3(\\*)?(i|j)", "3i", 400);
                break;
        }
    }

    private void math500() {
        switch (randomNumber()) {
            case 1:
                operateUserInput("Solve for x: x^2 = 10x - 25 * 0!", "(x\\=)?(\\+)?5", "x = 5", 500);
                break;
            case 2:
                operateUserInput("Solve for x: x^2 = 20x - 100 * 0!", "(x\\=)?(\\+)?10", "x = 10", 500);
                break;
            case 3:
                operateUserInput("e^(i * pi) + 1= _", "(0|zero|nothing|null|nil|nada|zip)", "0", 500);
                break;
            case 4:
                operateUserInput("Solve for x: x^2 = 6x - 9 * 0!", "(x\\=)?(\\+)?3", "x = 3", 500);
                break;
            case 5:
                operateUserInput("Solve for x: x^2 = 8x - 16 * 0!", "(x\\=)?(\\+)?4", "x = 4", 500);
                break;
        }
    }

    private void history100() {
        switch (randomNumber()) {
            case 1:
                operateUserInput("The year the first black president was elected into American Parliamentary power?",
                        "2008", "2008", 100);
                break;
            case 2:
                operateUserInput("The year the first black president was re-elected into American Parliamentary power?",
                        "2012", "2012", 100);
                break;
            case 3:
                operateUserInput("The year the first black president handed over American Parliamentary power?", "2017",
                        "2017", 100);
                break;
            case 4:
                operateUserInput("What year was Canada founded?", "1867", "1867", 100);
                break;
            case 5:
                operateUserInput("What year did World War 1 start?", "1914", "1914", 100);
                break;
        }
    }

    private void history200() {
        switch (randomNumber()) {
            case 1:
                operateUserInput("The year of the first Moon landing?", "1969", "1969", 200);
                break;
            case 2:
                operateUserInput("The year evidence of water was announced to be found on Mars?", "2015", "2015", 200);
                break;
            case 3:
                operateUserInput("The year gravitational waves were announced to be discovered?", "2016", "2016", 200);
                break;
            case 4:
                operateUserInput("The year the discovery of the Higgs Boson was announced?", "2013", "2013", 200);
                break;
            case 5:
                operateUserInput("The year the ISS Space Station was launched?", "1998", "1998", 200);
                break;
        }
    }

    private void history300() {
        switch (randomNumber()) {
            case 1:
                operateUserInput("The year Adolf Hitler was nominated man of the year by Times magazine?", "1939",
                        "1939", 300);
                break;
            case 2:
                operateUserInput("The year Adolf Hitler became chancellor of Germany?", "1933", "1933", 300);
                break;
            case 3:
                operateUserInput("The year Adolf Hitler became head of the Nazi Party?", "1921", "1921", 300);
                break;
            case 4:
                operateUserInput("The year America declared war on the Axis alliance during World War 2?", "1941",
                        "1941", 300);
                break;
            case 5:
                operateUserInput("The attack on which country sparked World War 2?", "poland", "poland", 300);
                break;
        }
    }

    private void history400() {
        switch (randomNumber()) {
            case 1:
                operateUserInput("In 1945 a nuclear bomb was detonated in Hiroshima, Japan. What was the name of the "
                        + "bomb?", "littleboy", "Little Boy", 400);
                break;
            case 2:
                operateUserInput("In 1945 a nuclear bomb was detonated in Nagasaki, Japan. What was the name of the "
                        + "bomb?", "fatman", "Fat Man", 400);
                break;
            case 3:
                operateUserInput("In which year did Einstein publish his special theory of relativity?", "1905", "1905",
                        400);
                break;
            case 4:
                operateUserInput("In which year did Einstein publish his general theory of relativity?", "1915", "1915",
                        400);
                break;
            case 5:
                operateUserInput("What was the name of the city in which Archduke Franz Ferdinand of Austria was "
                        + "assassinated in 1914?", "sarajevo", "Sarajevo", 400);
                break;
        }
    }

    private void history500() {
        switch (randomNumber()) {
            case 1:
                operateUserInput("Who assassinated Archduke Franz Ferdinand of Austria in 1914?",
                        "(gavriloprincip|gavrilo|princip)", "Gavrilo Princip", 500);
                break;
            case 2:
                operateUserInput("In which year was Albert Einstein born?", "1879", "1879", 500);
                break;
            case 3:
                operateUserInput("In which year was Sir Isaac Newton born?", "1643", "1643", 500);
                break;
            case 4:
                operateUserInput("In which year was Stephen Hawking born?", "1942", "1942", 500);
                break;
            case 5:
                operateUserInput("In which year was Charles Darwin born?", "1809", "1809", 500);
                break;
        }
    }

    private void games100() {
        switch (randomNumber()) {
            case 1:
                operateUserInput("The company that created the Mario Brothers is called?",
                        "nintendo((r(&|and)d)|(research(&|and)development))?", "Nintendo", 100);
                break;
            case 2:
                operateUserInput("The company that created Nathan Drake is called?", "naughtydog", "Naughty Dog", 100);
                break;
            case 3:
                operateUserInput("The company that published Link is called?", "nintendo", "Nintendo", 100);
                break;
            case 4:
                operateUserInput("The company that created Ezio Auditore is called?", "ubisoft", "Ubisoft", 100);
                break;
            case 5:
                operateUserInput("The company that created Solid Snake is called?", "kojima(productions)?",
                        "Kojima Productions", 100);
                break;
        }
    }

    private void games200() {
        switch (randomNumber()) {
            case 1:
                operateUserInput("The game in which two users have paddles on separate side of the screen,\nand each "
                        + "user attempts to hit a ball past the paddle of the opposing user.", "pong", "Pong", 200);
                break;
            case 2:
                operateUserInput("The game released in 1978 in which the player controls a ship,\nand must destroy "
                        + "opposing alien ships.", "spaceinvader(s)?", "Space Invaders", 200);
                break;
            case 3:
                operateUserInput("The game released in 1981 in which the player controls a character,\nand must save "
                                + "a princess by jumping over barrels while climbing ladders.", "donkeykong",
                        "Donkey Kong", 200);
                break;
            case 4:
                operateUserInput("The game in which you assemble shapes as they move down,\neach shape consisting of "
                        + "four squares arranged in various manners.", "tetris", "Tetris", 200);
                break;
            case 5:
                operateUserInput("The game in which you play as a big yellow dot that eats smaller yellow dots and "
                        + "runs away from ghosts.", "pac(\\-)?man", "Pacman", 200);
                break;
        }
    }

    private void games300() {
        switch (randomNumber()) {
            case 1:
                operateUserInput("What was the best selling video game of 2015?", "(callofduty|cod)?blackops(3|three)",
                        "Black Ops 3", 300);
                break;
            case 2:
                operateUserInput("What was the best selling video game of 2014?", "(callofduty|cod)?advancedwarfare",
                        "Advanced Warfare", 300);
                break;
            case 3:
                operateUserInput("What was the best selling video game of 2013?", "(gta|grandtheftauto)(v|5|five)",
                        "Grand Theft Auto V", 300);
                break;
            case 4:
                operateUserInput("What was the best selling video game of 2012?", "(callofduty|cod)?blackops(2|two)",
                        "Black Ops 2", 300);
                break;
            case 5:
                operateUserInput("What was the best selling video game in 2011?",
                        "(callofduty|cod)?modernwarfare(3|three)", "Modern Warfare 3", 300);
                break;
        }
    }

    private void games400() {
        switch (randomNumber()) {
            case 1:
                operateUserInput("Name of the pacman ghost with a name starting with I.", "inky", "Inky", 400);
                break;
            case 2:
                operateUserInput("Name of the pacman ghost with a name starting with B.", "blinky", "Blinky", 400);
                break;
            case 3:
                operateUserInput("Name of the pacman ghost with a name starting with P.", "pinky", "Pinky", 400);
                break;
            case 4:
                operateUserInput("Name of the pacman ghost with a name starting with C.", "clyde", "Clyde", 400);
                break;
            case 5:
                operateUserInput("Year the game Pac-Man was released?", "1980", "1980", 400);
                break;
        }
    }

    private void games500() {
        switch (randomNumber()) {
            case 1:
                operateUserInput("The name of the person that created Monopoly?", "(charlesdarrow|charles|darrow)",
                        "Charles Darrow", 500);
                break;
            case 2:
                operateUserInput("The year the game Monopoly was released?", "1935", "1935", 500);
                break;
            case 3:
                operateUserInput("The name of the person that created the game Life?", "(miltonbradley|milton|bradley)",
                        "Milton Bradley", 500);
                break;
            case 4:
                operateUserInput("The year the game Life was created?", "1860", "1860", 500);
                break;
            case 5:
                operateUserInput("The year the game Trivial Pursuit was conceived?", "1979", "1979", 500);
                break;
        }
    }

    private int randomNumber() {
        final int ret = (int) (Math.random() * 5) + 1;
        if (ret < 1 || ret > 5) {
            System.err.println("Error in randomNumber() method: invalid generated number!");
            return 1;
        }
        return ret;
    }

    private void operateUserInput(String question, String answer, String sampleAnswer, int scoreAdd) {
        String userAnswer = JOptionPane.showInputDialog(null, question, CallOfDemocracy.GAME_TITLE,
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
            responseScore.setText("Total score: " + score + " points");
            responseAnswer.setText("Correct! +" + Integer.toString(scoreAdd) + " points");
        } else {
            responseAnswer.setText("Incorrect. Answer: " + sampleAnswer);
        }
    }
}
