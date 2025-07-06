import java.time.LocalDate;
import java.time.Month;

public class FawryTask {
    public static void main(String[] args) {
        Product cheese = new ShippableExpirableProduct("Cheese", 5, 20, LocalDate.of(2025, 7, 20), .5);
        Product biscuits = new ShippableExpirableProduct("Biscuits", 7, 20, LocalDate.of(2025, 7, 20), .7);
        Product rice = new ShippableProduct("Rice", 2.5, 20, 2.0);
        Product mobile_scratch_card = new Product("Mobile scratch cards", 6, 20);
        Cart c = new Cart();
        c.add(cheese, 2);
        c.add(biscuits, 1);
        c.add(rice, 2);
        c.add(mobile_scratch_card, 3);
        c.checkOut(new Customer(100));
    }
}
