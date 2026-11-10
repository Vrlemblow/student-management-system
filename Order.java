/**
Connects a Customer to up to three MenuItem objects.
 * Items are stored in separate fields (no arrays or collections).
 *
 * @author Nelven
 * @version 1.0
 */
public class Order {
    private static final double STUDENT_DISCOUNT_RATE = 0.10;

    private Customer customer;
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;
    private int itemCount;
    private String orderId;

    /**
     * Creates an empty order for a customer.
     *
     * @param orderId  the order number
     * @param customer the customer placing the order
     */
    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.itemCount = 0;
    }

    /**
     * Adds an item to the first empty slot.
     *
     * @param item the menu item to add
     * @return true if the item was added, false if the order is already full
     */
    public boolean addItem(MenuItem item) {
        // Reject a missing item
        if (item == null) {
            System.out.println("Error: no item to add.");
            return false;
        }
        // Place the item in the first empty slot
        if (item1 == null) {
            item1 = item;
        } else if (item2 == null) {
            item2 = item;
        } else if (item3 == null) {
            item3 = item;
        } else {
            // All three slots are taken
            System.out.println("Order is full. Cannot add " + item.getName()
                    + " [" + item.getItemCode() + "].");
            return false;
        }
        itemCount++;
        return true;
    }

    /**
     * Sums the price of every item in the order (polymorphic calls).
     *
     * @return the subtotal in pesos
     */
    public double computeSubtotal() {
        double subtotal = 0.0;
        // Add each slot only if it holds an item
        if (item1 != null) {
            subtotal += item1.computePrice();
        }
        if (item2 != null) {
            subtotal += item2.computePrice();
        }
        if (item3 != null) {
            subtotal += item3.computePrice();
        }
        return subtotal;
    }

    /**
     * Computes the total, applying a 10% discount for students.
     *
     * @return the total in pesos
     */
    public double computeTotal() {
        double subtotal = computeSubtotal();
        // Students get 10% off
        if (customer != null && customer.isStudent()) {
            return subtotal - (subtotal * STUDENT_DISCOUNT_RATE);
        } else {
            return subtotal;
        }
    }

    /**
     * Computes the total after the student discount and a voucher.
     * The total never goes below 0.
     *
     * @param voucher the voucher amount in pesos
     * @return the total in pesos
     */
    public double computeTotal(double voucher) {
        double total = computeTotal();
        // Ignore negative vouchers
        if (voucher > 0) {
            total -= voucher;
        }
        // The total may never go below 0
        if (total < 0) {
            total = 0.0;
        }
        return total;
    }

    /**
     * Prints the receipt without a voucher.
     */
    public void printReceipt() {
        printReceipt(0.0);
    }

    /**
     * Prints the receipt with a voucher and updates the customer's loyalty points.
     *
     * @param voucher the voucher amount in pesos (0 for none)
     */
    public void printReceipt(double voucher) {
        System.out.println("Order #" + orderId + " - " + customer.getName()
                + (customer.isStudent() ? " (Student)" : ""));

        // Print each item that exists
        if (item1 != null) {
            System.out.printf("    %s: .............. %.2f%n", item1.getDescription(), item1.computePrice());
        }
        if (item2 != null) {
            System.out.printf("    %s: ................ %.2f%n", item2.getDescription(), item2.computePrice());
        }
        if (item3 != null) {
            System.out.printf("    %s: ..... %.2f%n", item3.getDescription(), item3.computePrice());
        }

        double subtotal = computeSubtotal();
        System.out.printf("    Subtotal: %.2f%n", subtotal);

        // Show the discount line only for students
        if (customer.isStudent()) {
            System.out.printf("    Student discount (10%%): -%.2f%n", subtotal * STUDENT_DISCOUNT_RATE);
        }
        // Show the voucher line only when a voucher is used
        if (voucher > 0) {
            System.out.printf("    Voucher: -%.2f%n", voucher);
        }

        double total = computeTotal(voucher);
        System.out.printf("    TOTAL: %.2f%n", total);

        // Object interaction: the order updates the customer's points
        customer.addPoints(total);
        System.out.println("    Loyalty points: " + customer.getLoyaltyPoints());
    }

    /**
     * @return the customer of this order
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the customer. A missing customer is rejected.
     *
     * @param customer the new customer
     */
    public void setCustomer(Customer customer) {
        // An order must always have a customer
        if (customer != null) {
            this.customer = customer;
        } else {
            System.out.println("Error: customer cannot be null.");
        }
    }

    /**
     * @return the first item, or null if empty
     */
    public MenuItem getItem1() {
        return item1;
    }

    /**
     * @return the second item, or null if empty
     */
    public MenuItem getItem2() {
        return item2;
    }

    /**
     * @return the third item, or null if empty
     */
    public MenuItem getItem3() {
        return item3;
    }

    /**
     * @return the number of items in the order
     */
    public int getItemCount() {
        return itemCount;
    }

    /**
     * @return the order number
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Sets the order number. Empty values are rejected.
     *
     * @param orderId the new order number
     */
    public void setOrderId(String orderId) {
        // Reject null or blank order numbers
        if (orderId != null && !orderId.trim().isEmpty()) {
            this.orderId = orderId;
        } else {
            System.out.println("Error: order id cannot be empty.");
        }
    }
}