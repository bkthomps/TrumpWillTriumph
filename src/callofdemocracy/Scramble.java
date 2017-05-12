package callofdemocracy;

import javax.swing.JOptionPane;

/**
 * The user must successfully unscramble the words. If the user does so, the user wins. Else, the user loses.
 */
class Scramble {

    private final String WORD_LIBRARY[] = {"rock", "puke", "love", "more", "tape", "dizzy", "quark", "waltz", "blitz",
            "hotel", "strife", "joyful", "jiggle", "jungle", "masque", "maximum", "minimum", "judging", "zombies",
            "freezing"};

    private int score, random;
    private String word, answer, userInput;
    private char[] letter, scrambled;

    void scramble() {
        doExposition();
        gameLogic();
    }

    private void gameLogic() {
        copyStrings();
        copyCharacterArray();
        scrambleNewCharacterArray();
        convertScrambledCharacterArrayToString();
        getUserAnswer();
        determineIfUserWon();
    }

    private void doExposition() {
        CallOfDemocracy.displayExposition("Mr. Trump, we will test you with a word scramble\ngame. Get 10 points and "
                + "you will win the state's\nvote. Get one word wrong and you will lose it.");
    }

    private void copyStrings() {
        random = (int) (Math.random() * 10);
        word = WORD_LIBRARY[random];
        answer = WORD_LIBRARY[random];
    }

    private void copyCharacterArray() {
        letter = new char[answer.length()];
        for (int i = 0; i < answer.length(); i++) {
            letter[i] = word.charAt(i);
        }
    }

    private void scrambleNewCharacterArray() {
        scrambled = new char[answer.length()];
        for (int i = 0; i < answer.length(); i++) {
            random = (int) (Math.random() * answer.length());
            while (letter[random] == ' ') {
                random = (int) (Math.random() * answer.length());
            }
            scrambled[i] = letter[random];
            letter[random] = ' ';
        }
    }

    private void convertScrambledCharacterArrayToString() {
        word = String.valueOf(scrambled);
    }

    private void getUserAnswer() {
        userInput = JOptionPane.showInputDialog(null, score + " points\nUnscramble: " + word,
                CallOfDemocracy.GAME_TITLE, JOptionPane.PLAIN_MESSAGE);
        if (userInput == null) {
            System.exit(0);
        }
    }

    private void determineIfUserWon() {
        if (userInput.equals(answer)) {
            score += answer.length();
            if (score >= 10) {
                CallOfDemocracy.win();
            } else {
                gameLogic();
            }
        } else {
            CallOfDemocracy.lose();
        }
    }
}
