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
        setOptions("(Let him speak)", "(Interrupt him)");
        ask("Senior Trump, I am mexican...", 1, 0);

        setOptions("(Let him speak)", "(Interrupt him)");
        ask("I am deeply offended by your statements...", -1, 0);

        setOptions("(Let him speak)", "(Interrupt him)");
        ask("I will ask you a question...", -1, 0);

        setOptions("(Let him speak)", "(Interrupt him)");
        ask("My question is...", 1, 0);

        setOptions("Only Mexico", "No");
        ask("Would you build a wall around every state in the\nunited states to keep them safe from each other?", 2, 0);

        endGame(3);
    }

    private void illinois() {
        setOptions("Ok", "Go ahead");
        ask("Hello, Mr. Trump. I will just ask you a\nfew questions for our interview.", 0, 0);

        setOptions("Make Mexico pay", "Challenge Mexico to a game of Janga");
        ask("Mr. Trump, you have talked a lot about building a wall, realistically, how will you fund it?", 0, -1);

        setOptions("I just will", "Get good people on the job");
        ask("How will you realistically deport all the illegal immigrants?", -1, 0);

        setOptions("China", "Illegal Immigrants");
        ask("Mr. Trump, in your opinion, for what reason do you\nbelieve that our is economy failing?", 2, 1);

        endGame(1);
    }

    private void newYork() {
        setOptions("I know", "Thank you");
        ask("Hello, Mr. Trump. It is a pleasure to have you on this show.", -1, 0);

        setOptions("Build wall", "Export immigrants");
        ask("Mr. Trump, if you were to become president,\nwhat is the first thing that you would do?", -1, 0);

        setOptions("I would rebuild them!", "I was on 7/11 when it happened!");
        ask("Mr. Trump, as I'm sure you are aware of, our state is the one in which the\ntwin tower attack occurred. "
                + "What do you have to say on this matter?", 3, -1);

        setOptions("I'm really rich", "I'm almost completely self-funded");
        ask("For anybody that is on the fence, what would you say the biggest thing going for you is?", -1, 1);

        endGame(3);
    }

    private void westVirginia() {
        setOptions("Continue");
        ask("Mr. Trump, West Virginia is considered one of the least intelligent states.\nTo win their vote, just make "
                + "a YouTube video to be sponsored in their state.", 0);

        setOptions("Flashy", "Loud", "Professional");
        ask("What type of introduction would you like?", 1, 2, 0);

        setOptions("Make America Great Again", "Trump Will Triump");
        ask("What slogan do you want to use?", 2, 1);

        setOptions("Immigration", "China", "Wall");
        ask("What main topic will you to discuss?", 1, 1, 0);

        setOptions("Memorable", "Flashy", "Loud");
        ask("What conclusion would you like to use?", 1, 1, 2);

        endGame(5);
    }

    private void louisiana() {
        setOptions("Ok", "D'accord");
        ask("Mr. Trump, since Louisiana is a French state, we will ask you a\nfew questions to test if you are worth "
                + "voting for.", 0, 1);

        setOptions("Montgolfière", "Balon à air chaude", "Iritaboulis", "Balon a air chaud");
        question("How do you say 'hot air balloon' in French?", 0);

        setOptions("Poppile", "Coquelicot", "Popèle", "Aragondessieux");
        question("How do you say 'poppy' in French?", 1);

        setOptions("Conjugation", "Spelling", "Gender", "According");
        question("What error is in the following sentence: 'La dame va à le salle de bain'?", 2);

        setOptions("Merci à vous aussi", "Thank you too");
        ask(answer + "Thank you Mr. Trump, ce fut un plaisir.", 0, 0);

        endGame(3);
    }

    private void newMexico() {
        setOptions("Ok", "De acuerdo");
        ask("Mr. Trump, since New Mexico is a Spanish state, we will ask you a\nfew questions to test if you are worth "
                + "voting for.", 0, 1);

        setOptions("Groundito", "Solito", "Soloe", "Suelo");
        question("How do you say 'ground' in Spanish?", 3);

        setOptions("Nicito", "Bonito", "Niceito", "Bontatio");
        question("How do you say 'nice' in Spanish?", 1);

        setOptions("Artatilio", "Caimán", "Caimánito", "Arstitatio");
        question("How do you say 'alligator' in Spanish?", 1);

        setOptions("Gracias", "Thank you too");
        ask(answer + "Thank you Mr. Trump, fue un honor.", 0, 0);

        endGame(3);
    }

    private void northDakota() {
        setOptions("Ok", "Fortsetzen");
        ask("Mr. Trump, since North Dakota is the most German state, we\nwill ask you a few questions to test if you "
                + "are worth voting for.", 0, 1);

        setOptions("buch", "Buch", "book", "bookich");
        question("How do you say 'book' in German?", 1);

        setOptions("dutchen", "Darken", "darken", "dunkel");
        question("How do you say 'dark' in German?", 3);

        setOptions("I am good", "You are good", "I get it", "I understand");
        question("What does 'Ich bin gut' mean?", 0);

        setOptions("Danke dir auch", "Thank you too");
        ask(answer + "Thank you Mr. Trump, es war eine Freude.", 0, 0);

        endGame(3);
    }

    private void utah() {
        setOptions("Ok", "God bless America");
        ask("Mr. Trump, I am the arch-bishop of Utah, and I will ask you\na few questions to see if you are worthy "
                + "voting for.", 0, 1);

        setOptions("Raven", "Dove", "Seagle", "Eagle");
        question("In the Bible, after resting on Mount Ararat for 40 days in\nthe ark, what type of bird did Noah "
                + "first send out?", 0);

        setOptions("40 years 12 days", "12 years", "40 years", "40 days");
        question("In the Bible, how long were Moses and his followers in the desert for?", 2);

        setOptions("JNKJ", "JCKJ", "ICNR", "INRI");
        question("In the Bible, what was written above Jesus's cross when he was nailed to it?", 3);

        setOptions("Carrot", "Fruit", "Apple", "Plum");
        question("In the Bible, the eating of what is known as original sin?", 1);

        setOptions("I know", "Thank you too");
        ask(answer + "Thank you Mr. Trump, it was a pleasure.", 0, 0);

        endGame(4);
    }

    private void setOptions(String... options) {
        this.options = options;
    }

    private void ask(String text, int... points) {
        final int index = TrumpWillTriumph.customText(text, options);
        score += points[index];
    }

    private void question(String text, int answerIndex) {
        final int userIndex = TrumpWillTriumph.customText(answer + text, options);
        if (userIndex == answerIndex) {
            answer = "Correct! ";
            score++;
        } else {
            answer = "The correct answer is \"" + options[answerIndex] + "\".\n";
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
