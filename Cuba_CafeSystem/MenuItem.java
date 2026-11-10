/**
 * Abstract parent of every item sold at the campus cafe.
 * Each subclass decides how its own price is computed.import 
 
 * @author Nelven
 * @version 1.0
 */
public abstract class MenuItem {
    protected String name;
    protected double basePrice;
    private String itemCode;

    /**
     * Default constructor: creates an unnamed item with no price.
     */
    public MenuItem() {
        this.name = "Unnamed Item";
        this.basePrice = 0.0;
        this.itemCode = "N/A";
    }

    /**
     * Parameterized constructor. Values are checked by the setters.
     *
     * @param name      the item name
     * @param basePrice the starting price in pesos
     * @param itemCode  the unique item code, e.g. "B-01"
     */
    public MenuItem(String name, double basePrice, String itemCode) {
        this(); // start from the safe default values
        setName(name);
        setBasePrice(basePrice);
        setItemCode(itemCode);
    }

    /**
     * Computes the final price of this item. Every subclass defines its own rule.
     *
     * @return the price in pesos
     */
    public abstract double computePrice();

    /**
     * This Gives a short description of the item.
     *
     * @return the name followed by the item code
     */
    public String getDescription() {
        return name + " [" + itemCode + "]";
    }

    /**
     * @return the item name
     */
     
    public String getName() {
        return name;
    }

    /**
     * Sets the item name. Empty names are rejected.
     *
     * @param name the new name
     */
    public void setName(String name) {
        // Reject null or blank names and keep the old value
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Error: name cannot be empty.");
        }
    }

    /**
     * @return the base price in pesos
     */
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * Sets the base price. Negative values are rejected.
     *
     * @param basePrice the new base price in pesos
     */
    public void setBasePrice(double basePrice) {
        // A price below 0 is invalid, so print an error and keep the old price
        if (basePrice >= 0) {
            this.basePrice = basePrice;
        } else {
            System.out.println("Error: base price cannot be negative.");
        }
    }

    /**
     * @return the item code
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * Sets the item code. Empty codes are rejected.
     *
     * @param itemCode the new item code
     */
    public void setItemCode(String itemCode) {
        // Reject null or blank codes and keep the old value
        if (itemCode != null && !itemCode.trim().isEmpty()) {
            this.itemCode = itemCode;
        } else {
            System.out.println("Error: item code cannot be empty.");
        }
    }
}
