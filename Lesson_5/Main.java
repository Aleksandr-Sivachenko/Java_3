import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        FuelStation fuelStation = new FuelStation();

        ExecutorService executorService = Executors.newFixedThreadPool(10);


//        executorService.submit(new Car("1-car", fuelStation));
//        executorService.submit(new Car("2-car", fuelStation));
//        executorService.submit(new Car("3-car", fuelStation));
//        executorService.submit(new Car("4-car", fuelStation));
//        executorService.submit(new Car("5-car", fuelStation));
//
//        executorService.submit(new Truck("1-truck", fuelStation));
//        executorService.submit(new Truck("2-truck", fuelStation));
//        executorService.submit(new Truck("3-truck", fuelStation));
//        executorService.submit(new Truck("4-truck", fuelStation));
//        executorService.submit(new Truck("5-truck", fuelStation));

        executorService.submit(new Bus("1-Bus", fuelStation));
        executorService.submit(new Bus("2-Bus", fuelStation));
        executorService.submit(new Bus("3-Bus", fuelStation));
        executorService.submit(new Bus("4-Bus", fuelStation));
        executorService.submit(new Bus("5-Bus", fuelStation));


        executorService.shutdown();
    }
}
