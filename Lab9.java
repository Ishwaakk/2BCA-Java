import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Vehicle {
    private int vehicleId;
    private String type;

    public Vehicle(int vehicleId, String type) {
        this.vehicleId = vehicleId;
        this.type = type;
    }

    public void displayDetails() {
        System.out.println("Vehicle ID: " + vehicleId + ", Type: " + type);
    }

    public int getVehicleId() {
        return vehicleId;
    }
}

class VehicleManager {
    private HashMap<Integer, Vehicle> vehicleMap = new HashMap<>();
    private List<Vehicle> vehicleList = new ArrayList<>();

    public void addVehicle(int vehicleId, String type) {
        Vehicle vehicle = new Vehicle(vehicleId, type);
        vehicleMap.put(vehicleId, vehicle);
        vehicleList.add(vehicle);
    }

    public void displayVehicles() {
        System.out.println("Displaying from HashMap:");
        for (Vehicle vehicle : vehicleMap.values()) {
            vehicle.displayDetails();
        }

        System.out.println("\nDisplaying from ArrayList:");
        for (Vehicle vehicle : vehicleList) {
            vehicle.displayDetails();
        }
    }
}

public class Lab9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VehicleManager manager = new VehicleManager();

        System.out.print("Enter number of vehicles: ");
        int numVehicles = scanner.nextInt();

        for (int i = 0; i < numVehicles; i++) {
            System.out.print("Enter Vehicle ID: ");
            int vehicleId = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Enter Vehicle Type: ");
            String type = scanner.nextLine();
            manager.addVehicle(vehicleId, type);
        }

        manager.displayVehicles();
        scanner.close();
    }
}
