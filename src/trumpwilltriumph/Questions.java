package trumpwilltriumph;

/**
 * The user is asked various questions. If the user responds with the correct answer, the user gains points. By the end
 * of the question period, if the user has more than a certain amount of points, the user wins the mini-game. Else, the
 * user loses the mini-game.
 */
class Questions {

    private int score;
    private String answer = "";
    private String[] options;

    void questions() {
        TrumpWillTriumph.hideMap();
        switch (TrumpWillTriumph.touringState) {
            case NEUTRAL_ARIZONA:
                arizona();
                break;
            case NEUTRAL_ILLINOIS:
                illinois();
                break;
            case NEUTRAL_LOUISIANA:
                louisiana();
                break;
            case NEUTRAL_NEW_MEXICO:
                newMexico();
                break;
            case NEUTRAL_NEW_YORK:
                newYork();
                break;
            case NEUTRAL_NORTH_DAKOTA:
                northDakota();
                break;
            case NEUTRAL_UTAH:
                utah();
                break;
            case NEUTRAL_WEST_VIRGINIA:
                westVirginia();
                break;
        }
    }

    private void arizona() {
        setOptions("Questions.arizona_options_1_1", "Questions.arizona_options_1_2");
        ask("Questions.arizona_ask_1", 1, 0);

        setOptions("Questions.arizona_options_1_1", "Questions.arizona_options_1_2");
        ask("Questions.arizona_ask_2", -1, 0);

        setOptions("Questions.arizona_options_1_1", "Questions.arizona_options_1_2");
        ask("Questions.arizona_ask_3", -1, 0);

        setOptions("Questions.arizona_options_1_1", "Questions.arizona_options_1_2");
        ask("Questions.arizona_ask_4", 1, 0);

        setOptions("Questions.arizona_options_2_1", "Questions.arizona_options_2_2");
        ask("Questions.arizona_ask_5_1", "Questions.arizona_ask_5_2", 2, 0);

        endGame(3);
    }

    private void illinois() {
        setOptions("Questions.illinois_options_1_1", "Questions.illinois_options_1_2");
        ask("Questions.illinois_ask_1_1", "Questions.illinois_ask_1_2", 0, 0);

        setOptions("Questions.illinois_options_2_1", "Questions.illinois_options_2_2");
        ask("Questions.illinois_ask_2", 0, -1);

        setOptions("Questions.illinois_options_3_1", "Questions.illinois_options_3_2");
        ask("Questions.illinois_ask_3", -1, 0);

        setOptions("Questions.illinois_options_4_1", "Questions.illinois_options_4_2");
        ask("Questions.illinois_ask_4_1", "Questions.illinois_ask_4_2", 2, 1);

        endGame(1);
    }

    private void newYork() {
        setOptions("Questions.newYork_options_1_1", "Questions.newYork_options_1_2");
        ask("Questions.newYork_ask_1", -1, 0);

        setOptions("Questions.newYork_options_2_1", "Questions.newYork_options_2_2");
        ask("Questions.newYork_ask_2_1", "Questions.newYork_ask_2_2", -1, 0);

        setOptions("Questions.newYork_options_3_1", "Questions.newYork_options_3_2");
        ask("Questions.newYork_ask_3_1", "Questions.newYork_ask_3_2", 3, -1);

        setOptions("Questions.newYork_options_4_1", "Questions.newYork_options_4_2");
        ask("Questions.newYork_ask_4", -1, 1);

        endGame(3);
    }

    private void westVirginia() {
        setOptions("Questions.westVirginia_options_1");
        ask("Questions.westVirginia_ask_1_1", "Questions.westVirginia_ask_1_2", 0);

        setOptions("Questions.westVirginia_options_2_1", "Questions.westVirginia_options_2_2",
                "Questions.westVirginia_options_2_3");
        ask("Questions.westVirginia_ask_2", 1, 2, 0);

        setOptions("Questions.westVirginia_options_3_1", "Questions.westVirginia_options_3_2");
        ask("Questions.westVirginia_ask_3", 2, 1);

        setOptions("Questions.westVirginia_options_4_1", "Questions.westVirginia_options_4_2",
                "Questions.westVirginia_options_4_3");
        ask("Questions.westVirginia_ask_4", 1, 1, 0);

        setOptions("Questions.westVirginia_options_5_1", "Questions.westVirginia_options_5_2",
                "Questions.westVirginia_options_5_3");
        ask("Questions.westVirginia_ask_5", 1, 1, 2);

        endGame(5);
    }

    private void louisiana() {
        setOptions("Questions.louisiana_options_1_1", "Questions.louisiana_options_1_2");
        ask("Questions.louisiana_ask_1_1", "Questions.louisiana_ask_1_2", 0, 1);

        setOptions("Questions.louisiana_options_2_1", "Questions.louisiana_options_2_2",
                "Questions.louisiana_options_2_3", "Questions.louisiana_options_2_4");
        question("Questions.louisiana_ask_2", 0);

        setOptions("Questions.louisiana_options_3_1", "Questions.louisiana_options_3_2",
                "Questions.louisiana_options_3_3", "Questions.louisiana_options_3_4");
        question("Questions.louisiana_ask_3", 1);

        setOptions("Questions.louisiana_options_4_1", "Questions.louisiana_options_4_2",
                "Questions.louisiana_options_4_3", "Questions.louisiana_options_4_4");
        question("Questions.louisiana_ask_4", 2);

        setOptions("Questions.louisiana_options_5_1", "Questions.louisiana_options_5_2");
        askEval("Questions.louisiana_ask_5", 0, 0);

        endGame(3);
    }

    private void newMexico() {
        setOptions("Questions.newMexico_options_1_1", "Questions.newMexico_options_1_2");
        ask("Questions.newMexico_ask_1_1", "Questions.newMexico_ask_1_2", 0, 1);

        setOptions("Questions.newMexico_options_2_1", "Questions.newMexico_options_2_2",
                "Questions.newMexico_options_2_3", "Questions.newMexico_options_2_4");
        question("Questions.newMexico_ask_2", 3);

        setOptions("Questions.newMexico_options_3_1", "Questions.newMexico_options_3_2",
                "Questions.newMexico_options_3_3", "Questions.newMexico_options_3_4");
        question("Questions.newMexico_ask_3", 1);

        setOptions("Questions.newMexico_options_4_1", "Questions.newMexico_options_4_2",
                "Questions.newMexico_options_4_3", "Questions.newMexico_options_4_4");
        question("Questions.newMexico_ask_4", 1);

        setOptions("Questions.newMexico_options_5_1", "Questions.newMexico_options_5_2");
        askEval("Questions.newMexico_ask_5", 0, 0);

        endGame(3);
    }

    private void northDakota() {
        setOptions("Questions.northDakota_options_1_1", "Questions.northDakota_options_1_2");
        ask("Questions.northDakota_ask_1_1", "Questions.northDakota_ask_1_2", 0, 1);

        setOptions("Questions.northDakota_options_2_1", "Questions.northDakota_options_2_2",
                "Questions.northDakota_options_2_3", "Questions.northDakota_options_2_4");
        question("Questions.northDakota_ask_2", 1);

        setOptions("Questions.northDakota_options_3_1", "Questions.northDakota_options_3_2",
                "Questions.northDakota_options_3_3", "Questions.northDakota_options_3_4");
        question("Questions.northDakota_ask_3", 3);

        setOptions("Questions.northDakota_options_4_1", "Questions.northDakota_options_4_2",
                "Questions.northDakota_options_4_3", "Questions.northDakota_options_4_4");
        question("Questions.northDakota_ask_4", 0);

        setOptions("Questions.northDakota_options_5_1", "Questions.northDakota_options_5_2");
        askEval("Questions.northDakota_ask_5", 0, 0);

        endGame(3);
    }

    private void utah() {
        setOptions("Questions.utah_options_1_1", "Questions.utah_options_1_2");
        ask("Questions.utah_ask_1_1", "Questions.utah_ask_1_2", 0, 1);

        setOptions("Questions.utah_options_2_1", "Questions.utah_options_2_2",
                "Questions.utah_options_2_3", "Questions.utah_options_2_4");
        question("Questions.utah_ask_2_1", "Questions.utah_ask_2_2", 0);

        setOptions("Questions.utah_options_3_1", "Questions.utah_options_3_2",
                "Questions.utah_options_3_3", "Questions.utah_options_3_4");
        question("Questions.utah_ask_3", 2);

        setOptions("Questions.utah_options_4_1", "Questions.utah_options_4_2",
                "Questions.utah_options_4_3", "Questions.utah_options_4_4");
        question("Questions.utah_ask_4", 3);

        setOptions("Questions.utah_options_5_1", "Questions.utah_options_5_2",
                "Questions.utah_options_5_3", "Questions.utah_options_5_4");
        question("Questions.utah_ask_5", 1);

        setOptions("Questions.utah_options_6_1", "Questions.utah_options_6_2");
        askEval("Questions.utah_ask_6", 0, 0);

        endGame(4);
    }

    private void setOptions(String... options) {
        for (int i = 0; i < options.length; i++) {
            options[i] = TrumpWillTriumph.RESOURCE.getString(options[i]);
        }
        this.options = options;
    }

    private void ask(String text, int... points) {
        final int index = TrumpWillTriumph.customDialog(options, text);
        score += points[index];
    }

    private void ask(String text_1, String text_2, int... points) {
        final int index = TrumpWillTriumph.customDialog(options, text_1, text_2);
        score += points[index];
    }

    private void askEval(String text, int... points) {
        final int index = TrumpWillTriumph.customDialogIgnoreFirst(options, answer, text);
        score += points[index];
    }

    private void question(String text, int answerIndex) {
        final int userIndex;
        if (answer.isBlank()) {
            userIndex = TrumpWillTriumph.customDialog(options, text);
        } else {
            userIndex = TrumpWillTriumph.customDialogIgnoreFirst(options, answer, text);
        }
        question(userIndex, answerIndex);
    }

    private void question(String text_1, String text_2, int answerIndex) {
        final int userIndex;
        if (answer.isBlank()) {
            userIndex = TrumpWillTriumph.customDialog(options, text_1, text_2);
        } else {
            userIndex = TrumpWillTriumph.customDialogIgnoreFirst(options, answer, text_1, text_2);
        }
        question(userIndex, answerIndex);
    }

    private void question(int userIndex, int answerIndex) {
        if (userIndex == answerIndex) {
            answer = TrumpWillTriumph.RESOURCE.getString("Questions.correct");
            score++;
        } else {
            answer = TrumpWillTriumph.RESOURCE.getString("Questions.incorrect") + " " + options[answerIndex];
        }
    }

    private void endGame(int scoreToWin) {
        if (score >= scoreToWin) {
            TrumpWillTriumph.win();
        } else {
            TrumpWillTriumph.lose();
        }
    }
}
