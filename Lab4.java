
import java.util.Scanner;

// Base Class
abstract class Person {
    protected int id;
    protected String name;

    // Constructor
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Abstract method
    public abstract void displayDetails();
}

// Derived Class
class Customer extends Person {
    private String email;
    private String phoneNumber;
    private static int customerCount = 0;

    // Parameterised Constructor
    public Customer(int id, String name, String email, String phoneNumber) {
        super(id, name);
        this.email = email;
        this.phoneNumber = phoneNumber;
        customerCount++;
    }

    // Static method to display the tot no.of customers
    public static void displayCustomerCount() {
        System.out.println("Total Customers: " + customerCount);
    }

    // Overriding abstract method
    public void displayDetails() {
        System.out.println("Customer ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
    }

    // Final method.
    public final void updateEmail(String newEmail) {
        email = newEmail;
        System.out.println("Email updated to: " + email);
    }

}
public class Lab4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt();
	System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Customer Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Customer Phone Number: ");
        String phoneNumber = sc.nextLine();

        Customer customer = new Customer(id, name, email, phoneNumber);

        System.out.println("\nCustomer Details:");
        customer.displayDetails();

        System.out.print("\nEnter New Email: ");
        String newEmail = sc.nextLine();
        customer.updateEmail(newEmail);

        Customer.displayCustomerCount();
    }

}