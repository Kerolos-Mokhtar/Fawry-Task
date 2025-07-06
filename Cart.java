import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Cart {

    List<CartItem> products = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (quantity <= 0) {
            System.out.println("can't add this quantity.");
            return;
        }
        products.add(new CartItem(product, quantity));
    }

    public void checkOut(Customer customer) {
        double subtotal = 0;
        double shipping = 0;
        double totalPackageWeight = 0;

        if (products.isEmpty()) {
            System.out.println("Cart is Empty.");
            return;
        }

        for (CartItem c : products) {
            // Ensure product quantity
            if (c.getQuantity() > c.getProduct().getQuantity()) {
                System.out.println(c.getProduct().getName() + " is out of stock.");
                System.out.println("Available stock: " + c.getProduct().getQuantity());
                return;
            }

            // Ensure product expiration
            if (c.getProduct() instanceof Expirable) {
                Expirable exp = (Expirable) c.getProduct();
                if (exp.getExpirableDate().isBefore(LocalDate.now())) {
                    System.out.println("Error: " + c.getProduct().getName() + " is expired.");
                    return;
                }
            }
        }

        List<CartItem> shippableProducts = new ArrayList<>();

        // Calculate subtotal & shipping
        for (CartItem c : products) {
            subtotal += c.getProduct().getPrice() * c.getQuantity();

            if (c.getProduct() instanceof Shippable) {
                shippableProducts.add(c);
                double itemWeight = c.getQuantity() * ((Shippable) c.getProduct()).getWeight();
                totalPackageWeight += itemWeight;
            }
        }

        shipping = totalPackageWeight * .5;

        double total = subtotal + shipping;

        if (customer.getBalance() < total) {
            System.out.println("Insufficient balance.");
            return;
        }
        
        customer.deductBalance(total);

        for (CartItem c : products) {
            c.getProduct().reduceQuantity(c.getQuantity());
        }

        // Print shipment notice 
        if (!shippableProducts.isEmpty()) {
            System.out.println("\n** Shipment notice **");
            for (CartItem c : shippableProducts) {
                double itemWeightGram = c.getQuantity() * ((Shippable) c.getProduct()).getWeight() * 1000;
                System.out.printf("%dx %-10s: %.0fg\n",
                        c.getQuantity(),
                        c.getProduct().getName(),
                        itemWeightGram);
            }
            System.out.printf("Total package weight: %.1fkg\n", totalPackageWeight);
        }

        // Print checkout receipt 
        System.out.println("\n** Checkout receipt **");
        for (CartItem c : products) {
            System.out.printf("%dx %-10s: %.0f\n",
                    c.getQuantity(),
                    c.getProduct().getName(),
                    c.getProduct().getPrice() * c.getQuantity());
        }

        System.out.println("----------------------");
        System.out.printf("Subtotal: %.0f\n", subtotal);
        System.out.printf("Shipping: %.0f\n", shipping);
        System.out.printf("Amount: %.0f\n", total);
        System.out.printf("Customer remaining balance: %.0f\n", customer.getBalance());
    }

}
