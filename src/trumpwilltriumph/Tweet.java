package trumpwilltriumph;

import javax.swing.JOptionPane;

/**
 * The user must send a tweet. The tweet must be greater than 0 characters and less than or equal to 140 characters.
 * There is a 90% chance that the user wins the mini-game opposed to losing, which is determined by a randomly generated
 * number.
 */
class Tweet {

    private String sentence;

    void tweet() {
        getInitialTweet();
        invalidOriginalTweet();
        checkIfUserWins();
    }

    private void getInitialTweet() {
        TrumpWillTriumph.hideMap();
        sentence = JOptionPane.showInputDialog(null, TrumpWillTriumph.RESOURCE.getString("Tweet.exposition_1")
                        + System.lineSeparator() + TrumpWillTriumph.RESOURCE.getString("Tweet.exposition_2")
                        + System.lineSeparator() + TrumpWillTriumph.RESOURCE.getString("Tweet.exposition_3"),
                TrumpWillTriumph.GAME_TITLE, JOptionPane.PLAIN_MESSAGE);
        checkIfUserExit();
    }

    private void checkIfUserExit() {
        if (sentence == null) {
            System.exit(0);
        }
    }

    private void invalidOriginalTweet() {
        while (sentence.length() > 140 || sentence.length() == 0) {
            if (sentence.length() == 0) {
                sentence = JOptionPane.showInputDialog(null, TrumpWillTriumph.RESOURCE.getString("Tweet.empty"),
                        TrumpWillTriumph.GAME_TITLE, JOptionPane.PLAIN_MESSAGE);
            } else if (sentence.length() > 140) {
                sentence = JOptionPane.showInputDialog(null, TrumpWillTriumph.RESOURCE.getString("Tweet.tooLong"),
                        TrumpWillTriumph.GAME_TITLE, JOptionPane.PLAIN_MESSAGE);
            }
            checkIfUserExit();
        }
    }

    private void checkIfUserWins() {
        final int number = (int) (Math.random() * 10);
        if (number != 0) {
            TrumpWillTriumph.win();
        } else {
            TrumpWillTriumph.lose();
        }
    }
}
