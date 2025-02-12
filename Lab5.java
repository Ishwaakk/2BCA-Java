import logistics.*;
import java.util.*;
class Lab5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input Supplier details
        System.out.print("Enter Supplier ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Company Name: ");
        String company = scanner.nextLine();

        System.out.print("Enter Contact Person: ");
        String person = scanner.nextLine();

        System.out.print("Enter Contact Number: ");
        String number = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        // Creating a Supplier object
        Supplier supplier = new Supplier(id, company, person, number, email);
        
        System.out.println("\nSupplier Details:");
        supplier.displayDetails();
        
        scanner.close();
    }
}