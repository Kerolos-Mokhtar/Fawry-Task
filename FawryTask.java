import java.time.LocalDate;

public class FawryTask {
    public static void main(String[] args) {
        Products cheese = new Products("cheese", 2, 10, false, LocalDate.of(2025, 10, 9), true, .3);
        Products biscuits = new Products("Biscuits", 1.5, 20, false, LocalDate.of(2025, 10, 22), true, .5);

        Cart cart = new Cart();
        cart.addItem(cheese, 2);
        cart.addItem(biscuits, 3);
        
        Customers customer = new Customers(20);
        cart.checkout(customer);
        
    }
}