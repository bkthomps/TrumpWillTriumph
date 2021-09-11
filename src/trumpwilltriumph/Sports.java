package trumpwilltriumph;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 * If the user is able to land the ball or puck into the net, the user wins. Else, the user loses.
 */
class Sports {

    private final JFrame frameState = new JFrame(TrumpWillTriumph.GAME_TITLE);
    private JLabel background;

    void sports() {
        doExposition();
        setImageAndFrameSize();
        configureGUI();
        onMouseEvent();
    }

    private void configureGUI() {
        frameState.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameState.setResizable(false);
        frameState.setResizable(false);
        frameState.add(background);
        frameState.setLocationRelativeTo(null);
        frameState.setIconImage(TrumpWillTriumph.ICON_TRUMP.getImage());
        frameState.setVisible(true);
    }

    private void doExposition() {
        switch (TrumpWillTriumph.touringState) {
            case NEUTRAL_COLORADO:
                TrumpWillTriumph.expositionDialog("Sports.exposition_colorado_1", "Sports.exposition_colorado_2");
                break;
            case NEUTRAL_MICHIGAN:
                TrumpWillTriumph.expositionDialog("Sports.exposition_michigan_1", "Sports.exposition_michigan_2");
                break;
            case NEUTRAL_OHIO:
                TrumpWillTriumph.expositionDialog("Sports.exposition_ohio_1", "Sports.exposition_ohio_2");
                break;
            case NEUTRAL_GEORGIA:
                TrumpWillTriumph.expositionDialog("Sports.exposition_georgia_1", "Sports.exposition_georgia_2");
                break;
        }
    }

    private void setImageAndFrameSize() {
        switch (TrumpWillTriumph.touringState) {
            case NEUTRAL_COLORADO:
                background = new JLabel(new ImageIcon("Assets/HockeyNet.png"));
                frameState.setSize(303, 325);
                setCursor("Assets/HockeyPuck.png");
                break;
            case NEUTRAL_MICHIGAN:
                background = new JLabel(new ImageIcon("Assets/SoccerBackground.png"));
                frameState.setSize(303, 325);
                setCursor("Assets/SoccerBall.png");
                break;
            case NEUTRAL_OHIO:
                background = new JLabel(new ImageIcon("Assets/FootballPost.png"));
                frameState.setSize(303, 325);
                setCursor("Assets/Football.png");
                break;
            case NEUTRAL_GEORGIA:
                background = new JLabel(new ImageIcon("Assets/BasketballBackground.png"));
                frameState.setSize(203, 325);
                setCursor("Assets/Basketball.png");
                break;
        }
    }

    private void setCursor(String cursorFile) {
        final ImageIcon image = new ImageIcon(cursorFile);
        frameState.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(image.getImage(), new Point(0, 0), ""));
    }

    private void onMouseEvent() {
        frameState.addMouseListener(new MouseListener() {
            int startX, startY, endX, endY;
            double vectorX, vectorY;
            boolean win;

            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                endX = me.getX();
                endY = me.getY();
                // Determining the stepping amount.
                vectorX = (endX - startX) / 100;
                vectorY = (endY - startY) / 100;
                // Declaring hit boxes for linear recognition of stepping amount.
                if (vectorX != 0 || vectorY != 0) {
                    while (startX > 0 && startX < 300 && startY > 0 && startY < 300) {
                        startX += vectorX;
                        startY += vectorY;
                        if (didUserScore(startX, startY)) {
                            win = true;
                        }
                    }
                }
                frameState.setVisible(false);
                if (win) {
                    TrumpWillTriumph.customDialog("Sports.scored");
                    TrumpWillTriumph.win();
                } else {
                    TrumpWillTriumph.customDialog("Sports.missed");
                    TrumpWillTriumph.lose();
                }
            }

            @Override
            public void mouseClicked(MouseEvent me) {
                // Not used.
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                // Not used.
            }

            @Override
            public void mouseExited(MouseEvent me) {
                // Not used.
            }
        });
    }

    private boolean didUserScore(int startX, int startY) {
        boolean ret = false;
        switch (TrumpWillTriumph.touringState) {
            case NEUTRAL_COLORADO:
                if (startX > 65 && startX < 225 && startY > 20 && startY < 110) {
                    ret = true;
                }
                break;
            case NEUTRAL_MICHIGAN:
                if (startX > 0 && startX < 300 && startY > 20 && startY < 130) {
                    ret = true;
                }
                break;
            case NEUTRAL_OHIO:
                if (startX > 90 && startX < 200 && startY > 10 && startY < 90) {
                    ret = true;
                }
                break;
            case NEUTRAL_GEORGIA:
                if (startX > 65 && startX < 105 && startY > 35 && startY < 95) {
                    ret = true;
                }
                break;
        }
        return ret;
    }
}
