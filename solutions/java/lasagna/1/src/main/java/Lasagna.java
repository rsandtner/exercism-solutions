public class Lasagna {
    public int expectedMinutesInOven() {
        return 40;
    }

    public int remainingMinutesInOven(int cooked) {
        return expectedMinutesInOven() - cooked;
    }

    public int preparationTimeInMinutes(int layers) {
        return 2 * layers;
    }

    public int totalTimeInMinutes(int layers, int cooked) {
        return preparationTimeInMinutes(layers) + cooked;
    }

}
