public class Truck implements Runnable{
    private String plate;
    private final float capacity = 60f;
    private float size = 60f;
    private float consumption = 15f;
    private FuelStation fuelStation;

    public Truck(String plate, FuelStation fuelStation) {
        this.plate = plate;
        this.fuelStation = fuelStation;
    }

    public void drive() {
        System.out.println(String.format("[%s] is on the road...", plate));
        try {
            while (size > 16) {
                Thread.sleep(3000);
                size -= consumption;
                System.out.println(String.format("[%s] remaining fuel %s ...", plate, size));
            }

            System.out.println(String.format("[%s] has not enough fuel %s ...", plate, size));
            float refuel = fuelStation.refuel(capacity - size);
            if (refuel == 0F) {
                System.out.println(String.format("[%s] is stuck without fuel ...", plate));
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
