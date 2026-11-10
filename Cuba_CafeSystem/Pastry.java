/**
 * Represents a baked item that can be warmed for an extra fee.
 *
 * @author Nelven
 * @version 1.0
 */
public class Pastry extends MenuItem {
    private static final double WARM_FEE = 10.0;

    private boolean warmed;

    /**
     * Default constructor: an unnamed pastry that is not warmed.
     */
    public Pastry() {
        super();
        this.warmed = false;
    }

    /**
     * Parameterized constructor.
     *
     * @param name      the pastry name
     * @param basePrice the price in pesos
     * @param itemCode  the item code
     * @param warmed    true if the pastry is warmed
     */
    public Pastry(String name, double basePrice, String itemCode, boolean warmed) {
        super(name, basePrice, itemCode);
        this.warmed = warmed;
    }

    /**
     * Computes the price, adding the warming fee if needed.
     *
     * @return the price of this pastry in pesos
     */
    @Override
    public double computePrice() {
        double price = basePrice;
        // Warmed pastries cost 10 pesos more
        if (warmed) {
            price += WARM_FEE;
        }
        return price;
    }

    /**
     * Adds "(Warmed)" to the parent's description when applicable.
     *
     * @return the description of this pastry
     */
    @Override
    public String getDescription() {
        String description = super.getDescription();
        // Show the warmed status only when it applies
        if (warmed) {
            description += " (Warmed)";
        }
        return description;
    }

    /**
     * @return true if the pastry is warmed
     */
    public boolean isWarmed() {
        return warmed;
    }

    /**
     * @param warmed true if the pastry should be warmed
     */
    public void setWarmed(boolean warmed) {
        this.warmed = warmed;
    }
}
