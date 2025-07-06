import java.time.LocalDate;

public class ShippableExpirableProduct extends Product implements Expirable, Shippable{
    
    private LocalDate expirationDate;
    private double weight;

    public ShippableExpirableProduct(String name, double price, int quantity, LocalDate expirationDate, double weight) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
        this.weight = weight;
    }

    @Override
    public LocalDate getExpirableDate() {
        return expirationDate;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
