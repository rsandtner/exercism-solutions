public class JedliksToyCar {

    private int soc = 100;
    private int metersDriven;

    public static JedliksToyCar buy() {
        return new JedliksToyCar();
    }

    public String distanceDisplay() {
        return "Driven " + metersDriven + " meters";
    }

    public String batteryDisplay() {
        if (emptyBattery()) {
            return "Battery empty";
        }
        return "Battery at " + soc + "%";
    }

    public void drive() {
        if (emptyBattery()) {
            return;
        }
        soc -= 1;
        metersDriven += 20;
    }

    private boolean emptyBattery() {
        return soc == 0;
    }
}
