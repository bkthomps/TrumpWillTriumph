package callofdemocracy;

/**
 * The user has a 90% chance at winning this mini-game, it is pure luck.
 */
class Barbecue {

    void barbecue() {
        doExposition();
        determineIfUserWins();
    }

    private void doExposition() {
        CallOfDemocracy.displayExposition("Mr. Trump, Rhode Island is so small that we\nwill just host a barbecue, "
                + "and will most probably win.");
    }

    private void determineIfUserWins() {
        final int number = (int) (Math.random() * 10);
        if (number != 0) {
            CallOfDemocracy.win();
        } else {
            CallOfDemocracy.lose();
        }
    }
}
