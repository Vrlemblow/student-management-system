 /** 
 * Main class that drives the campus cafe ordering program.
 * @author Nelven
 * @version 1.0
 */
public class CafeApp {

    /**
     * Program entry point. Creates customers, items, and orders, then prints receipts.
     
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Customers made with different constructors
        Customer bea = new Customer("Beatrice", true);
        Customer marx = new Customer("Marx Larp");

        // Items made with parameterized constructors
        Beverage latte = new Beverage("Iced Latte", 95.0, "B-01", "L");
        Pastry ensaymada = new Pastry("Ensaymada", 45.0, "P-01", true);
        Meal adobo = new Meal("Chicken Adobo", 110.0, "M-01", true, 1);

        // Pastry made with the default constructor, then filled in with setters
        Pastry cookie = new Pastry();
        cookie.setName("Cookie");
        cookie.setItemCode("P-02");
        cookie.setBasePrice(35.0);

        // Order 1: three items fit, the fourth is rejected
        Order order1 = new Order("1001", bea);
        order1.addItem(latte);
        order1.addItem(ensaymada);
        order1.addItem(adobo);
        order1.addItem(cookie); // shows the limit check
        order1.printReceipt();

        System.out.println();

        // Beverage and Meal made with default constructors, then filled in with setters
        Beverage cocoa = new Beverage();
        cocoa.setName("Hot Chocolate");
        cocoa.setItemCode("B-02");
        cocoa.setBasePrice(-5);  // rejected: negative price
        cocoa.setBasePrice(80);  // accepted
        cocoa.setSize("M");

        Meal tapa = new Meal();
        tapa.setName("Beef Tapa");
        tapa.setItemCode("M-02");
        tapa.setBasePrice(130.0);

        // Order 2: with a 20 peso voucher
        Order order2 = new Order("1002", marx);
        order2.addItem(cocoa);
        order2.addItem(tapa);
        order2.printReceipt(20.0);
    }
}
