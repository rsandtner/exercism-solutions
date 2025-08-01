import java.util.stream.IntStream;

class Scrabble {

    private final int score;

    Scrabble(String word) {
        this.score = calculate(word);
    }

    int getScore() {
        return score;
    }

    private static int calculate(final String word) {

        if (word == null || word.isEmpty()) {
            return 0;
        }

        var upper = word.toUpperCase();
        return IntStream.range(0, word.length())
                        .map(upper::charAt)
                        .map(Scrabble::characterScore)
                        .sum();
    }

    private static int characterScore(final int c) {
        return switch (c) {
            case 'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T' -> 1;
            case 'D', 'G' -> 2;
            case 'B', 'C', 'M', 'P' -> 3;
            case 'F', 'H', 'V', 'W', 'Y' -> 4;
            case 'K' -> 5;
            case 'J', 'X' -> 8;
            case 'Q', 'Z' -> 10;
            default -> 0;
        };
    }

}
