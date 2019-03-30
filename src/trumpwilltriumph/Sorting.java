package trumpwilltriumph;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * If the user is able to determine which type of sorting was used, the user wins. Else, the user loses.
 */
class Sorting {

    enum SortingType {BUBBLE, SELECTION, INSERTION}

    private final int sortingArray[] = new int[5];
    private SortingType sortingType;
    private String sortingLine;

    private final JFrame frameState = new JFrame(TrumpWillTriumph.GAME_TITLE);
    private final JButton bubbleSort = new JButton("Bubble Sort");
    private final JButton selectionSort = new JButton("Selection Sort");
    private final JButton insertionSort = new JButton("InsertionSort");

    void sorting() {
        doExposition();
        configureSortingDisplayContext();
        setSortingType();
        performSortingLogic();
        configureGUI();
        userSubmitAnswerListener();
    }

    private void doExposition() {
        TrumpWillTriumph.displayExposition("Mr. Trump, to test your skill, given the steps produced by\na random "
                + "sorting algorithm, pick which one was used.");
    }

    private void configureSortingDisplayContext() {
        for (int counter = 0; counter < sortingArray.length; counter++) {
            sortingArray[counter] = (int) (Math.random() * 100);
        }
        sortingLine = sortingArray[0] + " " + sortingArray[1] + " " + sortingArray[2] + " "
                + sortingArray[3] + " " + sortingArray[4];
    }

    private void setSortingType() {
        final int temp = (int) (Math.random() * 3);
        if (temp == 0) {
            sortingType = SortingType.BUBBLE;
        } else if (temp == 1) {
            sortingType = SortingType.SELECTION;
        } else {
            sortingType = SortingType.INSERTION;
        }
    }

    private void performSortingLogic() {
        switch (sortingType) {
            case BUBBLE:
                bubbleSortLogic();
                break;
            case SELECTION:
                selectionSortLogic();
                break;
            case INSERTION:
                insertionSortLogic();
                break;
        }
    }

    private void bubbleSortLogic() {
        for (int i = 0; i < sortingArray.length; i++) {
            for (int j = 1; j < sortingArray.length - i; j++) {
                if (sortingArray[j - 1] > sortingArray[j]) {
                    final int temp = sortingArray[j - 1];
                    sortingArray[j - 1] = sortingArray[j];
                    sortingArray[j] = temp;
                    sortingLine += " → " + sortingArray[0] + " " + sortingArray[1] + " "
                            + sortingArray[2] + " " + sortingArray[3] + " " + sortingArray[4];
                }
            }
        }
    }

    private void selectionSortLogic() {
        for (int i = 0; i < sortingArray.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < sortingArray.length; j++) {
                if (sortingArray[minIndex] > sortingArray[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                final int temp = sortingArray[i];
                sortingArray[i] = sortingArray[minIndex];
                sortingArray[minIndex] = temp;
            }
            sortingLine += " → " + sortingArray[0] + " " + sortingArray[1] + " " + sortingArray[2] + " "
                    + sortingArray[3] + " " + sortingArray[4];
        }
    }

    private void insertionSortLogic() {
        int j, k;
        for (int i = 1; i < sortingArray.length; i++) {
            k = sortingArray[i];
            j = i;
            while (j > 0 && sortingArray[j - 1] > k) {
                sortingArray[j] = sortingArray[j - 1];
                j--;
            }
            sortingArray[j] = k;
            sortingLine += " → " + sortingArray[0] + " " + sortingArray[1] + " " + sortingArray[2] + " "
                    + sortingArray[3] + " " + sortingArray[4];
        }
    }

    private void configureGUI() {
        frameState.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameState.setResizable(false);

        JLabel label = new JLabel(sortingLine);

        JPanel sortingPanel = new JPanel();
        sortingPanel.add(bubbleSort);
        sortingPanel.add(selectionSort);
        sortingPanel.add(insertionSort);

        frameState.setLayout(new GridLayout(2, 1));
        frameState.add(label);
        frameState.add(sortingPanel);
        frameState.pack();
        frameState.setLocationRelativeTo(null);
        frameState.setIconImage(TrumpWillTriumph.ICON_TRUMP.getImage());
        frameState.setVisible(true);
    }

    private void userSubmitAnswerListener() {
        userAnswersBubbleListener();
        userAnswersSelectionListener();
        userAnswersInsertionListener();
    }

    private void userAnswersBubbleListener() {
        bubbleSort.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if (sortingType == SortingType.BUBBLE) {
                TrumpWillTriumph.win();
            } else {
                TrumpWillTriumph.lose();
            }
        });
    }

    private void userAnswersSelectionListener() {
        selectionSort.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if (sortingType == SortingType.SELECTION) {
                TrumpWillTriumph.win();
            } else {
                TrumpWillTriumph.lose();
            }
        });
    }

    private void userAnswersInsertionListener() {
        insertionSort.addActionListener((ActionEvent e) -> {
            frameState.setVisible(false);
            if (sortingType == SortingType.INSERTION) {
                TrumpWillTriumph.win();
            } else {
                TrumpWillTriumph.lose();
            }
        });
    }
}
