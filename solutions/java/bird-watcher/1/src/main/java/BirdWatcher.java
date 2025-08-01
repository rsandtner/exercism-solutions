import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class BirdWatcher {

    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return birdsPerDay.clone();
    }

    public int getToday() {
        return birdsPerDay[birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length - 1]++;
    }

    public boolean hasDayWithoutBirds() {
        return IntStream.of(birdsPerDay).anyMatch(count -> count == 0);
    }

    public int getCountForFirstDays(int numberOfDays) {
        return IntStream.of(birdsPerDay)
            .limit(numberOfDays)
            .sum();
    }

    public int getBusyDays() {
        return (int) IntStream.of(birdsPerDay)
            .filter(count -> count > 4)
            .count();
    }
}
