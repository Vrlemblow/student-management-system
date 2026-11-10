/**
 * Represents the person placing an order. Students get a discount,
 * and every customer earns loyalty points.
 *
 * @author Nelven
 * @version 1.0
 */
public class Customer {
    private static final double PESOS_PER_POINT = 50.0;

    private String name;
    private boolean student;
    private int loyaltyPoints;

    /**
     * Default constructor: a guest who is not a student.
     */
    public Customer() {
        this.name = "Guest";
        this.student = false;
        this.loyaltyPoints = 0;
    }

    /**
     * Creates a non-student customer with a name.
     *
     * @param name the customer name
     */
    public Customer(String name) {
        this();
        setName(name);
    }

    /**
     * Creates a customer with a name and student status.
     *
     * @param name    the customer name
     * @param student true if the customer is a student
     */
    public Customer(String name, boolean student) {
        this(name);
        this.student = student;
    }

    /**
     * Adds loyalty points directly. Negative amounts are rejected.
     *
     * @param points the number of points to add
     */
    public void addPoints(int points) {
        // Only positive points can be added
        if (points >= 0) {
            loyaltyPoints += points;
        } else {
            System.out.println("Error: points cannot be negative.");
        }
    }

    /**
     * Adds loyalty points based on money spent: 1 point for every 50 pesos.
     *
     * @param amountSpent the amount spent in pesos
     */
    public void addPoints(double amountSpent) {
        // Ignore negative amounts; otherwise convert pesos to whole points
        if (amountSpent >= 0) {
            loyaltyPoints += (int) (amountSpent / PESOS_PER_POINT);
        } else {
            System.out.println("Error: amount spent cannot be negative.");
        }
    }

    /**
     * @return the customer name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the customer name. Empty names are rejected.
     *
     * @param name the new name
     */
    public void setName(String name) {
        // Reject null or blank names and keep the old value
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Error: customer name cannot be empty.");
        }
    }

    /**
     * @return true if the customer is a student
     */
    public boolean isStudent() {
        return student;
    }

    /**
     * @param student true if the customer is a student
     */
    public void setStudent(boolean student) {
        this.student = student;
    }

    /**
     * @return the current loyalty points
     */
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    /**
     * Sets the loyalty points. Negative values are rejected.
     *
     * @param loyaltyPoints the new number of points
     */
    public void setLoyaltyPoints(int loyaltyPoints) {
        // Points can never be negative
        if (loyaltyPoints >= 0) {
            this.loyaltyPoints = loyaltyPoints;
        } else {
            System.out.println("Error: loyalty points cannot be negative.");
        }
    }
}
