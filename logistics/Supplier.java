package logistics;
import java.util.Scanner;

// Supplier Class Implementing Interface
public class Supplier implements Manageable {
    private int supplierId;
    private String companyName;
    private String contactPerson;
    private String contactNumber;
    private String email;

    // Constructor
    public Supplier(int supplierId, String companyName, String contactPerson, String contactNumber, String email) {
        this.supplierId = supplierId;
        this.companyName = companyName;
        this.contactPerson = contactPerson;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    // Implementing Interface Method
    public void displayDetails() {
        System.out.println("Supplier ID: " + supplierId);
        System.out.println("Company Name: " + companyName);
        System.out.println("Contact Person: " + contactPerson);
        System.out.println("Contact Number: " + contactNumber);
        System.out.println("Email: " + email);
    }

}
