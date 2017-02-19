package trumpwilltriump;

import javax.swing.JOptionPane;

/**
 * The user must answer as many palindrome as possible. The longer the palindrome, the more points the user gains. Once
 * the user runs out of attempts, if the user has more or equal to the require amount of points, the user wins. Else,
 * the user loses.
 */
class Palindrome {

    private static final String PALINDROME_LIBRARY[] = {"tattarrattat", "aibohphobia", "detartrated", "kinnikinnik",
            "deleveled", "evitative", "malayalam", "redivider", "releveler", "rotavator", "adinida", "deified",
            "hagigah", "murdrum", "nauruan", "peeweep", "racecar", "reifier", "repaper", "reviver", "rotator",
            "seities", "sememes", "senones", "sixaxis", "soosoos", "tacocat", "zerorez", "degged", "denned", "hallah",
            "hannah", "mallam", "marram", "pippip", "pullup", "redder", "renner", "revver", "selles", "sesses",
            "succus", "terret", "tirrit", "tuttut", "alala", "alula", "arara", "civic", "debed", "deked", "deled",
            "dered", "dewed", "dexed", "hamah", "igigi", "irori", "kaiak", "kanak", "kayak", "kazak", "kelek", "level",
            "liril", "madam", "minim", "neven", "putup", "radar", "refer", "rotor", "sagas", "semes", "seres", "sexes",
            "shahs", "sinis", "siris", "solos", "stats", "stets", "stots", "sulus", "susus", "tenet", "torot", "wakaw",
            "xanax", "acca", "adda", "affa", "alla", "anna", "beeb", "boob", "deed", "esse", "goog", "immi", "keek",
            "kook", "maam", "naan", "noon", "oppo", "otto", "peep", "poop", "sees", "toot", "aba", "aga", "aha", "ala",
            "ama", "ana", "ara", "ava", "awa", "bib", "bob", "bub", "dad", "did", "dud", "eke", "eme", "ere", "eve",
            "ewe", "eye", "gag", "gig", "gog", "hah", "heh", "huh", "mem", "mim", "mom", "mum", "nan", "non", "nun",
            "oho", "omo", "ono", "oxo", "pap", "pep", "pip", "pop", "pup", "sis", "sos", "tat", "tet", "tit", "tot",
            "tut", "vav", "waw", "wow", "yay", "zuz", "zzz", "aa", "ee", "mm", "oo", "akasaka", "glenelg", "halalah",
            "hamamah", "hararah", "ogopogo", "qaanaaq", "eleele", "serres", "aeaea", "aiaia", "anona", "ardra", "aviva",
            "capac", "kodok", "laval", "natan", "navan", "noyon", "oruro", "tebet", "tevet", "tumut", "xenex", "abba",
            "akka", "amma", "atta", "elle", "ada", "krk", "nen", "a", "lol", "aka"};

    private boolean actual, technical, used;
    private int score, tries = 3;
    private String word, correct = "";

    void palindrome() {
        doExposition();
        playEnvironment();
        miniGameDone();
    }

    private void doExposition() {
        TrumpWillTriump.displayExposition("Mr. Trump, to win you need 200 points. If the word is a palindrome\nyou "
                + "will receive the amount of letters times ten in points. The game\nends once you enter three "
                + "consecutive incorrect palindromes.");
    }

    private void playEnvironment() {
        while (tries > 0) {
            enterWord();
            retryEnterWord();
            getRidOfCasing();
            computeIfTechnicalPalindrome();
            usedOrNotEnglishWordButPalindrome();
            endRoundFeedback();
        }
    }

    private void enterWord() {
        word = JOptionPane.showInputDialog(null, "Enter a palindrome.\n" + correct + "Score: "
                + score + " points\nTries: " + tries, TrumpWillTriump.GAME_TITLE, JOptionPane.PLAIN_MESSAGE);
        exitIfWordIsNull();
    }

    private void retryEnterWord() {
        while ("".equals(word) || word.contains(" ")) {
            word = JOptionPane.showInputDialog(null, "Put in one palindrome, not two, not zero... "
                    + "ONE.\n" + correct + "Score: " + score + " points\nTries: "
                    + tries, TrumpWillTriump.GAME_TITLE, JOptionPane.PLAIN_MESSAGE);
            exitIfWordIsNull();
        }
    }

    private void exitIfWordIsNull() {
        if (word == null) {
            System.exit(0);
        }
    }

    private void getRidOfCasing() {
        word = word.toLowerCase();
    }

    private void computeIfTechnicalPalindrome() {
        technical = false;
        final int length = word.length();
        final char letter[] = new char[length];
        for (int counter = 0; counter < length; counter++) {
            letter[counter] = word.charAt(counter);
        }
        int counter = 0;
        for (int i = 0; i < (length / 2); i++) {
            if (letter[i] == letter[(length - i - 1)]) {
                i++;
            }
        }
        if (counter >= (length / 2)) {
            technical = true;
        }
    }

    private void usedOrNotEnglishWordButPalindrome() {
        actual = false;
        used = false;
        final String upper = word.toUpperCase();
        for (int i = 0; i < PALINDROME_LIBRARY.length; i++) {
            if (word.equals(PALINDROME_LIBRARY[i])) {
                actual = true;
                markPalindromeAsUsed(i);
            } else if (upper.equals(PALINDROME_LIBRARY[i])) {
                used = true;
            }
        }
    }

    private void markPalindromeAsUsed(int index) {
        PALINDROME_LIBRARY[index] = PALINDROME_LIBRARY[index].toUpperCase();
    }

    private void endRoundFeedback() {
        final int length = word.length();
        if (actual) {
            correct = "+ " + (10 * length) + " points\n";
            score += (10 * length);
            tries = 3;
        } else {
            if (used) {
                correct = "-1 Try... Palindrome already used.\n";
            } else if (technical) {
                correct = "-1 Try... Not an English word.\n";
            } else {
                correct = "-1 Try... Not a palindrome.\n";
            }
            tries--;
        }
    }

    private void miniGameDone() {
        if (score >= 200) {
            TrumpWillTriump.win();
        } else {
            TrumpWillTriump.lose();
        }
    }
}
