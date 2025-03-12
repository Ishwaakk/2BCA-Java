import java.util.*;

class Order implements Runnable {
    private int orderId;
    private String itemName;
    private int quantity;
    private String status;

    public Order(int orderId, String itemName, int quantity) {
        this.orderId = orderId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.status = "PENDING";
    }

    public void run() {
        processOrder();
        if (status.equals("PROCESSED")) {
            deliverOrder();
        }
    }

    private synchronized void processOrder() {
        System.out.println("\nProcessing Order #" + orderId);
        System.out.println("Item: " + itemName);
        System.out.println("Quantity: " + quantity);

        try {
            Thread.sleep(1000);
            this.status = "PROCESSED";
            System.out.println("Order #" + orderId + " processed successfully!");
        } catch (InterruptedException e) {
            System.out.println("Processing interrupted!");
            this.status = "FAILED";
        }
    }

    private void deliverOrder() {
        try {
            Thread.sleep(2000);
            this.status = "DELIVERED";
            System.out.println("Order #" + orderId + " delivered successfully!");
        } catch (InterruptedException e) {
            System.out.println("Delivery interrupted!");
            this.status = "DELIVERY_FAILED";
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }
}

public class Lab8 {
    private static int inventory = 100;
    private static final Object lock = new Object();
    private static int orderIdCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Logistics Management System ===");
        System.out.println("Current Inventory: " + inventory);
        System.out.println("===================================\n");

        try {
            while (true) {
                System.out.println("\nEnter order details (or 'exit' to quit):");
                System.out.print("Enter item name: ");
                String itemName = scanner.nextLine();

                if (itemName.equalsIgnoreCase("exit")) {
                    break;
                }

                System.out.print("Enter quantity: ");
                int quantity = Integer.parseInt(scanner.nextLine());

                synchronized (lock) {
                    if (inventory >= quantity) {
                        Order order = new Order(orderIdCounter++, itemName, quantity);
                        Thread orderThread = new Thread(order);
                        orderThread.setPriority(Thread.MAX_PRIORITY);
                        orderThread.start();

                        inventory -= quantity;
                        System.out.println("Current inventory: " + inventory);

                        try {
                            orderThread.join();
                        } catch (InterruptedException e) {
                            System.out.println("Order processing interrupted!");
                        }
                    } else {
                        System.out.println("Order failed - Insufficient inventory!");
                        System.out.println("Required: " + quantity);
                        System.out.println("Available: " + inventory);
                    }
                }

                System.out.print("\nDo you want to place another order? (yes/no): ");
                String continueOrder = scanner.nextLine();
                if (!continueOrder.equalsIgnoreCase("yes")) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid input! " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("\n=== Final System Status ===");
            System.out.println("Remaining Inventory: " + inventory);
            System.out.println("Session Ended");
        }
    }
}