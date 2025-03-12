import java.util.Scanner;

class Order {
    private int orderId;
    private int customerId;
    private String orderDate;
    private float totalAmount;
    private String status;

    public Order(int orderId, int customerId, String orderDate, float totalAmount, String status) {
        if (orderId <= 0 || customerId <= 0) 
            throw new IllegalArgumentException("Order ID and Customer ID must be positive.");
        if (totalAmount < 0) 
            throw new IllegalArgumentException("Total amount cannot be negative.");
        if (orderDate.isEmpty() || status.isEmpty()) 
            throw new IllegalArgumentException("Fields cannot be empty.");
        
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public void displayDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Total Amount: " + totalAmount);
        System.out.println("Status: " + status);
    }
}

public class Lab7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter Order ID: ");
            int orderId = scanner.nextInt();
            
            System.out.print("Enter Customer ID: ");
            int customerId = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter Order Date (YYYY-MM-DD): ");
            String orderDate = scanner.nextLine();
            
            System.out.print("Enter Total Amount: ");
            float totalAmount = scanner.nextFloat();
            scanner.nextLine();
            
            System.out.print("Enter Order Status: ");
            String status = scanner.nextLine();
            
            Order order = new Order(orderId, customerId, orderDate, totalAmount, status);
            System.out.println("\nOrder Details:");
            order.displayDetails();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error occurred.");
        } finally {
            scanner.close();
        }
    }
}