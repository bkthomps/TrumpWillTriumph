package trumpwilltriumph;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Creates the map of the USA, and performs actions based on how the user interacts with the map. The user can tour by
 * first clicking on the state to tour, then clicking the tour button. The user can reset all the data by clicking on
 * the reset button. After a state has been toured, the object responsible for the state will call a method from this
 * class in order to inform to the user whether the state has been won, or if it was lost.
 */
class TrumpWillTriumph {

    static final String GAME_TITLE = "Trump Will Triumph";
    static final ImageIcon ICON_TRUMP = new ImageIcon("Assets/Trump.png");
    static final Path FILE = Paths.get("TrumpWillTriumph.txt");
    private static final String defaultTour = "     Select a state to tour     ";
    private static final int MAP_VERTICAL_TILES = 48;
    private static final int MAP_HORIZONTAL_TILES = 64;

    static final int NANO_SECONDS_PER_SECOND = 1000000000;
    static StateStatus touringState;

    private static final JFrame frame = new JFrame(GAME_TITLE);
    private static final JLabel bottomText = new JLabel(defaultTour);
    private static final JButton tour = new JButton("Tour");
    private static final JButton reset = new JButton("Reset");

    private static final StateStatus[][] stateDisplay = new StateStatus[MAP_VERTICAL_TILES][MAP_HORIZONTAL_TILES];
    private static int guiDisplay, wins, loses;

    public static void main(String[] args) {
        final TrumpWillTriumph trumpWillTriumph = new TrumpWillTriumph();
        trumpWillTriumph.startLogic();
    }

    private void startLogic() {
        checkOperatingSystem();
        loadData();
        setSizeOfFrame();
        configureGUI();
        informUserIfNoStatesToTour();
        userClicksResetButton();
        userClicksTourButton();
    }

    private void checkOperatingSystem() {
        final String os = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
        if (os.contains("nux")) {
            errorAndExit("Linux is not currently supported. Only Windows and macOS are supported.");
        } else if (!os.contains("win") && !os.contains("mac") && !os.contains("darwin")) {
            errorAndExit("Currently, only Windows and macOS are supported.");
        }
    }

    private void loadData() {
        final String[] split = SaveOrLoad.load();
        wins = Integer.parseInt(split[0]);
        loses = Integer.parseInt(split[1]);
        for (int vertical = 0; vertical < MAP_VERTICAL_TILES; vertical++) {
            for (int horizontal = 0; horizontal < MAP_HORIZONTAL_TILES; horizontal++) {
                final int START_OF_MAP_DATA = 2;
                final int mapIndex = horizontal + vertical * MAP_HORIZONTAL_TILES + START_OF_MAP_DATA;
                final int stateStatus = Integer.parseInt(split[mapIndex]);
                stateDisplay[vertical][horizontal] = StateStatus.intToStateStatus(stateStatus);
            }
        }
    }

    private void setSizeOfFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        if (screenSize.getWidth() < screenSize.getHeight()) {
            guiDisplay = (int) (screenSize.getWidth() * 0.8);
        } else {
            guiDisplay = (int) (screenSize.getHeight() * 0.8);
        }
        guiDisplay = (int) (guiDisplay / (double) MAP_HORIZONTAL_TILES) * MAP_HORIZONTAL_TILES;
        if (guiDisplay == 0) {
            errorAndExit("Your Monitor Is Too Small.");
        }
    }

    private void errorAndExit(String errorText) {
        JOptionPane.showConfirmDialog(null, "Critical Error:\n" + errorText + "\nShutting Down.", GAME_TITLE,
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        System.exit(0);
    }

    private void configureGUI() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.add(new GridPane());
        frame.pack();
        JPanel panel = new JPanel();
        panel.add(reset);
        panel.add(bottomText);
        panel.add(tour);
        frame.add(panel, BorderLayout.SOUTH);
        frame.setIconImage(ICON_TRUMP.getImage());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        tour.setEnabled(false);
    }

    private void informUserIfNoStatesToTour() {
        if (wins + loses == 50) {
            bottomText.setText("     Reset to play again. Republican States: " + wins + " / 50     ");
            tour.setEnabled(false);
        }
    }

    private void userClicksResetButton() {
        reset.addActionListener((ActionEvent e) -> {
            frame.setVisible(false);
            final int check = customText("DO YOU REALLY WANT TO RESET ALL DATA?\nTHIS MEANS THAT ALL DATA WILL BE "
                    + "RESET TO DEFAULT", new String[]{"Reset", "Back"});
            if (check == 0) {
                try {
                    Files.delete(FILE);
                } catch (IOException x) {
                    // Nothing.
                }
                customText("Application will now close, re-launch\nthe application to play it again.");
                System.exit(0);
            } else {
                frame.setVisible(true);
            }
        });
    }

    private void userClicksTourButton() {
        tour.addActionListener((ActionEvent e) -> {
            switch (touringState) {
                case NEUTRAL_ALASKA:
                case NEUTRAL_TEXAS:
                case NEUTRAL_FLORIDA:
                    Shooting shooting = new Shooting();
                    shooting.shooting();
                    break;
                case NEUTRAL_WASHINGTON:
                case NEUTRAL_SOUTH_CAROLINA:
                    Reactor reactor = new Reactor();
                    reactor.reactor();
                    break;
                case NEUTRAL_COLORADO:
                case NEUTRAL_MICHIGAN:
                case NEUTRAL_OHIO:
                case NEUTRAL_GEORGIA:
                    Sports sports = new Sports();
                    sports.sports();
                    break;
                case NEUTRAL_HAWAII:
                case NEUTRAL_WYOMING:
                case NEUTRAL_KANSAS:
                    Clicking clicking = new Clicking();
                    clicking.clicking();
                    break;
                case NEUTRAL_MINNESOTA:
                case NEUTRAL_DELAWARE:
                    Fishing fishing = new Fishing();
                    fishing.fishing();
                    break;
                case NEUTRAL_MONTANA:
                case NEUTRAL_MISSISSIPPI:
                case NEUTRAL_INDIANA:
                case NEUTRAL_ALABAMA:
                    Racing racing = new Racing();
                    racing.racing();
                    break;
                case NEUTRAL_OREGON:
                case NEUTRAL_MISSOURI:
                case NEUTRAL_CONNECTICUT:
                    Memory memory = new Memory();
                    memory.memory();
                    break;
                case NEUTRAL_NORTH_CAROLINA:
                case NEUTRAL_MAINE:
                case NEUTRAL_VERMONT:
                    Skiing skiing = new Skiing();
                    skiing.skiing();
                    break;
                case NEUTRAL_NEBRASKA:
                case NEUTRAL_ARKANSAS:
                case NEUTRAL_TENNESSEE:
                    Recall recall = new Recall();
                    recall.recall();
                    break;
                case NEUTRAL_SOUTH_DAKOTA:
                    Sorting sorting = new Sorting();
                    sorting.sorting();
                    break;
                case NEUTRAL_MASSACHUSETTS:
                    Palindrome palindrome = new Palindrome();
                    palindrome.palindrome();
                    break;
                case NEUTRAL_ARIZONA:
                case NEUTRAL_ILLINOIS:
                case NEUTRAL_LOUISIANA:
                case NEUTRAL_NEW_MEXICO:
                case NEUTRAL_NEW_YORK:
                case NEUTRAL_NORTH_DAKOTA:
                case NEUTRAL_UTAH:
                case NEUTRAL_WEST_VIRGINIA:
                    Questions questions = new Questions();
                    questions.questions();
                    break;
                case NEUTRAL_CALIFORNIA:
                case NEUTRAL_IDAHO:
                case NEUTRAL_KENTUCKY:
                case NEUTRAL_WISCONSIN:
                    AnimatedClicking animatedClicking = new AnimatedClicking();
                    animatedClicking.animatedClicking();
                    break;
                case NEUTRAL_NEW_JERSEY:
                    Boxing boxing = new Boxing();
                    boxing.boxing();
                    break;
                case NEUTRAL_NEW_HAMPSHIRE:
                    Scramble scramble = new Scramble();
                    scramble.scramble();
                    break;
                case NEUTRAL_NEVADA:
                    Gambling gambling = new Gambling();
                    gambling.gambling();
                    break;
                case NEUTRAL_IOWA:
                    Rally rally = new Rally();
                    rally.rally();
                    break;
                case NEUTRAL_MARYLAND:
                    AgencyNSA agencyNSA = new AgencyNSA();
                    agencyNSA.agencyNSA();
                    break;
                case NEUTRAL_VIRGINIA:
                    AgencyCIA agencyCIA = new AgencyCIA();
                    agencyCIA.agencyCIA();
                    break;
                case NEUTRAL_OKLAHOMA:
                    Tweet tweet = new Tweet();
                    tweet.tweet();
                    break;
                case NEUTRAL_RHODE_ISLAND:
                    Barbecue barbecue = new Barbecue();
                    barbecue.barbecue();
                    break;
                case NEUTRAL_PENNSYLVANIA:
                    Jeopardy jeopardy = new Jeopardy();
                    jeopardy.jeopardyPrepareGUI();
                    break;
            }
            tour.setEnabled(false);
            bottomText.setText(defaultTour);
        });
    }

    private class GridPane extends JPanel {

        private final List<Rectangle> cells;

        GridPane() {
            cells = new ArrayList<>(MAP_VERTICAL_TILES * MAP_HORIZONTAL_TILES);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    final int horizontalClickPosition = (e.getX()) / (getWidth() / MAP_HORIZONTAL_TILES);
                    final int verticalClickPosition = (e.getY()) / (getHeight() / MAP_VERTICAL_TILES);
                    if (horizontalClickPosition >= 0 && horizontalClickPosition < MAP_HORIZONTAL_TILES
                            && verticalClickPosition >= 0 && verticalClickPosition < MAP_VERTICAL_TILES) {
                        touringState = stateDisplay[verticalClickPosition][horizontalClickPosition];
                        final int currentState = touringState.stateStatusToInt();
                        if (currentState >= 50 && currentState < 100) {
                            final String[] STATES = {"Alaska", "Hawaii", "Washington", "Oregon", "California", "Idaho",
                                    "Nevada", "Utah", "Arizona", "Montana", "Wyoming", "Colorado", "New Mexico",
                                    "North Dakota", "South Dakota", "Nebraska", "Kansas", "Oklahoma", "Texas",
                                    "Minnesota", "Iowa", "Missouri", "Arkansas", "Louisiana", "Wisconsin", "Illinois",
                                    "Mississippi", "Michigan", "Indiana", "Kentucky", "Tennessee", "Alabama", "Ohio",
                                    "Georgia", "Florida", "New York", "Pennsylvania", "West Virginia", "Virginia",
                                    "North Carolina", "South Carolina", "Maine", "Vermont", "New Hampshire",
                                    "Massachusetts", "Rhode Island", "Connecticut", "New Jersey", "Delaware",
                                    "Maryland"};
                            bottomText.setText("     Tour " + STATES[currentState - 50] + "?     ");
                            tour.setEnabled(true);
                        }
                    }
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(guiDisplay, (int) (guiDisplay * 0.75));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            final int cellWidth = getWidth() / MAP_HORIZONTAL_TILES;
            final int cellHeight = getHeight() / MAP_VERTICAL_TILES;
            if (cells.isEmpty()) {
                for (int row = 0; row < MAP_VERTICAL_TILES; row++) {
                    for (int col = 0; col < MAP_HORIZONTAL_TILES; col++) {
                        final Rectangle cell = new Rectangle(col * cellWidth, row * cellHeight, cellWidth, cellHeight);
                        cells.add(cell);
                    }
                }
            }

            for (int vertical = 0; vertical < MAP_VERTICAL_TILES; vertical++) {
                for (int horizontal = 0; horizontal < MAP_HORIZONTAL_TILES; horizontal++) {
                    Rectangle cell = cells.get(horizontal + vertical * MAP_HORIZONTAL_TILES);
                    if (stateDisplay[vertical][horizontal] == StateStatus.WHITE_SQUARE) {
                        g2d.setColor(Color.WHITE);
                    } else if (stateDisplay[vertical][horizontal] == StateStatus.BLACK_SQUARE) {
                        g2d.setColor(Color.BLACK);
                    } else if (stateDisplay[vertical][horizontal].stateStatusToInt() >= 150) {
                        g2d.setColor(Color.RED);
                    } else if (stateDisplay[vertical][horizontal].stateStatusToInt() < 150
                            && stateDisplay[vertical][horizontal].stateStatusToInt() >= 100) {
                        final Color color = new Color(30, 144, 255);
                        g2d.setColor(color);
                    } else if (stateDisplay[vertical][horizontal].stateStatusToInt() < 100
                            && stateDisplay[vertical][horizontal].stateStatusToInt() >= 50) {
                        final Color color = new Color(186, 85, 211);
                        g2d.setColor(color);
                    }
                    g2d.fill(cell);
                    repaint();
                }
            }
        }
    }

    static void hideMap() {
        frame.setVisible(false);
    }

    static void customText(String text) {
        customText(text, new String[]{"Continue"});
    }

    static int customText(String text, String[] options) {
        int check = JOptionPane.showOptionDialog(null, text, GAME_TITLE, JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (check == -1) {
            System.exit(0);
        }
        return check;
    }

    static void displayExposition(String text) {
        frame.setVisible(false);
        customText(text);
    }

    static void win() {
        wins++;
        miniGameDone(true, "Mr. Trump, you won!");
    }

    static void lose() {
        loses++;
        miniGameDone(false, "Mr. Trump, you lost...");
    }

    private static void miniGameDone(boolean isRepublicanWin, String message) {
        final int REPUBLICAN_WIN = 100;
        final int DEMOCRAT_WIN = 50;
        final int currentWin = (isRepublicanWin) ? (REPUBLICAN_WIN) : (DEMOCRAT_WIN);
        for (int vertical = 0; vertical < MAP_VERTICAL_TILES; vertical++) {
            for (int horizontal = 0; horizontal < MAP_HORIZONTAL_TILES; horizontal++) {
                if (stateDisplay[vertical][horizontal] == touringState) {
                    final int stateStatus = currentWin + stateDisplay[vertical][horizontal].stateStatusToInt();
                    stateDisplay[vertical][horizontal] = StateStatus.intToStateStatus(stateStatus);
                }
            }
        }
        SaveOrLoad.save(wins, loses, stateDisplay);
        customText(message);
        touringState = StateStatus.WHITE_SQUARE;
        if (wins + loses != 50) {
            frame.setVisible(true);
        } else {
            checkGameWin();
        }
    }

    private static void checkGameWin() {
        if (wins >= 25) {
            customText("Mr. Trump, you became president!\nTo play again, click the reset\nbutton on the map of the "
                    + "U.S.A");
        } else {
            customText("Mr. Trump, you lost the race to presidency...\nTo play again, click the reset button on "
                    + "the\nmap of the U.S.A");
        }
        bottomText.setText("     Reset to play again. Republican States: " + wins + " / 50     ");
        tour.setEnabled(false);
        frame.setVisible(true);
    }
}
