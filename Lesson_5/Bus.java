public class Bus implements Runnable{
    private String plate;
    private final float capacity = 40f;
    private float size = 40f;
    private float consumption = 7.5f;
    private FuelStation fuelStation;

    public Bus(String plate, FuelStation fuelStation) {
        this.plate = plate;
        this.fuelStation = fuelStation;
    }

    public void drive() {
        System.out.println(String.format("[%s] в пути...", plate));
        try {
            while (size > 8) {
                Thread.sleep(3000);
                size -= consumption;
                System.out.println(String.format("[%s] оставшееся топливо %s ...", plate, size));
            }

            System.out.println(String.format("[%s] не хватает топлива %s ...", plate, size));
            float refuel = fuelStation.refuel(capacity - size);
            if (refuel == 0F) {
                System.out.println(String.format("[%s] застрял без топлива ...", plate));
                return;
            }
            size += refuel;
            drive();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        drive();
    }
}
