package trumpwilltriumph;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * The user must prevent the reactor from over-heating, from over-spinning, and from having too much pressure. If the
 * user fails to do so, the reactor is not able to shut down properly and it goes out of control, resulting in the user
 * losing. If the user is able to prevent the reactor from going out of control, the user wins.
 */
class Reactor {

    private final JFrame frameState = new JFrame(TrumpWillTriumph.GAME_TITLE);

    private final JPanel temperaturePanel = new JPanel();
    private final JLabel temperatureLabel = new JLabel(TrumpWillTriumph.RESOURCE.getString("Reactor.temperature")
            + " 500 " + TrumpWillTriumph.RESOURCE.getString("Reactor.celsius"));
    private final JButton temperatureButton = new JButton(TrumpWillTriumph.RESOURCE.getString("Reactor.cool"));
    private final JLabel temperatureWarning = new JLabel(new ImageIcon("Assets/ReactorSafe.png"));

    private final JPanel pressurePanel = new JPanel();
    private final JLabel pressureLabel = new JLabel(TrumpWillTriumph.RESOURCE.getString("Reactor.pressure")
            + " 250 " + TrumpWillTriumph.RESOURCE.getString("Reactor.kpa") + "   ");
    private final JButton pressureButton = new JButton(TrumpWillTriumph.RESOURCE.getString("Reactor.blow"));
    private final JLabel pressureWarning = new JLabel(new ImageIcon("Assets/ReactorSafe.png"));

    private final JPanel rotationsPanel = new JPanel();
    private final JLabel rotationsLabel = new JLabel(TrumpWillTriumph.RESOURCE.getString("Reactor.rotations")
            + " 2500 " + TrumpWillTriumph.RESOURCE.getString("Reactor.rpm"));
    private final JButton rotationsButton = new JButton(TrumpWillTriumph.RESOURCE.getString("Reactor.slow"));
    private final JLabel rotationsWarning = new JLabel(new ImageIcon("Assets/ReactorSafe.png"));

    private final JPanel timePanel = new JPanel();
    private final JLabel timeLabel = new JLabel(TrumpWillTriumph.RESOURCE.getString("Reactor.timeUntilRestore")
            + " 60 " + TrumpWillTriumph.RESOURCE.getString("Reactor.seconds"));

    private static final int CRITICAL_TEMPERATURE = 1000, CRITICAL_PRESSURE = 500, CRITICAL_ROTATIONS = 5000;
    private static final int MAX_SAFE_TEMPERATURE = 800, MAX_SAFE_PRESSURE = 400, MAX_SAFE_ROTATIONS = 4000;

    private int temperature = 500, pressure = 250, rotations = 2500, time = 600;

    void reactor() {
        doExposition();
        configureGUI();
        addButtonClickEvents();
        doTimer();
    }

    private void doExposition() {
        switch (TrumpWillTriumph.touringState) {
            case NEUTRAL_WASHINGTON:
                TrumpWillTriumph.expositionDialog("Reactor.washington_exposition_1", "Reactor.washington_exposition_2",
                        "Reactor.washington_exposition_3");
                break;
            case NEUTRAL_SOUTH_CAROLINA:
                TrumpWillTriumph.expositionDialog("Reactor.southCarolina_exposition_1",
                        "Reactor.southCarolina_exposition_2", "Reactor.southCarolina_exposition_3");
                break;
        }
    }

    private void configureGUI() {
        frameState.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameState.setResizable(false);

        temperaturePanel.add(temperatureLabel);
        temperaturePanel.add(temperatureButton);
        temperaturePanel.add(temperatureWarning);

        pressurePanel.add(pressureLabel);
        pressurePanel.add(pressureButton);
        pressurePanel.add(pressureWarning);

        rotationsPanel.add(rotationsLabel);
        rotationsPanel.add(rotationsButton);
        rotationsPanel.add(rotationsWarning);

        timePanel.add(timeLabel);

        frameState.add(temperaturePanel);
        frameState.add(pressurePanel);
        frameState.add(rotationsPanel);
        frameState.add(timePanel);
        frameState.setLayout(new GridLayout(4, 1));

        frameState.pack();
        frameState.setLocationRelativeTo(null);
        frameState.setIconImage(TrumpWillTriumph.ICON_TRUMP.getImage());
        frameState.setVisible(true);
    }

    private void addButtonClickEvents() {
        temperatureButton.addActionListener((ActionEvent e) ->
                temperature = (temperature > 40) ? (temperature - 20) : (20));

        pressureButton.addActionListener((ActionEvent e) -> pressure = (pressure > 10) ? (pressure - 10) : (0));

        rotationsButton.addActionListener((ActionEvent e) -> rotations = (rotations > 100) ? (rotations - 100) : (0));
    }

    private void adjustDataBasedOnTime() {
        if ((int) (Math.random() * 8) != 0) {
            temperature += 4;
        }
        if ((int) (Math.random() * 8) != 0) {
            pressure += 2;
        }
        if ((int) (Math.random() * 8) != 0) {
            rotations += 20;
        }
        time--;
    }

    private void setText() {
        temperatureLabel.setText(TrumpWillTriumph.RESOURCE.getString("Reactor.temperature") + " " + temperature
                + " " + TrumpWillTriumph.RESOURCE.getString("Reactor.celsius"));
        pressureLabel.setText(TrumpWillTriumph.RESOURCE.getString("Reactor.pressure") + " " + pressure
                + " " + TrumpWillTriumph.RESOURCE.getString("Reactor.kpa") + "   ");
        rotationsLabel.setText(TrumpWillTriumph.RESOURCE.getString("Reactor.rotations") + " " + rotations
                + " " + TrumpWillTriumph.RESOURCE.getString("Reactor.rpm"));
        timeLabel.setText(TrumpWillTriumph.RESOURCE.getString("Reactor.timeUntilRestore") + " " + time / 10
                + " " + TrumpWillTriumph.RESOURCE.getString("Reactor.seconds"));
    }

    private void setImages() {
        if (temperature >= MAX_SAFE_TEMPERATURE) {
            temperatureWarning.setIcon(new ImageIcon("Assets/ReactorDangerous.png"));
        } else {
            temperatureWarning.setIcon(new ImageIcon("Assets/ReactorSafe.png"));
        }

        if (pressure >= MAX_SAFE_PRESSURE) {
            pressureWarning.setIcon(new ImageIcon("Assets/ReactorDangerous.png"));
        } else {
            pressureWarning.setIcon(new ImageIcon("Assets/ReactorSafe.png"));
        }

        if (rotations >= MAX_SAFE_ROTATIONS) {
            rotationsWarning.setIcon(new ImageIcon("Assets/ReactorDangerous.png"));
        } else {
            rotationsWarning.setIcon(new ImageIcon("Assets/ReactorSafe.png"));
        }
    }

    private void endGame(java.util.Timer timer) {
        if (isGoneCritical()) {
            timer.cancel();
            frameState.setVisible(false);
            if (TrumpWillTriumph.touringState == StateStatus.NEUTRAL_WASHINGTON) {
                TrumpWillTriumph.customDialog("Reactor.explode");
            } else {
                TrumpWillTriumph.customDialog("Reactor.meltdown");
            }
            TrumpWillTriumph.lose();
        } else if (isShutDown()) {
            timer.cancel();
            frameState.setVisible(false);
            if (TrumpWillTriumph.touringState == StateStatus.NEUTRAL_WASHINGTON) {
                TrumpWillTriumph.customDialog("Reactor.success_1");
            } else {
                TrumpWillTriumph.customDialog("Reactor.success_2");
            }
            TrumpWillTriumph.win();
        }
    }

    private boolean isGoneCritical() {
        return temperature >= CRITICAL_TEMPERATURE || pressure >= CRITICAL_PRESSURE || rotations >= CRITICAL_ROTATIONS;
    }

    private boolean isShutDown() {
        return time <= 1;
    }

    private void doTimer() {
        java.util.Timer timer = new java.util.Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                adjustDataBasedOnTime();
                setText();
                setImages();
                endGame(timer);
            }
        }, 0, 100);
    }
}
