import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(Products products, int quantity) {
        items.add(new CartItem(products, quantity));
    }

    public void checkout(Customers customer) {
        double subtotal = 0.0;
        double shippingFees = 0.0;
        double totalPackageWeight = 0.0;

        List<ShippableItem> shippableItems = new ArrayList<>();

        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        for (CartItem item : items) {
            Products product = item.getProduct();

            if (product.getQuantity() < item.getQuantity()) {
                System.out.println("Error: " + product.getProductName() + " is out of stock.");
                return;
            }

            if (product.isExpired()) {
                System.out.println("Error: " + product.getProductName() + " is expired.");
                return;
            }
        }

        for (CartItem item : items) {
            Products product = item.getProduct();

            subtotal += item.getTotalPrice();

            if (product.isShippable()) {
                double itemWeight = product.getWeight() * item.getQuantity();
                totalPackageWeight += itemWeight;
                shippingFees += itemWeight * .5;

                shippableItems.add(new ShippableItem() {
                    @Override
                    public String getName() {
                        return product.getProductName();
                    }

                    @Override
                    public double getWeight() {
                        return product.getWeight();
                    }
                });
            }
        }

        double total = subtotal + shippingFees;

        if (customer.getBalance() < total) {
            System.out.println("Error: Insufficient balance.");
            return;
        }

        for (CartItem item : items) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }
        customer.deductBalance(total);

        // === Shipment notice ===
        if (!shippableItems.isEmpty()) {
            System.out.println("\n** Shipment notice **");
            for (CartItem item : items) {
                Products product = item.getProduct();
                if (product.isShippable()) {
                    double totalWeight = product.getWeight() * item.getQuantity();
                    System.out.println(item.getQuantity()+ "x " + product.getProductName()+ ": " + totalWeight);
                }
            }
            System.out.println("Total package weight: " + totalPackageWeight +"g");
        }

        // === Checkout receipt ===
        System.out.println("\n** Checkout receipt **");
        for (CartItem item : items) {
            Products product = item.getProduct();
            double itemTotal = item.getTotalPrice();
            System.out.println(item.getQuantity() + "x " + product.getProductName() + ": " + itemTotal);
        }
        System.out.println(" ----------------------");
        System.out.println("Subtotal: $"+ subtotal);
        System.out.println("Shipping: $"+ shippingFees);
        System.out.println("Amount  :$"+ total);
    }
}