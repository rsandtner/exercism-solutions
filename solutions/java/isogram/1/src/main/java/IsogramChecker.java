import java.util.HashSet;
import java.util.function.IntPredicate;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        return phrase.chars()
                     .filter(Character::isAlphabetic)
                     .noneMatch(isAlreadySeen());
    }

    private static IntPredicate isAlreadySeen() {
        var seen = new HashSet<Integer>();
        return i -> !seen.add(Character.toLowerCase(i));
    }
}
