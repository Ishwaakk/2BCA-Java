// Implementation of Array of Objects with Constructor and Function Overloading in Java
class Warehouse {
    private int houseId;
    private String loc;
    private float cap;
    private float currentStock;
    private String manager;


    // Default Constructor
    public Warehouse() {
        this.houseId = 0;
        this.loc = "Unknown";
        this.cap = 0.0f;
        this.currentStock = 0.0f;
        this.manager = "Not Assigned";
    }

    // Parameterized Constructor
    public Warehouse(int houseId, String loc, float cap, float currentStock, String manager) {
        this.houseId = houseId;
        this.loc = loc;
        this.cap = cap;
        this.currentStock = currentStock;
        this.manager = manager;
    }


    // to add stock
    public void addStock(float qty) {
        if (this.currentStock + qty <= this.cap) {
            this.currentStock += qty;
            System.out.println("Stock added successfully. Current stock: " + this.currentStock);
        } else {
            System.out.println("Cannot add stock. Exceeds cap.");
        }
    }

    //to add stock (overloading)
    public void addStock(float[] qty) {
        float tot = 0;
        for (float q : qty) {
            tot += q;
        }

        if (this.currentStock + tot <= this.cap) {
            this.currentStock += tot;
            System.out.println("Stock added successfully. Current stock: " + this.currentStock);
        } else {
            System.out.println("Cannot add stock. Exceeds cap.");
        }
    }

    //displays the warehouse details
    public void display() {
        System.out.println("Warehouse ID: " + houseId);
        System.out.println("loc: " + loc);
        System.out.println("Capacity: " + cap);
        System.out.println("Current Stock: " + currentStock);
        System.out.println("Manager Name: " + manager);
    }

    //main method
}

public class Lab3 {
    public static void main(String[] args) {
        //array of objects implemented;
        Warehouse[] warehouses = new Warehouse[2];
        warehouses[0] = new Warehouse(101, "New York", 5000.0f, 2500.0f, "John Doe");
        
        warehouses[1] = new Warehouse();

        warehouses[0].addStock(300.0f);
        warehouses[0].addStock(new float[]{200.0f, 150.0f});

        for (Warehouse warehouse : warehouses) {
            System.out.println("------------------------------");
            warehouse.display();
        }
    }
}