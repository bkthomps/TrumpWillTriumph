package trumpwilltriumph;

/**
 * The user has a 90% chance at winning this mini-game, it is pure luck.
 */
class Barbecue {

    void barbecue() {
        doExposition();
        determineIfUserWins();
    }

    private void doExposition() {
        TrumpWillTriumph.expositionDialog("Barbecue.exposition_1", "Barbecue.exposition_2");
    }

    private void determineIfUserWins() {
        final int number = (int) (Math.random() * 10);
        if (number != 0) {
            TrumpWillTriumph.win();
        } else {
            TrumpWillTriumph.lose();
        }
    }
}
