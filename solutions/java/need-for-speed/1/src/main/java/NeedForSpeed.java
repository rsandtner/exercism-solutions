class NeedForSpeed {

    private final int speed;
    private final int batteryDrain;

    private int distance;
    private int soc;

    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;

        this.soc = 100;
    }

    public boolean batteryDrained() {
        return soc < batteryDrain;
    }

    public int distanceDriven() {
        return distance;
    }

    public void drive() {
        if (soc < batteryDrain) {
            return;
        }

        soc -= batteryDrain;
        distance += speed;
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {

    private final int distance;

    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
        while (car.distanceDriven() < distance && !car.batteryDrained()) {
            car.drive();
        }

        return car.distanceDriven() >= distance;
    }
}
