/**
 * Represents a rice meal that can be upsized and given extra sides.
 *
 * @author Nelven
 * @version 1.0
 */
public class Meal extends MenuItem {
    private static final double UPSIZE_FEE = 20.0;
    private static final double EXTRA_SIDE_PRICE = 12.0;

    private boolean upsized;
    private int extraSides;

    /**
     * Default constructor: an unnamed regular meal with no extra sides.
     */
    public Meal() {
        super();
        this.upsized = false;
        this.extraSides = 0;
    }

    /**
     * Parameterized constructor.
     *
     * @param name       the meal name
     * @param basePrice  the price in pesos
     * @param itemCode   the item code
     * @param upsized    true if the meal is upsized
     * @param extraSides the number of extra sides (must not be negative)
     */
    public Meal(String name, double basePrice, String itemCode, boolean upsized, int extraSides) {
        super(name, basePrice, itemCode);
        this.upsized = upsized;
        setExtraSides(extraSides);
    }

    /**
     * Computes the price: base price + 20 if upsized + 12 per extra side.
     *
     * @return the price of this meal in pesos
     */
    @Override
    public double computePrice() {
        double price = basePrice;
        // Upsizing adds a flat fee
        if (upsized) {
            price += UPSIZE_FEE;
        }
        price += EXTRA_SIDE_PRICE * extraSides;
        return price;
    }

    /**
     * Adds the upsize status and number of extra sides to the parent's description.
     *
     * @return the description of this meal
     */
    @Override
    public String getDescription() {
        String status;
        // Pick the label for the meal size
        if (upsized) {
            status = "Upsized";
        } else {
            status = "Regular";
        }
        String sides;
        // Use singular "side" only when there is exactly one
        if (extraSides == 1) {
            sides = extraSides + " side";
        } else {
            sides = extraSides + " sides";
        }
        return super.getDescription() + " " + status + ", " + sides;
    }

    /**
     * @return true if the meal is upsized
     */
    public boolean isUpsized() {
        return upsized;
    }

    /**
     * @param upsized true if the meal should be upsized
     */
    public void setUpsized(boolean upsized) {
        this.upsized = upsized;
    }

    /**
     * @return the number of extra sides
     */
    public int getExtraSides() {
        return extraSides;
    }

    /**
     * Sets the number of extra sides. Negative values are rejected.
     *
     * @param extraSides the new number of extra sides
     */
    public void setExtraSides(int extraSides) {
        // A negative count makes no sense, so keep the old value
        if (extraSides >= 0) {
            this.extraSides = extraSides;
        } else {
            System.out.println("Error: extra sides cannot be negative.");
        }
    }
}
