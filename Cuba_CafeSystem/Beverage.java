/**
 * Represents a drink sold at the campus cafe.
 * The price depends on the selected size.
 *
 * @author Nelven
 * @version 1.0
 */
public class Beverage extends MenuItem {
    private static final double MEDIUM_EXTRA = 15.0;
    private static final double LARGE_EXTRA = 25.0;

    private String size;

    /**
     * Default constructor: a small, unnamed beverage.
     */
    public Beverage() {
        super();
        this.size = "S";
    }

    /**
     * Parameterized constructor.
     *
     * @param name      the drink name
     * @param basePrice the price of the small size in pesos
     * @param itemCode  the item code
     * @param size      the size: "S", "M", or "L"
     */
    public Beverage(String name, double basePrice, String itemCode, String size) {
        super(name, basePrice, itemCode);
        this.size = "S"; // default, in case the given size is invalid
        setSize(size);
    }

    /**
     * Computes the price based on size.
     *
     * @return the price of this beverage in pesos
     */
    @Override
    public double computePrice() {
        // Large adds 25, Medium adds 15, Small uses the base price
        if (size.equals("L")) {
            return basePrice + LARGE_EXTRA;
        } else if (size.equals("M")) {
            return basePrice + MEDIUM_EXTRA;
        } else {
            return basePrice;
        }
    }

    /**
     * Adds the size to the parent's description.
     *
     * @return the description including the size
     */
    @Override
    public String getDescription() {
        return super.getDescription() + " Size: " + size;
    }

    /**
     * @return the size ("S", "M", or "L")
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets the size. Only "S", "M", or "L" are accepted; otherwise the old value stays.
     *
     * @param size the new size
     */
    public void setSize(String size) {
        // Accept only the three valid sizes
        if (size != null && (size.equals("S") || size.equals("M") || size.equals("L"))) {
            this.size = size;
        }
    }
}
