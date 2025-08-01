public class CarsAssemble {

    private static final int CARS_PER_HOUR = 221;

    public double productionRatePerHour(int speed) {
        var successRate = switch (speed) {
            case 0, 1, 2, 3, 4 -> 1.0;
            case 5, 6, 7, 8 -> .9;
            case 9 -> .8;
            case 10 -> .77;
            default -> throw new IllegalArgumentException("speed " + speed + " not supported");
        };

        return CARS_PER_HOUR * speed * successRate;
    }

    public int workingItemsPerMinute(int speed) {
        return (int) productionRatePerHour(speed) / 60;
    }
}
