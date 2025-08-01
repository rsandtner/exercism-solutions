import static java.util.stream.Collectors.joining;

import java.util.stream.IntStream;

class House {

    private static final String[] VERSES = { 
        "the house that Jack built.",
        "the malt that lay in",
        "the rat that ate",
        "the cat that killed",
        "the dog that worried",
        "the cow with the crumpled horn that tossed",
        "the maiden all forlorn that milked",
        "the man all tattered and torn that kissed",
        "the priest all shaven and shorn that married",
        "the rooster that crowed in the morn that woke",
        "the farmer sowing his corn that kept",
        "the horse and the hound and the horn that belonged to",
    };

    String verse(final int verse) {
        return verse("This is", verse);
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

        return verse(rhyme + ' ' +  VERSES[verse-1], verse-1);
    }

}