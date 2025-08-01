import static java.util.stream.Collectors.joining;

import java.util.stream.IntStream;

class House {

    private static final Verse[] VERSES = { 
        new Verse("lay in", "the house that Jack built."),
        new Verse("ate", "the malt"), 
        new Verse("killed", "the rat"), 
        new Verse("worried", "the cat"),
        new Verse("tossed", "the dog"), 
        new Verse("milked", "the cow with the crumpled horn"),
        new Verse("kissed", "the maiden all forlorn"), 
        new Verse("married", "the man all tattered and torn"),
        new Verse("woke", "the priest all shaven and shorn"),
        new Verse("kept", "the rooster that crowed in the morn"),
        new Verse("belonged to", "the farmer sowing his corn"),
        new Verse("", "the horse and the hound and the horn"), 
    };

    String verse(final int verse) {
        return verse(null, verse);
    }

    String verses(final int start, final int end) {

        return IntStream.rangeClosed(start, end)
                        .mapToObj(this::verse)
                        .collect(joining(System.lineSeparator()));
    }

    String sing() {
        return verses(1, VERSES.length);
    }

    private static String verse(final String rhyme, final int verse) {
        if (verse == 0) {
            return rhyme;
        }

        var theVerse = VERSES[verse-1];

        String actualRhyme = rhyme;
        if (actualRhyme == null) {
            actualRhyme = "This is";
        } else {
            actualRhyme += " that " + theVerse.prefix;
        }

        return verse(actualRhyme + ' ' +  theVerse.verse, verse-1);
    }

    private static class Verse {
        private final String prefix;
        private final String verse;

        private Verse(final String prefix, final String verse) {
            this.prefix = prefix;
            this.verse = verse;
        }
    }

}