import java.util.Scanner;

class Supplier {
    private int supplierId;
    private String companyName;
    private String contactPerson;
    private String contactNumber;
    private String email;

    public Supplier(int supplierId, String companyName, String contactPerson, String contactNumber, String email) {
        this.supplierId = supplierId;
        this.companyName = companyName;
        this.contactPerson = contactPerson;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    public void displayDetails() {
        System.out.println("Supplier ID: " + supplierId);
        System.out.println("Company Name: " + companyName);
        System.out.println("Contact Person: " + contactPerson);
        System.out.println("Contact Number: " + contactNumber);
        System.out.println("Email: " + email);
    }

    public void stringFunctions() {
        System.out.println("Uppercase Company Name: " + companyName.toUpperCase());
        System.out.println("Lowercase Contact Person: " + contactPerson.toLowerCase());
        System.out.println("Company Name Length: " + companyName.length());
        System.out.println("Email Contains '@': " + email.contains("@"));
        System.out.println("Contact Number Starts With '+': " + contactNumber.startsWith("+"));
        System.out.println("Substring of Company Name (First 3 chars): " + companyName.substring(0, 3));
    }

    public void stringBufferFunctions() {
        StringBuffer sb = new StringBuffer(companyName);
        sb.append(" Pvt Ltd");
        System.out.println("Appended Company Name: " + sb);
        sb.insert(0, "The ");
        System.out.println("Inserted Text: " + sb);
        sb.replace(4, 11, "Best");
        System.out.println("Replaced Text: " + sb);
        sb.delete(4, 9);
        System.out.println("Deleted Part: " + sb);
        sb.reverse();
        System.out.println("Reversed Name: " + sb);
        sb.reverse();
    }
}

public class Lab6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Supplier ID: ");
        int supplierId = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter Company Name: ");
        String companyName = scanner.nextLine();
        
        System.out.print("Enter Contact Person: ");
        String contactPerson = scanner.nextLine();
        
        System.out.print("Enter Contact Number: ");
        String contactNumber = scanner.nextLine();
        
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        
        Supplier supplier = new Supplier(supplierId, companyName, contactPerson, contactNumber, email);
        
        System.out.println("\nSupplier Details:");
        supplier.displayDetails();
        
        System.out.println("\nString Functions:");
        supplier.stringFunctions();
        
        System.out.println("\nStringBuffer Functions:");
        supplier.stringBufferFunctions();
        
        scanner.close();
    }
}
